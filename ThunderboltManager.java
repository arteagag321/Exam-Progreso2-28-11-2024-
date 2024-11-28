import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThunderboltManager {
    private List<Thunderbolt> thunderbolts = new ArrayList<>();

    public String agregarThunderbolt(Thunderbolt thunderbolt) {
        for (Thunderbolt t : thunderbolts) {
            if (t.getCodigo() == thunderbolt.getCodigo()) {
                return "Error: El código ya existe.";
            }
        }
        thunderbolts.add(0, thunderbolt);
        return "Thunderbolt agregado exitosamente.";
    }

    public List<Thunderbolt> listarThunderbolts() {
        return thunderbolts;
    }

    public Thunderbolt buscarThunderbolt(int codigo) {
        for (Thunderbolt t : thunderbolts) {
            if (t.getCodigo() == codigo) {
                return t;
            }
        }
        return null;
    }

    public List<Thunderbolt> filtrarYOrdenarPorHabilidad(String habilidad) {
        List<Thunderbolt> filtrados = new ArrayList<>();
        for (Thunderbolt t : thunderbolts) {
            if (!t.getHabilidadPrincipal().equals(habilidad)) {
                filtrados.add(t);
            }
        }
        for (int i = 0; i < filtrados.size() - 1; i++) {
            for (int j = 0; j < filtrados.size() - i - 1; j++) {
                if (filtrados.get(j).getNivelRedencion() > filtrados.get(j + 1).getNivelRedencion()) {
                    Collections.swap(filtrados, j, j + 1);
                }
            }
        }
        return filtrados;
    }

    public int contarMisionesPorHabilidad(String habilidad, int index) {
        if (index >= thunderbolts.size()) {
            return 0;
        }
        int cuenta = thunderbolts.get(index).getHabilidadPrincipal().equals(habilidad) ? 1 : 0;
        return cuenta + contarMisionesPorHabilidad(habilidad, index + 1);
    }
}