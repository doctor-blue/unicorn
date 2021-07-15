/**
 * Create by Nguyen Van Tan from Dev Comentry (07/2021)
 */
package com.devcomentry.moonlight.binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

@BindingOnly
fun <T : ViewDataBinding> ViewGroup.binding(
    @LayoutRes layoutRes: Int,
    attachToParent: Boolean = false
): T {
    return DataBindingUtil.inflate(
        LayoutInflater.from(context), layoutRes, this, attachToParent
    )
}

@BindingOnly
fun <T : ViewDataBinding> ViewGroup.binding(
    @LayoutRes layoutRes: Int,
    attachToParent: Boolean = false,
    block: T.() -> Unit
): T {
    return binding<T>(layoutRes, attachToParent).apply(block)
}

@JvmSynthetic
inline fun <reified R> Any?.ifNotNull(
    ifNotNull: (R) -> Unit
): Any? {
    if (this != null && this is R) {
        ifNotNull(this)
    }
    return this
}