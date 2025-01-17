package net.perfectdreams.loritta.morenitta.utils

import mu.KotlinLogging
import net.dv8tion.jda.api.EmbedBuilder
import net.perfectdreams.loritta.cinnamon.discord.utils.RunnableCoroutine
import net.perfectdreams.loritta.cinnamon.emotes.Emotes
import net.perfectdreams.loritta.cinnamon.pudding.tables.BotVotesUserAvailableNotifications
import net.perfectdreams.loritta.i18n.I18nKeysData
import net.perfectdreams.loritta.morenitta.LorittaBot
import net.perfectdreams.loritta.morenitta.utils.extensions.await
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import java.time.Instant

class BotVotesNotifier(val m: LorittaBot) : RunnableCoroutine {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    override suspend fun run() {
        val now = Instant.now()

        m.transaction {
            // Get all users that needs to be notified
            val usersToBeNotifiedData = BotVotesUserAvailableNotifications.select {
                BotVotesUserAvailableNotifications.notified eq false and (BotVotesUserAvailableNotifications.notifyAt lessEq now)
            }.toList()

            // Notify them!
            for (userToBeNotifiedData in usersToBeNotifiedData) {
                val userId = userToBeNotifiedData[BotVotesUserAvailableNotifications.userId]

                try {
                    val user = m.lorittaShards.retrieveUserById(userId)

                    if (user != null) {
                        logger.info { "Notifying user ${user.idLong} about top.gg vote..." }
                        user.openPrivateChannel().await()
                            .sendMessageEmbeds(
                                EmbedBuilder()
                                    .setColor(Constants.LORITTA_AQUA)
                                    .setThumbnail("https://assets.perfectdreams.media/loritta/loritta-happy.gif")
                                    .setTitle("${m.languageManager.defaultI18nContext.get(I18nKeysData.Commands.Command.Vote.Notification.Topgg.Title)} ${Emotes.LoriSmile}")
                                    .setDescription(
                                        (m.languageManager.defaultI18nContext.get(I18nKeysData.Commands.Command.Vote.Notification.Topgg.Description(Emotes.LoriLurk.toString(), Emotes.LoriHeart.toString())) + "https://top.gg/bot/${m.config.loritta.discord.applicationId}/vote")
                                            .joinToString("\n\n")
                                    )
                                    .build()
                            )
                            .await()
                    }
                } catch (e: Exception) {}
            }

            BotVotesUserAvailableNotifications.update({ BotVotesUserAvailableNotifications.id inList usersToBeNotifiedData.map { it[BotVotesUserAvailableNotifications.id] }}) {
                it[BotVotesUserAvailableNotifications.notified] = true
            }
        }
    }
}