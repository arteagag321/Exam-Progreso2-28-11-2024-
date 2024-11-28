import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class Thunderbolt {
    private int codigo;
    private String nombre;
    private String habilidadPrincipal;
    private int nivelRedencion;
    private String misionAsignada;

    public  Thunderbolt(int codigo, String nombre, String habilidadPrincipal, int nivelRedencion, String misionAsignada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.habilidadPrincipal = habilidadPrincipal;
        this.nivelRedencion = nivelRedencion;
        this.misionAsignada = misionAsignada;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;

    }
    public String getHabilidadPrincipal() {
        return habilidadPrincipal;
    }
    public int getNivelRedencion() {
        return nivelRedencion;
    }
    public String getMisionAsignada() {
        return misionAsignada;
    }
    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Habilidad: " + habilidadPrincipal +
                ", Nivel de Redención: " + nivelRedencion + ", Misión: " + misionAsignada;
    }
}
