package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.Examen;
import com.example.backendh93p1.entity.Pregunta;
import com.example.backendh93p1.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> busquedapregunta (){
        return (List<Pregunta>) preguntaService.obtenerPreguntas();
    }

    @PostMapping
    public void crearpregunta (@RequestBody Pregunta preguntaClient){
        preguntaService.agregarPregunta(preguntaClient);
    }

    @PutMapping
    public void actualizarPregunta (@RequestBody Pregunta preguntaClient){
        preguntaService.actualizarPregunta(preguntaClient);
    }

    @GetMapping (value = "{id}")
    public Pregunta obtenerPreguntaId (@PathVariable ("idpregunta") Long idpregunta){
        return preguntaService.obtenerPregunta(idpregunta)
    }
}
