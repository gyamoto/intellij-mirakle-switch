package com.gyamoto.common

import com.intellij.ide.util.PropertiesComponent

object MirakleConfig {

    private val properties = PropertiesComponent.getInstance()

    var isEnabled: Boolean by properties.asBoolean("is_enabled", false)

    fun toggleEnabled() {
        isEnabled = !isEnabled
    }
}
