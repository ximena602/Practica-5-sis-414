package com.Practica.pelicula.Controller;

import com.Practica.pelicula.Entity.EntityPelicula;
import com.Practica.pelicula.Service.ServicePelicula;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@Tag(name = "Películas API", description = "CRUD de la tabla Peliculas")
public class ControllerPelicula {

    private final ServicePelicula service;

    public ControllerPelicula(ServicePelicula service) {
        this.service = service;
    }

    @Operation(summary = "Listar Películas",
            description = "Obtiene todas las películas registradas")
    @GetMapping
    public List<EntityPelicula> obtenerPeliculas() {
        return service.listar();
    }

    @Operation(summary = "Obtener Películas por id",
            description = "Busca una película usando su identificador")
    @GetMapping("/{id}")
    public EntityPelicula obtenerPelicula(@PathVariable Integer id) {
        return service.buscar(id);
    }

    @Operation(summary = "Registrar nuevas Películas",
            description = "Agrega una nueva película al sistema")
    @PostMapping
    public EntityPelicula agregarPelicula(@RequestBody EntityPelicula pelicula) {
        return service.guardar(pelicula);
    }

    @Operation(summary = "Actualizar Películas por id",
            description = "Modifica los campos de una película localizándola por su ID")
    @PutMapping("/{id}")
    public EntityPelicula actualizarPelicula(@PathVariable Integer id, @RequestBody EntityPelicula pelicula) {
        return service.actualizar(id, pelicula);
    }

    @Operation(summary = "Eliminar Películas por id",
            description = "Borra un registro de forma permanente")
    @DeleteMapping("/{id}")
    public String eliminarPelicula(@PathVariable Integer id) {
        service.eliminar(id);
        return "Película eliminada correctamente";
    }
}
