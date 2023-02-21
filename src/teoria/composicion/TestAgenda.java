package teoria.composicion;

import strings.StringHelper;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAgenda {
    private static Agenda agenda;
    public static void main(String[] args) throws IOException {
        List<Contacto> contactos = new ArrayList<>();
        List<String> lineas = Files.readAllLines(
                Paths.get("datos/contactos.csv"));
       // System.out.printf("Leidas %d líneas%n", lineas.size());
        for (String linea : lineas) {
            String[] tokens = linea.split(",");
            String nombreContacto = tokens[0];
            String apellidos = tokens[1];
            String telefono = tokens[2];
            String sFechaNacimiento =  tokens[3];
            LocalDate fechaNacimiento = LocalDate.parse(sFechaNacimiento);
            Contacto contacto = new Contacto(
                    nombreContacto, apellidos, telefono, fechaNacimiento);
            contactos.add(contacto);
        }
        //comprobación de los contactos:
       // contactos.forEach(System.out::println);
       // System.out.printf("%nNº contactos %d%n", contactos.size());
        String[] nombresAgenda = { "TRABAJO", "AMIGOS", "GIMNASIO", "FAMILIA" };
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Elige tipo de agena", "AGENDA",
                JOptionPane.INFORMATION_MESSAGE, null,
                nombresAgenda, nombresAgenda[0]);
        String sValor = (String) selectedValue;
        NombreAgenda nombreAgenda = NombreAgenda.valueOf(sValor);

        agenda = new Agenda(nombreAgenda, contactos);
        desplegarMenu();
        //Usando JOption menú con dos opciones:
        //1. añadir contacto
        //2. mostrar contacto
        //para cada un un método, ejemplo mostrarContacto(Contacto contacto)
        //usando JOptionPane mostramos el contacto
        //añadir contacto, pedimos cuatro datos
    }

    private static void desplegarMenu() {
        String opcion = "";
        do {
            opcion =
                    JOptionPane.showInputDialog(
                            "Introduce una opción\n1. Añadir contacto.\n2. Mostrar contacto\n3. Salir");
        } while (! opcion.matches("[12]"));
        //System.out.println("opción elegida " + opcion);
        switch (opcion) {
            case "1" :
                addContacto();
                break;
            case "2" :
                mostrarContactoPorTelefono();
                break;
            default:
                break;
        }
    }

    private static void mostrarContactoPorTelefono() {
        String telefono = "";
        do {
            telefono =
                    JOptionPane.showInputDialog(
                            "Introduce nº teléfono del contacto a localizar");
        } while (!StringHelper.checkPhoneNumber(telefono));
        Contacto contacto = agenda.mostrarContacto(telefono);
        if (contacto != null)
            JOptionPane.showMessageDialog(
                    null, contacto, "CONTACTO",
                    JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(
                    null, "No existe el contacto", "CONTACTO",
                    JOptionPane.ERROR_MESSAGE);
    }

    private static void addContacto() {
        agenda.mostrarContacto("telefono");
    }
}
