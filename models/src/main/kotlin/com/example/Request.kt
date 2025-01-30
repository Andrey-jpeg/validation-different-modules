package com.example

import jakarta.validation.constraints.NotNull

data class Request(
    val list: List<@NotNull String>,
)
