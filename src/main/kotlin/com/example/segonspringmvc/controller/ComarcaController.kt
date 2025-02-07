package com.example.segonspringmvc.controller

import com.example.segonspringmvc.model.comarca
import com.example.segonspringmvc.repository.ComarcaRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

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

//    @GetMapping("/buscar")
//    fun buscarComarcasPorProvincia(@RequestParam provincia: String): List<comarca> {
//        return comarcaRepository.findComarcasPorProvincia(provincia)
//    }

    @GetMapping("/buscar")
    fun buscarComarcasPorProvincia(@RequestParam provincia: String, model: Model): String {
        val comarcas = comarcaRepository.findComarcasPorProvincia(provincia)
        model.addAttribute("comarcas", comarcas)
        return "/vistas/comarcas"
    }

    @GetMapping("/nueva")
    fun mostrarFormularioNuevaComarca(model: Model): String {
        model.addAttribute("comarca", comarca())
        return "/vistas/nueva-comarca"
    }

    @PostMapping("/nueva")
    fun guardarComarca(@ModelAttribute comarca: comarca): String {
        comarcaRepository.save(comarca)
        return "redirect:/comarcas"
    }

    @GetMapping("/editar/{id}")
    fun mostrarFormularioComarca(@PathVariable id: String, model: Model): String {
        val comarca = comarcaRepository.findById(id).orElseThrow { IllegalArgumentException("Comarca no encontrada: $id") }
        model.addAttribute("comarca", comarca)
        return "editar-comarcas"
    }

    @PostMapping("/editar{id}")
    fun actualizarComarca(@PathVariable id: String, @ModelAttribute comarca: comarca): String {
        if (!comarcaRepository.existsById(id)) {
            throw IllegalArgumentException("Comarca no encontrada: $id")
        }
        comarcaRepository.save(comarca)
        return "redirect:/comarcas"
    }
}