package Modelo.vo;

public class LiderVo {
    private Integer id;
    private String nombre;
    private String primerApellido;
    private String ciudadResidencia;

    public LiderVo() {
    }

    public LiderVo(Integer id, String nombre, String primer_apellido, String ciudadResidencia) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primer_apellido;
        this.ciudadResidencia = ciudadResidencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

}
