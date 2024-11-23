package edu.badpals.proyectoad_bd.Model;

public class HabilidadDTO {
    private int idAg;
    private String nombreag;
    private String nombreHab;
    private String descripcion;

    public HabilidadDTO(int idAg, String nombreag, String nombreHab, String descripcion) {
        this.idAg = idAg;
        this.nombreag = nombreag;
        this.nombreHab = nombreHab;
        this.descripcion = descripcion;
    }

    public int getIdAg() {
        return idAg;
    }

    public String getNombreag() {
        return nombreag;
    }

    public String getNombreHab() {
        return nombreHab;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
