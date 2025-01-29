package com.example.segonspringmvc.repository

import com.example.segonspringmvc.model.comarca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComarcaRepository: JpaRepository<comarca, String> {
    fun findByProvincia(provincia: String): List<comarca>
}