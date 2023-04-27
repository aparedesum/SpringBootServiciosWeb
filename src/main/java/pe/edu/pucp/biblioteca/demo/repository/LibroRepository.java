package pe.edu.pucp.biblioteca.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pucp.biblioteca.demo.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
