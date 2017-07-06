//Factura.java

package com.ipartek.jonBarnes.tipos;

import javax.persistence.*;

/**
 *
 * Esta clase son los productos con cada factura.
 *
 * @author jonBarnes
 * @version 06/07/2017
 *
 * Created by jonBarnes on 06/07/2017.
 */
@Entity
@Table(name = "facturas")
public class Factura {

    //Atributos.
    @Id
    @Column(name = "id")
    private long id;

    @Column(name="productos")
    private Carrito carrito;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura")
    private ListaFactura listaFactura;

    //constructor.


    public Factura() {
    }

    public Factura(Carrito carrito, ListaFactura listaFactura) {
        this.carrito = carrito;
        this.listaFactura = listaFactura;
    }

    //getters y setters.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }



    public ListaFactura getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(ListaFactura listaFactura) {
        this.listaFactura = listaFactura;
    }



    //otros metodos.


    /**
     * Metodo toString().
     * @return
     */
    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", carrito=" + carrito +
                ", listaFactura=" + listaFactura +
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

        if (id != factura.id) return false;
        if (carrito != null ? !carrito.equals(factura.carrito) : factura.carrito != null) return false;
        return listaFactura != null ? listaFactura.equals(factura.listaFactura) : factura.listaFactura == null;
    }

    /**
     * Metodo hashCode().
     * @return
     */
    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (carrito != null ? carrito.hashCode() : 0);
        result = 31 * result + (listaFactura != null ? listaFactura.hashCode() : 0);
        return result;
    }
}
