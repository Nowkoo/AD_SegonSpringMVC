package com.example.segonspringmvc.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="comarca")
data class comarca(
    @Id
    val nom_c: String = "",
    val provincia: String = ""
)