package edu.badpals.proyectoad_bd.Model;

public class AgenteDTO {
    private int idAg;
    private String nombreAg;
    private String nombreRol;
    private String habilidadC;
    private String habilidadQ;
    private String habilidadE;
    private String habilidadX;

    public AgenteDTO(int idAg, String nombreAg, String nombreRol, String habilidadC, String habilidadQ, String habilidadE, String habilidadX) {
        this.idAg = idAg;
        this.nombreAg = nombreAg;
        this.nombreRol = nombreRol;
        this.habilidadC = habilidadC;
        this.habilidadQ = habilidadQ;
        this.habilidadE = habilidadE;
        this.habilidadX = habilidadX;
    }

    // Getters
    public int getIdAg() {
        return idAg;
    }

    public String getNombreAg() {
        return nombreAg;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public String getHabilidadC() {
        return habilidadC;
    }

    public String getHabilidadQ() {
        return habilidadQ;
    }

    public String getHabilidadE() {
        return habilidadE;
    }

    public String getHabilidadX() {
        return habilidadX;
    }
}
