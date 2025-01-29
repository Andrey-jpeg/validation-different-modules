package com.example

import jakarta.validation.constraints.NotNull

@MyAnnotation
data class Request(
    val list: List<@NotNull String>
)
