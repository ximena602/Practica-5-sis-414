package com.Practica.pelicula.Repository;

import com.Practica.pelicula.Entity.EntityPelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPelicula extends JpaRepository<EntityPelicula, Integer> {
}
