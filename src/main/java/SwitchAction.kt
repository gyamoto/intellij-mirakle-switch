package com.gyamoto

import com.gyamoto.common.MirakleConfig
import com.gyamoto.ui.Icons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class SwitchAction : AnAction("MirakleSwitchAction") {

    override fun actionPerformed(event: AnActionEvent) {
        event.project?.let {
            MirakleConfig.toggleEnabled()
        }
    }

    override fun update(event: AnActionEvent) {
        event.project?.let {
            val icon = if (MirakleConfig.isEnabled) Icons.ICON_SWITCH_ENABLED else Icons.ICON_SWITCH_DISABLED
            event.presentation.icon = icon

        }
    }
}
