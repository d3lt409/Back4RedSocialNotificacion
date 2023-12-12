package com.makaia.back4.JpaMySql.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.dtos.NotificacionData;
import com.makaia.back4.JpaMySql.entities.Notificacion;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.makaia.back4.JpaMySql.services.Service;

@Component
@Slf4j
public class Consumer {

    @Autowired
    Service notificacionService;

    @RabbitListener(queues = { "comentario_creado" }) // user_created: Nombre de la cola que se quiere escuchar
    public void receive(@Payload Message object) {
        try {
            String json = new String(object.getBody(), StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            NotificacionData notificacionData = objectMapper.readValue(json, NotificacionData.class);
            log.info("Enviando notificacion para el usuario {}", notificacionData);
            CrearDTO defaultP = new CrearDTO("Comentario", new Date(), notificacionData.getEmisorId(),
                    notificacionData.getNotificadoId());
            this.notificacionService.crear(defaultP);
            log.info("notificacion enviada exitosamente {}", notificacionData);
        } catch (IOException e) {
            log.error("Error al procesar el mensaje: {}", e.getMessage());
        }

    }


}
