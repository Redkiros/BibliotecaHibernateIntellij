package entitys;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "prestamo", schema = "biblioteca", catalog = "")
public class PrestamoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "fechaInicioPrestamo", nullable = true)
    private Date fechaInicioPrestamo;
    @Basic
    @Column(name = "fechaFinPrestamo", nullable = true)
    private Date fechaFinPrestamo;
    @ManyToOne
    @JoinColumn(name = "codigoLibro", referencedColumnName = "ID")
    private LibroEntity libroByCodigoLibro;
    @ManyToOne
    @JoinColumn(name = "codigoSocio", referencedColumnName = "ID")
    private SocioEntity socioByCodigoSocio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicioPrestamo() {
        return fechaInicioPrestamo;
    }

    public void setFechaInicioPrestamo(Date fechaInicioPrestamo) {
        this.fechaInicioPrestamo = fechaInicioPrestamo;
    }

    public Date getFechaFinPrestamo() {
        return fechaFinPrestamo;
    }

    public void setFechaFinPrestamo(Date fechaFinPrestamo) {
        this.fechaFinPrestamo = fechaFinPrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrestamoEntity that = (PrestamoEntity) o;

        if (id != that.id) return false;
        if (fechaInicioPrestamo != null ? !fechaInicioPrestamo.equals(that.fechaInicioPrestamo) : that.fechaInicioPrestamo != null)
            return false;
        if (fechaFinPrestamo != null ? !fechaFinPrestamo.equals(that.fechaFinPrestamo) : that.fechaFinPrestamo != null)
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "PrestamoEntity{" +
                "id=" + id +
                ", fechaInicioPrestamo=" + fechaInicioPrestamo +
                ", fechaFinPrestamo=" + fechaFinPrestamo +
                ", libroByCodigoLibro=" + libroByCodigoLibro +
                ", socioByCodigoSocio=" + socioByCodigoSocio +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaInicioPrestamo != null ? fechaInicioPrestamo.hashCode() : 0);
        result = 31 * result + (fechaFinPrestamo != null ? fechaFinPrestamo.hashCode() : 0);
        return result;
    }

    public LibroEntity getLibroByCodigoLibro() {
        return libroByCodigoLibro;
    }

    public void setLibroByCodigoLibro(LibroEntity libroByCodigoLibro) {
        this.libroByCodigoLibro = libroByCodigoLibro;
    }

    public SocioEntity getSocioByCodigoSocio() {
        return socioByCodigoSocio;
    }

    public void setSocioByCodigoSocio(SocioEntity socioByCodigoSocio) {
        this.socioByCodigoSocio = socioByCodigoSocio;
    }
}
