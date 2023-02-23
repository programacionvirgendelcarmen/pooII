package teoria.composicion;

import dates.DateHelper;
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
        String mensaje = "Introduce una opción" +
                "\n1. Añadir contacto." +
                "\n2. Mostrar contacto" +
                "\n3. Mostrar todos los contacto" +
                "\n4. Mostrar mayores de edad" +
                "\n5. Actualizar contacto" +
                "\n6. Salir";
        String opcion = "";
        do {
            do {
                opcion =
                        JOptionPane.showInputDialog(mensaje);
            } while (!opcion.matches("[1-6]"));
            //System.out.println("opción elegida " + opcion);
            switch (opcion) {
                case "1":
                    addContacto();
                    break;
                case "2":
                    mostrarContactoPorTelefono();
                    break;
                case  "3":
                    mostrarTodosLosContactos();
                    break;
                case "4":
                    mostrarMayoresEdad();
                    break;
                case "5":
                    actualizarUnContacto();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(
                            null, "Fin de programa", "CONTACTO",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    break;
            }
        } while (! opcion.equals("6"));
    }

    private static void actualizarUnContacto() {
        Contacto newContacto = getContacto();
        Contacto oldContacto = getContactoByPhone();
        boolean exito = agenda.actualizarContacto(oldContacto, newContacto);
        if (exito)
            JOptionPane.showMessageDialog(
                    null, "Actualizado contacto", "CONTACTO",
                    JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(
                    null, "No existe el contacto", "CONTACTO",
                    JOptionPane.ERROR_MESSAGE);

    }

    private static void mostrarMayoresEdad() {
        //lógica similar a mostarTodosLosContactos()
        for (Contacto contacto : agenda.getContactosMayoresEdad()) {
            System.out.println(contacto);
        }
    }

    private static void mostrarTodosLosContactos() {
        for (Contacto contacto : agenda.getContactos()) {
            System.out.println(contacto);
        }
    }

    private static void mostrarContactoPorTelefono() {
        Contacto contacto = getContactoByPhone();
        if (contacto != null)
            JOptionPane.showMessageDialog(
                    null, contacto, "CONTACTO",
                    JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(
                    null, "No existe el contacto", "CONTACTO",
                    JOptionPane.ERROR_MESSAGE);
    }

    private static Contacto getContactoByPhone() {
        String telefono = "";
        do {
            telefono =
                    JOptionPane.showInputDialog(
                            "Introduce nº teléfono del contacto a localizar");
        } while (!StringHelper.checkPhoneNumber(telefono));
        Contacto contacto = agenda.mostrarContacto(telefono);
        return contacto;
    }

    private static void addContacto() {
        Contacto contacto = getContacto();
        if (agenda.addContacto(contacto))
            JOptionPane.showMessageDialog(
                    null, "Añadido contacto nuevo", "NUEVO CONTACTO",
                    JOptionPane.INFORMATION_MESSAGE);
    }

    private static Contacto getContacto() {
        String nombre = JOptionPane.showInputDialog("Introduce nombre de contacto");
        String apellidos = JOptionPane.showInputDialog("Introduce apellidos de contacto");
        String telefono = "";
        do {
            telefono = JOptionPane.showInputDialog("Introduce un télefono válido");
        } while (!StringHelper.checkPhoneNumber(telefono));
        String sFecha = "";
        do {
            sFecha = JOptionPane.showInputDialog("Introduce fecha nacimiento");
        } while (!DateHelper.checkDate(sFecha));
        String[] tokens = sFecha.split("[-/]");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tokens[2]); //año
        stringBuilder.append('-');
        stringBuilder.append(tokens[1]); //mes
        stringBuilder.append('-');
        stringBuilder.append(tokens[0]); //día
        LocalDate fecha = LocalDate.parse(stringBuilder.toString());
        Contacto contacto = new Contacto(nombre, apellidos, telefono, fecha);
        return contacto;
    }
}
