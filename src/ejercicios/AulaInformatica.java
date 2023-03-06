package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class AulaInformatica {
    private String nombreAula;
    private List<Ordenador> ordenadores = new ArrayList<>();

    public AulaInformatica(String nombreAula) {
        this.nombreAula = nombreAula;
      //  this.ordenadores = new ArrayList<>();
    }
    public boolean addOrdenador(Ordenador ordenador) {
        return ordenadores.add(ordenador);
    }
    public boolean eliminarOrdenador(Ordenador ordenador){
        return ordenadores.remove(ordenador);
    }
    public Ordenador getOrdenadorMayorRAM(){
        int mayorRAM = 0;
        Ordenador ordenadorMasRAM = null;
        for (Ordenador ordenador: ordenadores) {
            if (ordenador.getRam() > mayorRAM){
                mayorRAM = ordenador.getRam();
                ordenadorMasRAM = ordenador;
            }
        }
        return ordenadorMasRAM;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Ordenador ordenador : ordenadores) {
            sb.append(ordenador).append('\n');

        }

        return sb.toString();
    }
}
