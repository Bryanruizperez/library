package com.umg.edu.gt.progra2Library.Service;
import com.umg.edu.gt.progra2Library.Model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umg.edu.gt.progra2Library.Repository.LibroRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class LibroService {
    private static final Logger logger = Logger.getLogger(LibroService.class.getName());

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll(){
        logger.info("Prepare findAll");
        return libroRepository.findAll();
    }
    public Optional<Libro>findById(Long libroId){
        return libroRepository.findById(libroId);
    }
    public Libro save(Libro libro){
        return libroRepository.save(libro);
    }
    public boolean deleteById(Long libroId){
        if(libroRepository.existsById(libroId)){
        libroRepository.deleteById(libroId);
        return true;
        }
        return false;
    }
    public Optional<Libro> update(Long libroId, Libro libro){
        Optional <Libro> existingLibro = findById(libroId);
        if(existingLibro.isPresent()){
        Libro p = existingLibro.get();
        p.setTitle(libro.getTitle());
        p.setAutor(libro.getAutor());
        p.setIsbn(libro.getIsbn());
        p.setPublicationDate(libro.getPublicationDate());
        return Optional.of(libroRepository.save(p));
        }
        return Optional.empty();
    }
}
