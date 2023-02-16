package teoria.introduccion;

import java.util.Arrays;
import java.util.List;

public class Ejemplo1 {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        System.out.printf("i = %d j = %d%n", i, j);
        i = j;
        System.out.printf("i = %d j = %d%n", i, j);
        j = 3;
        System.out.printf("i = %d j = %d%n", i, j);
        System.out.println("=========================");
        Persona persona1 = new Persona("juan", 23);
        Persona persona2 = new Persona("luisa", 25);
        System.out.println("persona1 " + persona1);
        System.out.println("persona2 " + persona2);
        persona1 = persona2;
        System.out.println("=========================");
        System.out.println("persona1 " + persona1);
        System.out.println("persona2 " + persona2);
        System.out.println("=========================");
        persona1.setEdad(18);
        System.out.println("persona1 " + persona1);
        System.out.println("persona2 " + persona2);
        System.out.println("=========================");
        int[] enteros = {1, 2, 3};
        Persona[] personas = {new Persona("felipe", 12),
                    new Persona("esmeralda", 15),
                    persona1, persona2};
        System.out.println(personas);
        System.out.println(Arrays.toString(personas));
        List<Persona> listaPersonas = List.of(persona1, persona2,
                new Persona ("jacinto", 25));
        System.out.println("=========================");
        System.out.println(listaPersonas);
        listaPersonas.get(0).setEdad(100);
        System.out.println(listaPersonas);
        persona2.setNacionalidad("británico");
        Persona.setNacionalidad("ruso");
        mostrarNombre(listaPersonas.get(listaPersonas.size() -1));
        mostrarNombre(persona2);
        System.out.println("---------------------------");
        System.out.println(listaPersonas.get(listaPersonas.size() -1));
        System.out.println(persona2);
        System.out.println("----------------------");
        System.out.println("Nº personas: " + Persona.getNumeroPersonas());
    }

    private static void mostrarNombre(Persona persona) {
        System.out.println("***********************");
        persona.setEdad(1);
        System.out.println(persona.getNombre());
    }
}
class Persona  {
    private String nombre;
    private int edad;
    private static String nacionalidad = "española";
    private static int numeroPersonas = 0;

    public Persona () {
        numeroPersonas++;
    }
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        numeroPersonas++;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public static void setNacionalidad(String nacionalidad) {
        Persona.nacionalidad = nacionalidad;
    }

    public static int getNumeroPersonas() {
        return numeroPersonas;
    }

    @Override
    public String toString() {
        return String.format("NOMBRE: %s, edad: %d, nacionalidad %s",
                nombre, edad, nacionalidad);
    }
}
