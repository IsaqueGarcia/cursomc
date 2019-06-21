package com.isaquegarcia.aula01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isaquegarcia.aula01.domain.Estado;

@Repository
public interface EstadoRepositoy extends JpaRepository<Estado, Integer>{

}
