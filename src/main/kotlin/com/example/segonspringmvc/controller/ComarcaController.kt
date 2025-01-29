package com.example.segonspringmvc.controller

import com.example.segonspringmvc.model.comarca
import com.example.segonspringmvc.repository.ComarcaRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@RestController
@Controller
@RequestMapping("/comarcas")
class ComarcaController (private val comarcaRepository: ComarcaRepository) {
//    @GetMapping
//    fun obtenerComarcas(): List<comarca> = comarcaRepository.findAll()

    @GetMapping
    fun listarComarcas(model: Model): String {
        val comarcas = comarcaRepository.findAll()
        model.addAttribute("comarcas", comarcas)
        return "/vistas/comarcas"
    }
}