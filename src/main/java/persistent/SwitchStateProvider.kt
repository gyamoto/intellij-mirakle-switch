package com.gyamoto.persistent

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project

@State(name = "SwitchStateProvider", storages = [Storage("mirakle_switch_state.xml")])
class SwitchStateProvider : PersistentStateComponent<SwitchStateProvider.State> {

    private val switchEnabled = State()

    var isEnabled: Boolean
        get() = switchEnabled.isTurnOn
        set(value) = with(switchEnabled) {
            isTurnOn = value
        }

    override fun loadState(state: State) {
        isEnabled = state.isTurnOn
    }

    override fun getState(): State = switchEnabled

    fun toggle() {
        isEnabled = !isEnabled
    }

    inner class State {
        var isTurnOn = true
    }

    companion object {

        fun getInstance(project: Project): SwitchStateProvider =
            ServiceManager.getService(project, SwitchStateProvider::class.java)
    }
}
