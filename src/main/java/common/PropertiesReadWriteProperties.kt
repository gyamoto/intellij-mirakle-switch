package com.gyamoto.common

import com.intellij.ide.util.PropertiesComponent
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal fun PropertiesComponent.asBoolean(key: String, default: Boolean) = PropertiesReadWriteProperty(
    properties = this,
    get = { getBoolean(key, default) },
    set = { value -> setValue(key, value) }
)

internal class PropertiesReadWriteProperty<T>(
    private val properties: PropertiesComponent,
    val get: PropertiesComponent.() -> T,
    val set: PropertiesComponent.(value: T) -> Unit
) : ReadWriteProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T = properties.get()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) = properties.set(value)
}
