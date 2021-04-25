package com.example.app.model

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table
data class Person(
    @PrimaryKey
    val id: Int,
    val name: String
)