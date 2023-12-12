package com.makaia.back4.JpaMySql.repositories;

import com.makaia.back4.JpaMySql.entities.Notificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {
}
