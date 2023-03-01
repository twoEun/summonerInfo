package com.kkc.entity.dto

import com.kkc.entity.Constants.SPECIAL_ITEM_URL
import com.kkc.entity.data.GameInfo
import com.kkc.entity.data.GameSpellsInfo
import java.util.Date

data class GameInfoDto(
    val mmr: Int,
    val isWin: Boolean,
    val gameResult: String,
    val playMinutes: Int,
    val playSeconds: Int,
    val championImage: String,
    val gameBadge: String?,
    val gameBadgeVisible: Boolean,
    var gameBadgeBackground: Int? = null,
    val spells: Array<String?>,
    val killCount: Int,
    val assistCount: Int,
    val deathCount: Int,
    val contributionForKillRate: String,
    val items: Array<String?>,
    val specialItem: String? = null,
    val gameType: String,
    val createOrigin: Long,
    val createHours: Int,
    val createMinutes: Int,
    val multiKillBadge: String?,
    val multiKillBadgeVisible: Boolean
) {
    companion object {
        fun fromGameResponse(gameInfo: GameInfo): GameInfoDto {
            val itemInfos = arrayOfNulls<String?>(6)
            var specialItemExist = false
            gameInfo.itemInfo.forEachIndexed { index, gameItemInfo ->
                if (index < 6) {
                    if (gameItemInfo.itemImage == SPECIAL_ITEM_URL) {
                        specialItemExist = true
                    } else {
                        itemInfos[index] = gameItemInfo.itemImage
                    }
                }
            }

            val term = Date().time - gameInfo.createDate / 1000 / 60
            val termHours = (term / 60).toInt()
            val termMinutes = (term % 60).toInt()

            return GameInfoDto(
                mmr = gameInfo.mmr,
                isWin = gameInfo.isWin,
                gameResult = if (gameInfo.isWin) "승" else "패",
                playMinutes = gameInfo.playTime / 60,
                playSeconds = gameInfo.playTime % 60,
                championImage = gameInfo.championInfo.championImage,
                gameBadge = gameInfo.gameStateInfo.gameGeneralInfo.opScoreBadge,
                gameBadgeVisible = !gameInfo.gameStateInfo.gameGeneralInfo.opScoreBadge.isNullOrBlank(),
                spells = spellInfoConvertToArray(gameInfo.spellInfo),
                killCount = gameInfo.gameStateInfo.gameGeneralInfo.killCount,
                assistCount = gameInfo.gameStateInfo.gameGeneralInfo.assistCount,
                deathCount = gameInfo.gameStateInfo.gameGeneralInfo.deathCount,
                contributionForKillRate = gameInfo.gameStateInfo.gameGeneralInfo.contributionForKillRate,
                items = itemInfos,
                specialItem = if (specialItemExist) SPECIAL_ITEM_URL else null,
                gameType = gameInfo.gameType,
                createOrigin = gameInfo.createDate,
                createHours = termHours,
                createMinutes = termMinutes,
                multiKillBadge = gameInfo.gameStateInfo.gameGeneralInfo.largestMultiKillString,
                multiKillBadgeVisible = !gameInfo.gameStateInfo.gameGeneralInfo.largestMultiKillString.isNullOrBlank()
            )
        }

        private fun spellInfoConvertToArray(list: List<GameSpellsInfo>): Array<String?> {
            val spellArray = arrayOfNulls<String?>(4)
            list.forEachIndexed { index, spellInfo ->
                if (index < 4) {
                    spellArray[index] = spellInfo.spellImage
                }
            }
            return spellArray
        }
    }
}
