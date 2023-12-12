package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Date fechaNotificaion;

    @ManyToOne(optional = false)
    Usuario enviado;

    @ManyToOne(optional = false)
    Usuario notificado;


    public Notificacion() {
    }

    public Notificacion(String type, Date fechaNotificaion, Usuario enviado, Usuario notificado) {
        this.type = type;
        this.fechaNotificaion = fechaNotificaion;
        this.enviado = enviado;
        this.notificado = notificado;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getEnviado() {
        return this.enviado;
    }

    public void setEnviado(Usuario enviado) {
        this.enviado = enviado;
    }

    public Usuario getNotificado() {
        return this.notificado;
    }

    public void setNotificado(Usuario notificado) {
        this.notificado = notificado;
    }

    public Notificacion id(Long id) {
        setId(id);
        return this;
    }

    public Notificacion type(String type) {
        setType(type);
        return this;
    }

    public Notificacion fechaNotificaion(Date fechaNotificaion) {
        setFechaNotificaion(fechaNotificaion);
        return this;
    }

    public Notificacion enviado(Usuario enviado) {
        setEnviado(enviado);
        return this;
    }

    public Notificacion notificado(Usuario notificado) {
        setNotificado(notificado);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Notificacion)) {
            return false;
        }
        Notificacion notificacion = (Notificacion) o;
        return Objects.equals(id, notificacion.id) && Objects.equals(type, notificacion.type) && Objects.equals(fechaNotificaion, notificacion.fechaNotificaion) && Objects.equals(enviado, notificacion.enviado) && Objects.equals(notificado, notificacion.notificado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, fechaNotificaion, enviado, notificado);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", type='" + getType() + "'" +
            ", fechaNotificaion='" + getFechaNotificaion() + "'" +
            ", enviado='" + getEnviado() + "'" +
            ", notificado='" + getNotificado() + "'" +
            "}";
    }

  
}
