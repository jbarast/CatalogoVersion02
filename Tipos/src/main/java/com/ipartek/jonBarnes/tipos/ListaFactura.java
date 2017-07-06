//ListaFactura.java

package com.ipartek.jonBarnes.tipos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta clase es las "ListaFacturas".
 *
 * @author jonBarnes
 * @version 06/07/2017
 *
 * Created by jonBarnes on 06/07/2017.
 */
@Entity
@Table(name="Lista_Facturas")
public class ListaFactura {

    //atributos.
    @Id
    @Column(name="id_factura")
    private Long facturaId;

    @Column(name="usuario")
    private Usuario usuario;

    @Column(name = "fecha")
    private Date fecha;

    @OneToMany(mappedBy = "listaFactura" , cascade = CascadeType.ALL)
    private List<Factura> facturas = new ArrayList<Factura>();
    //Constructor.

    public ListaFactura() {
    }

    public ListaFactura(Usuario usuario, Date fecha) {
        this.usuario = usuario;
        this.fecha = fecha;
    }

    //getters y setters.

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    //otros metodos.


    /**
     * Metodo toString()
     * @return
     */
    @Override
    public String toString() {
        return "ListaFactura{" +
                "facturaId=" + facturaId +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                '}';
    }

    /**
     * Metodo equals().
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaFactura that = (ListaFactura) o;

        if (facturaId != null ? !facturaId.equals(that.facturaId) : that.facturaId != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        return fecha != null ? fecha.equals(that.fecha) : that.fecha == null;
    }

    /**
     * Metodo hashCode().
     * @return
     */
    @Override
    public int hashCode() {
        int result = facturaId != null ? facturaId.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }
}
