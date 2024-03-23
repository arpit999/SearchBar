/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.searchbar.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Material 3 color schemes
private val searchBarDarkColorScheme = darkColorScheme(
    primary = searchBarDarkPrimary,
    onPrimary = searchBarDarkOnPrimary,
    primaryContainer = searchBarDarkPrimaryContainer,
    onPrimaryContainer = searchBarDarkOnPrimaryContainer,
    inversePrimary = searchBarDarkPrimaryInverse,
    secondary = searchBarDarkSecondary,
    onSecondary = searchBarDarkOnSecondary,
    secondaryContainer = searchBarDarkSecondaryContainer,
    onSecondaryContainer = searchBarDarkOnSecondaryContainer,
    tertiary = searchBarDarkTertiary,
    onTertiary = searchBarDarkOnTertiary,
    tertiaryContainer = searchBarDarkTertiaryContainer,
    onTertiaryContainer = searchBarDarkOnTertiaryContainer,
    error = searchBarDarkError,
    onError = searchBarDarkOnError,
    errorContainer = searchBarDarkErrorContainer,
    onErrorContainer = searchBarDarkOnErrorContainer,
    background = searchBarDarkBackground,
    onBackground = searchBarDarkOnBackground,
    surface = searchBarDarkSurface,
    onSurface = searchBarDarkOnSurface,
    inverseSurface = searchBarDarkInverseSurface,
    inverseOnSurface = searchBarDarkInverseOnSurface,
    surfaceVariant = searchBarDarkSurfaceVariant,
    onSurfaceVariant = searchBarDarkOnSurfaceVariant,
    outline = searchBarDarkOutline
)

private val searchBarLightColorScheme = lightColorScheme(
    primary = searchBarLightPrimary,
    onPrimary = searchBarLightOnPrimary,
    primaryContainer = searchBarLightPrimaryContainer,
    onPrimaryContainer = searchBarLightOnPrimaryContainer,
    inversePrimary = searchBarLightPrimaryInverse,
    secondary = searchBarLightSecondary,
    onSecondary = searchBarLightOnSecondary,
    secondaryContainer = searchBarLightSecondaryContainer,
    onSecondaryContainer = searchBarLightOnSecondaryContainer,
    tertiary = searchBarLightTertiary,
    onTertiary = searchBarLightOnTertiary,
    tertiaryContainer = searchBarLightTertiaryContainer,
    onTertiaryContainer = searchBarLightOnTertiaryContainer,
    error = searchBarLightError,
    onError = searchBarLightOnError,
    errorContainer = searchBarLightErrorContainer,
    onErrorContainer = searchBarLightOnErrorContainer,
    background = searchBarLightBackground,
    onBackground = searchBarLightOnBackground,
    surface = searchBarLightSurface,
    onSurface = searchBarLightOnSurface,
    inverseSurface = searchBarLightInverseSurface,
    inverseOnSurface = searchBarLightInverseOnSurface,
    surfaceVariant = searchBarLightSurfaceVariant,
    onSurfaceVariant = searchBarLightOnSurfaceVariant,
    outline = searchBarLightOutline
)

@Composable
fun SearchBarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val searchBarColorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> searchBarDarkColorScheme
        else -> searchBarLightColorScheme
    }

    MaterialTheme(
        colorScheme = searchBarColorScheme,
        typography = searchBarTypography,
        shapes = shapes,
        content = content
    )
}
