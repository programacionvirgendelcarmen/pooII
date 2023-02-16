package teoria.composicion;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private String nombreAgenda;
    List<Contacto> contactos;

    public Agenda(String nombreAgenda, List<Contacto> contactos) {
        this.nombreAgenda = nombreAgenda;
        this.contactos = contactos;
    }

    public Agenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
        contactos = new ArrayList<>();
    }

    //getters
    //método que añada un contacto
    //método que borre un contacto
    //método que actualice un contacto
    //método que muestre un contacto, dado el teléfono
}
