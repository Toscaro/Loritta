package net.perfectdreams.loritta.morenitta.profile.badges

import net.perfectdreams.loritta.morenitta.dao.Profile
import net.perfectdreams.loritta.morenitta.profile.Badge
import net.perfectdreams.loritta.cinnamon.pudding.tables.CollectedChristmas2019Points
import net.perfectdreams.loritta.cinnamon.pudding.tables.christmas2022.CollectedChristmas2022Points
import net.perfectdreams.loritta.cinnamon.pudding.tables.easter2023.CreatedEaster2023Baskets
import net.perfectdreams.loritta.morenitta.LorittaBot
import net.perfectdreams.loritta.morenitta.profile.ProfileDesignManager
import net.perfectdreams.loritta.morenitta.profile.ProfileUserInfoData
import org.jetbrains.exposed.sql.select
import java.util.*

class Easter2023Badge(val loritta: LorittaBot) : Badge.LorittaBadge(
	UUID.fromString("bacdf6ee-0279-4f15-a865-0cfc5fcbd720"),
	ProfileDesignManager.I18N_BADGES_PREFIX.Easter2023.Title,
	ProfileDesignManager.I18N_BADGES_PREFIX.Easter2023.Description,
	"easter2023.png",
	100
) {
	override suspend fun checkIfUserDeservesBadge(user: ProfileUserInfoData, profile: Profile, mutualGuilds: Set<Long>): Boolean {
		return loritta.pudding.transaction {
			CreatedEaster2023Baskets.select {
				CreatedEaster2023Baskets.user eq profile.id
			}.count() >= 100
		}
	}
}