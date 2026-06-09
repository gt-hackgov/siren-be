package com.siren.app.repository;

import com.siren.app.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertasRepository extends JpaRepository<Alerta, Long> {

    public List<Alerta> findAllByNivelUrgencia(@Param("nivel_urgencia") Integer nivelUrgencia);

}
