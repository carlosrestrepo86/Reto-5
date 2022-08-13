package Modelo.vo;

public class ClasificacionVo{
    private Integer id;
    private String constructora;
    private Integer numeroHabitaciones;
    private String ciudadResidencia;

    public ClasificacionVo() {
    }

    public ClasificacionVo(Integer id, String constructora, Integer numeroHabitantes, String ciudadResidencia) {
        this.id = id;
        this.constructora = constructora;
        this.numeroHabitaciones = numeroHabitantes;
        this.ciudadResidencia = ciudadResidencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(Integer numeroHabitantes) {
        this.numeroHabitaciones = numeroHabitantes;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
}

