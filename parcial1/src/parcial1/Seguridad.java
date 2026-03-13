package parcial1;

public class Seguridad {

    private String clave;

    public Seguridad(String clave){
        this.clave = clave;
    }

    public boolean validarClave(String claveIngresada){
        return clave.equals(claveIngresada);
    }

}