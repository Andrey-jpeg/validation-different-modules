package com.example

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class Request(
    val list: List<@NotNull String>,
    @field:NotBlank
    val string: String
)
