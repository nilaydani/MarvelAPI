package com.lbg.demo.marvel_heroes.domain.model.hero_detail

import com.lbg.demo.core.util.Constants.ZERO

data class CharacterStatModel(
    val iconResId: Int = ZERO,
    val statTitleResId: Int = ZERO,
    val statValue: Int = ZERO,
)