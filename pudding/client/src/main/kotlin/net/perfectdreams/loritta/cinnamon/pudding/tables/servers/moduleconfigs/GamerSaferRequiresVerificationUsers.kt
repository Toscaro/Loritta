package net.perfectdreams.loritta.cinnamon.pudding.tables.servers.moduleconfigs

import net.perfectdreams.exposedpowerutils.sql.javatime.timestampWithTimeZone
import org.jetbrains.exposed.dao.id.LongIdTable

object GamerSaferRequiresVerificationUsers : LongIdTable() {
    val guild = long("guild").index()
    val role = long("role").index()
    val user = long("user").index()
    val triggeredAt = timestampWithTimeZone("triggered_at")
    // val checkPeriod = long("check_period").index()
}