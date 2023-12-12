package com.makaia.back4.JpaMySql.controllers;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Notificacion;
import com.makaia.back4.JpaMySql.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notificacion")
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping()
    public Notificacion crearNotificacion(@RequestBody CrearDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Notificacion> listarNotificacion(){
        return  this.service.listar();
    }
}
