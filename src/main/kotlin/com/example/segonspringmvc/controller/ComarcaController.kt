package com.example.segonspringmvc.controller

import com.example.segonspringmvc.model.comarca
import com.example.segonspringmvc.repository.ComarcaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comarca")
class ComarcaController (private val comarcaRepository: ComarcaRepository) {
    @GetMapping
    fun obtenerComarcas(): List<comarca> = comarcaRepository.findAll()
}