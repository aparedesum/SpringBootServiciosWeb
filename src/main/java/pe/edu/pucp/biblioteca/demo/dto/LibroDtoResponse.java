package pe.edu.pucp.biblioteca.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import pe.edu.pucp.biblioteca.demo.model.Libro;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonInclude(Include.NON_NULL)
public class LibroDtoResponse {

    public LibroDtoResponse(Libro book) {
        this.id = book.getId();
        this.titulo = book.getTitulo();
        this.autor = book.getAutor();
        this.descripcion = book.getDescripcion();
        this.precio = book.getPrecio();
        this.fechaPublicacion = book.getFechaPublicacion();
        this.stock = book.getStock();
    }
    
    public LibroDtoResponse(long id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    private Long id;

    private String titulo;

    private String autor;

    private String descripcion;

    private BigDecimal precio;

    private LocalDate fechaPublicacion;

    private Integer stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}