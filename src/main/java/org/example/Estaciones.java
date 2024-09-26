package org.example;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "estaciones")
@XmlAccessorType(XmlAccessType.FIELD)
public class Estaciones {

    @XmlElement(name = "estacion")
    private List<Estacion> listEstacion = null;

    public List<Estacion> getListEstacion() {
        return listEstacion;
    }

    public void setListEstacion(List<Estacion> listEstacion) {
        this.listEstacion = listEstacion;
    }
}