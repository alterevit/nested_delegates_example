package com.example.ruslankushaliev.nestedadapter.ui.entity

data class Top(
        val tittle: String,
        val delegates: List<Nested>
)

data class Nested(
        val tittle: String
)

class Image