package com.umg.edu.gt.progra2Library.Controller;

import com.umg.edu.gt.progra2Library.Model.Libro;
import com.umg.edu.gt.progra2Library.Service.LibroService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private static final Logger logger = Logger.getLogger(LibroController.class);

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        logger.info("init find all");
        List<Libro> libros = libroService.findAll();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{libroId}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long libroId) {
        Optional<Libro> libro = libroService.findById(libroId);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        Libro createdLibro = libroService.save(libro);
        return ResponseEntity.status(201).body(createdLibro);
    }

    @PutMapping("/{libroId}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long libroId, @RequestBody Libro libro) {
        Optional<Libro> updatedLibro = libroService.update(libroId, libro);
        return updatedLibro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{libroId}")
    public ResponseEntity<String> deleteLibro(@PathVariable Long libroId) {
        boolean deleted = libroService.deleteById(libroId);
        return deleted ? ResponseEntity.ok("Deleted Book")
                : ResponseEntity.status(404).body("Book not found");
    }
}
