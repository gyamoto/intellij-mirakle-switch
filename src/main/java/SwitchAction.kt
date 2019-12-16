package com.gyamoto

import com.gyamoto.persistent.SwitchStateProvider
import com.gyamoto.ui.Icons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class SwitchAction : AnAction("MirakleSwitchAction") {

    override fun actionPerformed(event: AnActionEvent) {
        event.project?.let {
            SwitchStateProvider.getInstance(it).toggle()
        }
    }

    override fun update(event: AnActionEvent) {
        event.project?.let {
            val isEnabled = SwitchStateProvider.getInstance(it).isEnabled
            event.presentation.icon = if (isEnabled) Icons.ICON_SWITCH_ENABLED else Icons.ICON_SWITCH_DISABLED
        }
    }

}
