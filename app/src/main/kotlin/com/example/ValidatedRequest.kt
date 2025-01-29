package com.example

import jakarta.validation.constraints.NotNull

data class ValidatedRequest(
    val list: List<@NotNull String>
)
