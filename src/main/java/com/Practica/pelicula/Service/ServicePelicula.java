package com.Practica.pelicula.Service;

import com.Practica.pelicula.Entity.EntityPelicula;
import com.Practica.pelicula.Repository.RepositoryPelicula;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicePelicula {

    private final RepositoryPelicula repository;


    public ServicePelicula(RepositoryPelicula repository) {
        this.repository = repository;
    }

    public List<EntityPelicula> listar() {
        return repository.findAll();
    }

    public EntityPelicula buscar(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public EntityPelicula guardar(EntityPelicula pelicula) {
        return repository.save(pelicula);
    }

    public EntityPelicula actualizar(Integer id, EntityPelicula peliculaActualizada) {
        EntityPelicula pelicula = repository.findById(id).orElse(null);

        if (pelicula != null) {
            pelicula.setTitulo(peliculaActualizada.getTitulo());
            pelicula.setDirector(peliculaActualizada.getDirector());
            pelicula.setAnioLanzamiento(peliculaActualizada.getAnioLanzamiento());
            pelicula.setGenero(peliculaActualizada.getGenero());
            pelicula.setSinopsis(peliculaActualizada.getSinopsis());

            return repository.save(pelicula);
        }

        return null;
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

