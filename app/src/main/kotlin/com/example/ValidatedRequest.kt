package com.example

import io.micronaut.core.annotation.Introspected
import jakarta.validation.constraints.NotNull

@Introspected
data class ValidatedRequest(
    val list: List<@NotNull String>
)
