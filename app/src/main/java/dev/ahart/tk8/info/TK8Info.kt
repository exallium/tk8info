package dev.ahart.tk8.info

import androidx.annotation.StringRes

enum class SideStep {
  SSR,
  SSL,
  SSC
}

enum class ThrowGame {
  NONE,
  ONE,
  TWO,
  CROUCH,
  FULL
}

enum class TK8Info(
  @StringRes val displayName: Int,
  val sideStep: SideStep,
  val throwGame: ThrowGame
) {
  ALISA(
    displayName = R.string.alisa,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  ANNA(
    displayName = R.string.anna,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  ARMOR_KING(
    displayName = R.string.armor_king,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.FULL
  ),
  ASUKA(
    displayName = R.string.asuka,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.TWO
  ),
  AZUCENA(
    displayName = R.string.azucena,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.CROUCH
  ),
  BRYAN(
    displayName = R.string.bryan,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  CLAUDIO(
    displayName = R.string.claudio,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  CLIVE(
    displayName = R.string.clive,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  DEVIL_JIN(
    displayName = R.string.devil_jin,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.FULL
  ),
  DRAGUNOV(
    displayName = R.string.dragunov,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.FULL
  ),
  EDDY(
    displayName = R.string.eddy,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  FAHKUMRAM(
    displayName = R.string.fahkumram,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  FENG(
    displayName = R.string.feng,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  HEIHACHI(
    displayName = R.string.heihachi,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  HWOARANG(
    displayName = R.string.hwoarang,
    sideStep = SideStep.SSC,
    throwGame = ThrowGame.FULL
  ),
  JACK_8(
    displayName = R.string.jack_8,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.FULL
  ),
  JIN(
    displayName = R.string.jin,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.FULL
  ),
  JUN(
    displayName = R.string.jun,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.TWO
  ),
  KAZUYA(
    displayName = R.string.kazuya,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  KING(
    displayName = R.string.king,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.FULL
  ),
  KUMA(
    displayName = R.string.kuma,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  LARS(
    displayName = R.string.lars,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  LAW(
    displayName = R.string.law,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.ONE
  ),
  LEE(
    displayName = R.string.lee,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  LEO(
    displayName = R.string.leo,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  LEROY(
    displayName = R.string.leroy,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  LIDIA(
    displayName = R.string.lidia,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  LILI(
    displayName = R.string.lili,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  MIARY(
    displayName = R.string.miary,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  NINA(
    displayName = R.string.nina,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.FULL
  ),
  PANDA(
    displayName = R.string.panda,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.FULL
  ),
  PAUL(
    displayName = R.string.paul,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  RAVEN(
    displayName = R.string.raven,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.ONE
  ),
  REINA(
    displayName = R.string.reina,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.TWO
  ),
  SHAHEEN(
    displayName = R.string.shaheen,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  STEVE(
    displayName = R.string.steve,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.TWO
  ),
  VICTOR(
    displayName = R.string.victor,
    sideStep = SideStep.SSR,
    throwGame = ThrowGame.NONE
  ),
  XIAOYU(
    displayName = R.string.xiaoyu,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.TWO
  ),
  YOSHIMITSU(
    displayName = R.string.yoshimitsu,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  ),
  ZAFINA(
    displayName = R.string.zafina,
    sideStep = SideStep.SSL,
    throwGame = ThrowGame.NONE
  )
}
