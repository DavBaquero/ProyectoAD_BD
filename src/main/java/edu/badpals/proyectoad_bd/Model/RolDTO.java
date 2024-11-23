package edu.badpals.proyectoad_bd.Model;

public class RolDTO {
    private int idRol;
    private String nombreRol;
    private String descripcion;
    private String nom_agente;

    public RolDTO(int idRol, String nombreRol, String descripcion, String nom_agente) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.descripcion = descripcion;
        this.nom_agente = nom_agente;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNom_agente() {
        return nom_agente;
    }
}
