package net.perfectdreams.loritta.morenitta.dao

import net.perfectdreams.loritta.morenitta.tables.Warns
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Warn(id: EntityID<Long>) : LongEntity(id) {
	companion object : LongEntityClass<Warn>(Warns)

	var guildId by Warns.guildId
	var userId by Warns.userId
	var punishedById by Warns.punishedById
	var content by Warns.content
	var receivedAt by Warns.receivedAt
}