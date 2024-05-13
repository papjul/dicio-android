package org.stypox.dicio.skills.current_time

import android.content.Context
import androidx.compose.runtime.Composable
import org.dicio.skill.output.SkillOutput
import org.stypox.dicio.R
import org.stypox.dicio.output.graphical.Headline

class CurrentTimeOutput(
    context: Context,
    timeStr: String,
) : SkillOutput {
    override val speechOutput = context.getString(R.string.skill_time_current_time, timeStr)

    @Composable
    override fun GraphicalOutput() {
        Headline(text = speechOutput)
    }
}
