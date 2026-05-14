package dev.ahart.tk8.info

import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.annotation.RememberInComposition
import androidx.compose.runtime.remember

/**
 * Represents a 'State' a character can be in such as a stance, full crouch, install, and heat.
 * Enumerated and displayed as separate sections in a character detail panel.
 */
data class CharacterState(
  @get:StringRes
  val fullName: Int,

  @get:StringRes
  val code: Int,

  @get:ArrayRes
  val notes: Int,
)

@Composable
fun rememberCharacterStates(character: TK8Info): List<CharacterState> {
  return remember(character) {
    when (character) {
      TK8Info.ALISA -> getAlisaCharacterStates()
      TK8Info.ANNA -> getAnnaCharacterStates()
      TK8Info.ARMOR_KING -> getArmorKingCharacterStates()
      TK8Info.ASUKA -> getAsukaCharacterStates()
      TK8Info.AZUCENA -> getAzucenaCharacterStates()
      TK8Info.BRYAN -> getBryanCharacterStates()
      TK8Info.CLAUDIO -> getClaudioCharacterStates()
      TK8Info.CLIVE -> getCliveCharacterStates()
      TK8Info.DEVIL_JIN -> getDevilJinCharacterStates()
      TK8Info.DRAGUNOV -> getDragunovCharacterStates()
      TK8Info.EDDY -> getEddyCharacterStates()
      TK8Info.FAHKUMRAM -> getFahkumramCharacterStates()
      TK8Info.FENG -> getFengCharacterStates()
      TK8Info.HEIHACHI -> getHeihachiCharacterStates()
      TK8Info.HWOARANG -> getHwoarangCharacterStates()
      TK8Info.JACK_8 -> getJack8CharacterStates()
      TK8Info.JIN -> getJinCharacterStates()
      TK8Info.JUN -> getJunCharacterStates()
      TK8Info.KAZUYA -> getKazuyaCharacterStates()
      TK8Info.KING -> getKingCharacterStates()
      TK8Info.KUMA -> getKumaCharacterStates()
      TK8Info.LARS -> getLarsCharacterStates()
      TK8Info.LAW -> getLawCharacterStates()
      TK8Info.LEE -> getLeeCharacterStates()
      TK8Info.LEO -> getLeoCharacterStates()
      TK8Info.LEROY -> getLeroyCharacterStates()
      TK8Info.LIDIA -> getLidiaCharacterStates()
      TK8Info.LILI -> getLiliCharacterStates()
      TK8Info.MIARY -> getMiaryCharacterStates()
      TK8Info.NINA -> getNinaCharacterStates()
      TK8Info.PANDA -> getPandaCharacterStates()
      TK8Info.PAUL -> getPaulCharacterStates()
      TK8Info.RAVEN -> getRavenCharacterStates()
      TK8Info.REINA -> getReinaCharacterStates()
      TK8Info.SHAHEEN -> getShaheenCharacterStates()
      TK8Info.STEVE -> getSteveCharacterStates()
      TK8Info.VICTOR -> getVictorCharacterStates()
      TK8Info.XIAOYU -> getXiaoyuCharacterStates()
      TK8Info.YOSHIMITSU -> getYoshimitsuCharacterStates()
      TK8Info.ZAFINA -> getZafinaCharacterStates()
    }
  }
}

@RememberInComposition
private fun getAlisaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.alisa_neutral_notes
    ),
    CharacterState(
      fullName = R.string.alisa_des_name,
      code = R.string.alisa_des_code,
      notes = R.array.alisa_des_notes
    )
  )
}

@RememberInComposition
private fun getAnnaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.anna_neutral_notes
    )
  )
}

@RememberInComposition
private fun getArmorKingCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.armor_king_neutral_notes
    )
  )
}

@RememberInComposition
private fun getAsukaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.asuka_neutral_notes
    )
  )
}

@RememberInComposition
private fun getAzucenaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.azucena_neutral_notes
    )
  )
}

@RememberInComposition
private fun getBryanCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.bryan_neutral_notes
    )
  )
}

@RememberInComposition
private fun getClaudioCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.claudio_neutral_notes
    )
  )
}

@RememberInComposition
private fun getCliveCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.clive_phx_name,
      code = R.string.clive_phx_code,
      notes = R.array.clive_phx_notes
    )
  )
}

