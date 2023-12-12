package com.makaia.back4.JpaMySql.dtos;

import com.makaia.back4.JpaMySql.entities.Usuario;

import java.util.Date;
import java.util.Objects;

public class CrearDTO {
    private String type;

    private Date fechaNotificaion;

    private Long emisor_id;

    private Long noficado_id;


    public CrearDTO() {
    }

    public CrearDTO(String type, Date fechaNotificaion, Long emisor_id, Long noficado_id) {
        this.type = type;
        this.fechaNotificaion = fechaNotificaion;
        this.emisor_id = emisor_id;
        this.noficado_id = noficado_id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getFechaNotificaion() {
        return this.fechaNotificaion;
    }

    public void setFechaNotificaion(Date fechaNotificaion) {
        this.fechaNotificaion = fechaNotificaion;
    }

    public Long getEmisor_id() {
        return this.emisor_id;
    }

    public void setEmisor_id(Long emisor_id) {
        this.emisor_id = emisor_id;
    }

    public Long getNoficado_id() {
        return this.noficado_id;
    }

    public void setNoficado_id(Long noficado_id) {
        this.noficado_id = noficado_id;
    }

    public CrearDTO type(String type) {
        setType(type);
        return this;
    }

    public CrearDTO fechaNotificaion(Date fechaNotificaion) {
        setFechaNotificaion(fechaNotificaion);
        return this;
    }

    public CrearDTO emisor_id(Long emisor_id) {
        setEmisor_id(emisor_id);
        return this;
    }

    public CrearDTO noficado_id(Long noficado_id) {
        setNoficado_id(noficado_id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CrearDTO)) {
            return false;
        }
        CrearDTO crearDTO = (CrearDTO) o;
        return Objects.equals(type, crearDTO.type) && Objects.equals(fechaNotificaion, crearDTO.fechaNotificaion) && Objects.equals(emisor_id, crearDTO.emisor_id) && Objects.equals(noficado_id, crearDTO.noficado_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fechaNotificaion, emisor_id, noficado_id);
    }

    @Override
    public String toString() {
        return "{" +
            " type='" + getType() + "'" +
            ", fechaNotificaion='" + getFechaNotificaion() + "'" +
            ", emisor_id='" + getEmisor_id() + "'" +
            ", noficado_id='" + getNoficado_id() + "'" +
            "}";
    }


}
