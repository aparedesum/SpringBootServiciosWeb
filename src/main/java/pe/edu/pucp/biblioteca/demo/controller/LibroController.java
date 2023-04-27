package pe.edu.pucp.biblioteca.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pucp.biblioteca.demo.dto.LibroDtoRequest;
import pe.edu.pucp.biblioteca.demo.dto.LibroDtoResponse;
import pe.edu.pucp.biblioteca.demo.model.Libro;
import pe.edu.pucp.biblioteca.demo.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService bookService) {
        this.libroService = bookService;
    }

    @GetMapping
    public List<LibroDtoResponse> getAllBooks() {
        return libroService.getAllBooks().stream().map(book -> new LibroDtoResponse(book.getId(), book.getTitulo(), book.getDescripcion())).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<LibroDtoResponse> createBook(@Valid @RequestBody LibroDtoRequest libro) {
        Libro savedBook = libroService.createBook(libro);
        return new ResponseEntity<>(new LibroDtoResponse(savedBook), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDtoResponse> getBookById(@PathVariable(value = "id") Long libroId) {
        Libro libro = libroService.getBookById(libroId);
        return ResponseEntity.ok().body(new LibroDtoResponse(libro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDtoResponse> updateBook(@PathVariable(value = "id") Long libroId,
                                           @Valid @RequestBody LibroDtoRequest request) {
        final Libro libroActualizado = libroService.updateBook(libroId, request);
        return ResponseEntity.ok(new LibroDtoResponse(libroActualizado));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LibroDtoResponse> updateBookStock(@PathVariable(value = "id") Long libroId,
                                                        @Valid @RequestBody LibroDtoRequest request) {
        final Libro libroActualizado = libroService.updateBookStock(libroId, request.getStock());
        return ResponseEntity.ok(new LibroDtoResponse(libroActualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long libroId) {
        libroService.deleteBook(libroId);
        return ResponseEntity.noContent().build();
    }
}