@RememberInComposition
private fun getDevilJinCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.devil_jin_neutral_notes
    )
  )
}

@RememberInComposition
private fun getDragunovCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.dragunov_neutral_notes
    )
  )
}

@RememberInComposition
private fun getEddyCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.eddy_hsp_name,
      code = R.string.eddy_hsp_code,
      notes = R.array.eddy_hsp_notes
    )
  )
}

@RememberInComposition
private fun getFahkumramCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.fahkumram_neutral_notes
    )
  )
}

@RememberInComposition
private fun getFengCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.feng_neutral_notes
    )
  )
}

@RememberInComposition
private fun getHeihachiCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.heihachi_neutral_notes
    )
  )
}

@RememberInComposition
private fun getHwoarangCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.hwoarang_neutral_notes
    )
  )
}

@RememberInComposition
private fun getJack8CharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.jack_8_neutral_notes
    )
  )
}

@RememberInComposition
private fun getJinCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.jin_neutral_notes
    )
  )
}

@RememberInComposition
private fun getJunCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.jun_neutral_notes
    ),
    CharacterState(
      fullName = R.string.jun_izu_name,
      code = R.string.jun_izu_code,
      notes = R.array.jun_izu_notes
    )
  )
}

@RememberInComposition
private fun getKazuyaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.kazuya_neutral_notes
    )
  )
}

@RememberInComposition
private fun getKingCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.king_neutral_notes
    )
  )
}

@RememberInComposition
private fun getKumaCharacterStates(): List<CharacterState> {
  return emptyList()
}

@RememberInComposition
private fun getLarsCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.lars_neutral_notes
    )
  )
}

@RememberInComposition
private fun getLawCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.law_neutral_notes
    )
  )
}

@RememberInComposition
private fun getLeeCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.lee_neutral_notes
    )
  )
}

@RememberInComposition
private fun getLeoCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.leo_neutral_notes
    ),
    CharacterState(
      fullName = R.string.leo_knk_name,
      code = R.string.leo_knk_code,
      notes = R.array.leo_knk_notes
    )
  )
}

@RememberInComposition
private fun getLeroyCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.leroy_neutral_notes
    )
  )
}

@RememberInComposition
private fun getLidiaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.lidia_hrs_name,
      code = R.string.lidia_hrs_code,
      notes = R.array.lidia_hrs_notes
    )
  )
}

@RememberInComposition
private fun getLiliCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.lili_neutral_notes
    )
  )
}

@RememberInComposition
private fun getMiaryCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.miary_bao_name,
      code = R.string.miary_bao_code,
      notes = R.array.miary_bao_notes
    )
  )
}

@RememberInComposition
private fun getNinaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.nina_neutral_notes
    )
  )
}

@RememberInComposition
private fun getPandaCharacterStates(): List<CharacterState> {
  return emptyList()
}

@RememberInComposition
private fun getPaulCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.paul_neutral_notes
    )
  )
}

@RememberInComposition
private fun getRavenCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.raven_neutral_notes
    )
  )
}

@RememberInComposition
private fun getReinaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.reina_neutral_notes
    ),
    CharacterState(
      fullName = R.string.reina_sen_name,
      code = R.string.reina_sen_code,
      notes = R.array.reina_sen_notes
    )
  )
}

@RememberInComposition
private fun getShaheenCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.shaheen_snk_name,
      code = R.string.shaheen_snk_code,
      notes = R.array.shaheen_snk_notes
    )
  )
}

@RememberInComposition
private fun getSteveCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.steve_neutral_notes
    )
  )
}

@RememberInComposition
private fun getVictorCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.victor_neutral_notes
    )
  )
}

@RememberInComposition
private fun getXiaoyuCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.xiaoyu_bt_name,
      code = R.string.xiaoyu_bt_code,
      notes = R.array.xiaoyu_bt_notes
    )
  )
}

@RememberInComposition
private fun getYoshimitsuCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.neutral_name,
      code = R.string.neutral_code,
      notes = R.array.yoshimitsu_neutral_notes
    )
  )
}

@RememberInComposition
private fun getZafinaCharacterStates(): List<CharacterState> {
  return listOf(
    CharacterState(
      fullName = R.string.zafina_trt_name,
      code = R.string.zafina_trt_code,
      notes = R.array.zafina_trt_notes
    )
  )
}
