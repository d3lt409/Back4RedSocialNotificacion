package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Notificacion;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.repositories.NotificacionRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {

    NotificacionRepository repository;
    UsuarioRepository usuarioRepository;

    @Autowired
    public Service(NotificacionRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Notificacion crear(CrearDTO dto) {
        Usuario emisor = this.usuarioRepository
                .findById(dto.getEmisor_id())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede enviar Notificacions"));
        Usuario receptor = this.usuarioRepository
                .findById(dto.getNoficado_id())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede recibir Notificacion"));
        Notificacion nuevoNotificacion = new Notificacion(dto.getType(),dto.getFechaNotificaion(),emisor, receptor);
        return this.repository.save(nuevoNotificacion);
    }

    public List<Notificacion> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }
}