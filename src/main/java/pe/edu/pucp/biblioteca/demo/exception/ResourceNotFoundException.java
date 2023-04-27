package pe.edu.pucp.biblioteca.demo.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String book, Long bookId) {
        super("No se encuentran resultados del libro: " + book + ", id = " + bookId);
    }
}
