package com.umg.edu.gt.progra2Library.Repository;

import com.umg.edu.gt.progra2Library.Model.Libro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

}
