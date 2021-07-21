package com.srivathsanvenkateswaran.meditationui.utils

import com.srivathsanvenkateswaran.meditationui.R
import com.srivathsanvenkateswaran.meditationui.ui.theme.*

object DummyData {
    var chips: List<String> = mutableListOf(
        "Sweet sleep",
        "Insomnia",
        "Depression"
    )

    var name: String = "Srivathsan"

    var features: List<Feature> = listOf(
        Feature(
            title = "Sleep meditation",
            R.drawable.ic_headphone,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Feature(
            title = "Tips for sleeping",
            R.drawable.ic_videocam,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        Feature(
            title = "Night island",
            R.drawable.ic_headphone,
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ),
        Feature(
            title = "Calming sounds",
            R.drawable.ic_headphone,
            Beige1,
            Beige2,
            Beige3
        )
    )
}