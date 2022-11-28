package com.lbg.demo.core.extensions

/**
 * Returns the value of the optional [Int] using a default value when it is null
 * @param default value to return when the int is null
 * @return Value of the int if this is not null; otherwise, return the default value assigned
 */
@JvmOverloads
fun Int?.value(default: Int = 0) = this ?: default