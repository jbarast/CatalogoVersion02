//Factura.java

package com.ipartek.jonBarnes.tipos;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Tipo factura.
 *
 * @author jonBarnes
 * @version 07/07/2017
 *
 * Created by jonBarnes on 07/07/2017.
 */
@Entity
@Table(name="facturas")
public class Factura {

    //atributos.
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Usuario usuario;

    @ManyToMany(mappedBy ="facturas",cascade = CascadeType.PERSIST)
    private List<Producto> productos;

    @Column(name = "cantidad")
    private List<Integer> cantidad;

    @Column(name ="fecha")
    private Date date;

    //Constructor.


    public Factura() {
    }

    //getters y setters.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getDate() {
        return date;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(List<Integer> cantidad) {
        this.cantidad = cantidad;
    }


    public void setDate(Date date) {
        this.date = date;
    }



    //Otros metodos.

    /**
     * Metodo toString().
     * @return
     */
    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", productos=" + productos +
                ", cantidad=" + cantidad +
                ", fecha=" + date +
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

        Factura factura = (Factura) o;

        if (id != null ? !id.equals(factura.id) : factura.id != null) return false;
        if (usuario != null ? !usuario.equals(factura.usuario) : factura.usuario != null) return false;
        if (productos != null ? !productos.equals(factura.productos) : factura.productos != null) return false;
        return cantidad != null ? cantidad.equals(factura.cantidad) : factura.cantidad == null;
    }

    /**
     * Metodo hashCode().
     * @return
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (productos != null ? productos.hashCode() : 0);
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }

    //TODO mover este metodo a un sitio mejor.
    /**
     * Metodo añadir un producto a una factura.
     * @param producto
     */
    public void add(Producto producto){
        productos.add(producto);
        producto.getFacturas().add(this);
    }

    //TODO mover este metodo a un sitio mejor.
    /**
     * Metodo remover un producto de la factura.
     * @param producto
     */
    public void remove(Producto producto){
        productos.add(producto);
        producto.getFacturas().remove(this);
    }

}
