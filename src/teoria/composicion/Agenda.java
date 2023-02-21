package teoria.composicion;

import dates.DateHelper;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private NombreAgenda nombreAgenda;
    List<Contacto> contactos;

    public Agenda(NombreAgenda nombreAgenda, List<Contacto> contactos) {
        this.nombreAgenda = nombreAgenda;
        this.contactos = contactos;
    }

    public Agenda(NombreAgenda nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
        contactos = new ArrayList<>();
    }
    //getters y setters


    public NombreAgenda getNombreAgenda() {
        return nombreAgenda;
    }

    public void setNombreAgenda(NombreAgenda nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
    }

    public List<Contacto> getContactos() {
        return contactos;
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
    //método que devuelva una lista de objetos que sean contactos mayores de edad
    public List<Contacto> getContactosMayoresEdad() {
        List<Contacto> mayoresEdad = new ArrayList<>();
        for (Contacto contacto : contactos) {
            if (DateHelper.calcularEdad(contacto.getFechaNacimiento())  >= 18)
                mayoresEdad.add(contacto);
        }
        return mayoresEdad;
    }
}
