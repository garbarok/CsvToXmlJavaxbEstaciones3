package org.example;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "estacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Estacion {
    @XmlElement
    private int codigo;
    @XmlElement
    private String descripcion;
    @XmlElement
    private double latitud;
    @XmlElement
    private double longitud;
    @XmlElement
    private String direccion;
    @XmlElement
    private String cp;
    @XmlElement
    private String poblacion;
    @XmlElement
    private String provincia;
    @XmlElement
    private String pais;
    @XmlElement
    private String cercanias;
    @XmlElement
    private String feve;
    @XmlElement
    private String comun;

    public Estacion() {}

    public Estacion(int codigo, String descripcion, double latitud, double longitud, String direccion, String cp, String poblacion, String provincia, String pais, String cercanias, String feve, String comun) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.cp = cp;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.pais = pais;
        this.cercanias = cercanias;
        this.feve = feve;
        this.comun = comun;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCercanias() {
        return cercanias;
    }

    public void setCercanias(String cercanias) {
        this.cercanias = cercanias;
    }

    public String getFeve() {
        return feve;
    }

    public void setFeve(String feve) {
        this.feve = feve;
    }

    public String getComun() {
        return comun;
    }

    public void setComun(String comun) {
        this.comun = comun;
    }



}