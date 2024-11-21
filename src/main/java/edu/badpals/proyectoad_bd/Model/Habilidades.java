package edu.badpals.proyectoad_bd.Model;

public enum Habilidades {
    Q ("Q"),
    E ("E"),
    C ("C"),
    X ("X");

    private final String tipo_hab;

    Habilidades(String tipo_hab) {
        this.tipo_hab = tipo_hab;
    }

    public String getTipo_hab() {
        return tipo_hab;
    }

    public static Habilidades getHabilidad(String tipo_hab) {
        for (Habilidades habilidad : Habilidades.values()) {
            if (habilidad.getTipo_hab().equals(tipo_hab)) {
                return habilidad;
            }
        }
        return null;
    }
}
