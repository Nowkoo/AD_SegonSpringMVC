package com.example.segonspringmvc.repository

import com.example.segonspringmvc.model.comarca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ComarcaRepository: JpaRepository<comarca, String> {
    fun findByProvincia(provincia: String): List<comarca>

    @Query("SELECT c FROM comarca c WHERE c.provincia = :provincia")
    fun findComarcasPorProvincia(@Param("provincia") provincia: String): List<comarca>
}