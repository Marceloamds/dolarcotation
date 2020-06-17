package br.com.dollar.domain.entity.currency

import java.io.Serializable

data class Currency(
    val code: String,
    val name: String
) : Serializable