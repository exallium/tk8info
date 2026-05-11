package dev.ahart.tk8.info.nav

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Roster : NavKey

@Serializable
data class CharacterDetail(val spriteIndex: Int) : NavKey
