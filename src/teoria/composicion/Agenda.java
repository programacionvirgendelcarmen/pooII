package teoria.composicion;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private String nombreAgenda;
    List<Contacto> contactos;

    public Agenda(String nombreAgenda, List<Contacto> contactos) {
        this.nombreAgenda = nombreAgenda; //importo contacto
        this.contactos = contactos;
    }

    public Agenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
        contactos = new ArrayList<>();  //agenda vacía
    }

    //getters y setters

    public String getNombreAgenda() {
        return nombreAgenda;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setNombreAgenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
    }
    //método que añada un contacto
    public boolean addContacto(Contacto contacto){
        return contactos.add(contacto);
    }
    //método que borre un contacto
    public boolean borrarContacto(Contacto contacto) {
        return contactos.remove(contacto);
    }
    //método que actualice un contacto
    public boolean actualizarContacto(Contacto oldContacto, Contacto newContacto){
        for (Contacto contacto: contactos) {
            if (oldContacto.equals(contacto))
                contacto = newContacto;
            return true;
        }
        return false;
    }
    //método que muestre un contacto, dado el teléfono
    public Contacto mostrarContacto (String telefono) {
        for (Contacto contacto: contactos) {
            if (contacto.getTelefono().equals(telefono))
                return contacto;
        }
        return null;
    }
    //método que devuelva una lista de objetos
}
