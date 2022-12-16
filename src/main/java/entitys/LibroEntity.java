package entitys;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "libro", schema = "biblioteca", catalog = "")
public class LibroEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic
    @Column(name = "titulo", nullable = true, length = 40)
    private String titulo;
    @Basic
    @Column(name = "autor", nullable = true, length = 40)
    private String autor;
    @Basic
    @Column(name = "editorial", nullable = true, length = 40)
    private String editorial;
    @Basic
    @Column(name = "ano", nullable = true)
    private Integer ano;
    @Basic
    @Column(name = "isbn", nullable = false, length = 40)
    private String isbn;
    @Basic
    @Column(name = "numeroEjemplares", nullable = true)
    private Integer numeroEjemplares;
    @Basic
    @Column(name = "numeroPaginas", nullable = true)
    private Integer numeroPaginas;
    @OneToMany(mappedBy = "libroByCodigoLibro")
    private Collection<PrestamoEntity> prestamosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(Integer numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibroEntity that = (LibroEntity) o;

        if (id != that.id) return false;
        if (codigo != that.codigo) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (autor != null ? !autor.equals(that.autor) : that.autor != null) return false;
        if (editorial != null ? !editorial.equals(that.editorial) : that.editorial != null) return false;
        if (ano != null ? !ano.equals(that.ano) : that.ano != null) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (numeroEjemplares != null ? !numeroEjemplares.equals(that.numeroEjemplares) : that.numeroEjemplares != null)
            return false;
        if (numeroPaginas != null ? !numeroPaginas.equals(that.numeroPaginas) : that.numeroPaginas != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "LibroEntity{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", ano=" + ano +
                ", isbn='" + isbn + '\'' +
                ", numeroEjemplares=" + numeroEjemplares +
                ", numeroPaginas=" + numeroPaginas +
                ", prestamosById=" + prestamosById +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + codigo;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (editorial != null ? editorial.hashCode() : 0);
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (numeroEjemplares != null ? numeroEjemplares.hashCode() : 0);
        result = 31 * result + (numeroPaginas != null ? numeroPaginas.hashCode() : 0);
        return result;
    }

    public Collection<PrestamoEntity> getPrestamosById() {
        return prestamosById;
    }

    public void setPrestamosById(Collection<PrestamoEntity> prestamosById) {
        this.prestamosById = prestamosById;
    }
}
