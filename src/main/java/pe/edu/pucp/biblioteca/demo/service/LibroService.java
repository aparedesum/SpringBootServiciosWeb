package pe.edu.pucp.biblioteca.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.pucp.biblioteca.demo.dto.LibroDtoRequest;
import pe.edu.pucp.biblioteca.demo.exception.ResourceNotFoundException;
import pe.edu.pucp.biblioteca.demo.model.Libro;
import pe.edu.pucp.biblioteca.demo.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getAllBooks() {
        return libroRepository.findAll();
    }

    public Libro createBook(LibroDtoRequest libroDtoRequest) {
        Libro libro = new Libro();
        libro.setPrecio(libroDtoRequest.getPrecio());
        libro.setAutor(libroDtoRequest.getAutor());
        libro.setDescripcion((libroDtoRequest.getDescripcion()));
        libro.setFechaPublicacion(libroDtoRequest.getFechaPublicacion());
        libro.setTitulo(libroDtoRequest.getTitulo());
        libro.setStock(libroDtoRequest.getStock());
        return libroRepository.save(libro);
    }

    public Libro getBookById(Long libroId) {
        return libroRepository.findById(libroId)
                .orElseThrow(() -> new ResourceNotFoundException("Libro", libroId));
    }

    public Libro updateBook(Long libroId, LibroDtoRequest bookRequest) {
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new ResourceNotFoundException("Libro", libroId));

        libro.setPrecio(bookRequest.getPrecio());
        libro.setAutor(bookRequest.getAutor());
        libro.setDescripcion((bookRequest.getDescripcion()));
        libro.setFechaPublicacion(bookRequest.getFechaPublicacion());
        libro.setTitulo(bookRequest.getTitulo());

        return libroRepository.save(libro);
    }

    public Libro updateBookStock(Long libroId, Integer newStock) {
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new ResourceNotFoundException("Libro", libroId));

        libro.setStock(newStock);

        return libroRepository.save(libro);
    }

    public void deleteBook(Long libroId) {
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new ResourceNotFoundException("Libro", libroId));

        libroRepository.delete(libro);
    }
}

