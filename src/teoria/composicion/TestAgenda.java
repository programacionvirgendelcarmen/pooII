package teoria.composicion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestAgenda {
    public static void main(String[] args) throws IOException {
        List<Contacto> contactos = new ArrayList<>();
        List<String> lineas = Files.readAllLines(
                Paths.get("datos/contactos.csv"));
        System.out.printf("Leidas %d líneas%n", lineas.size());
        for (String linea : lineas) {
            String[] tokens = linea.split(",");
            //token[0] : nombre
            //token[1] : apellidos
            //token[2] : telefono
            //token[3] : fecha nacimiento en String
            //LocalDate.parse(token[3]) obtenemos objeto LocalDate
            //creamos objeto Contacto
            //añadimos a contactos
        }
        //con un Scanner pedimos el nombre de la agenda
        //con contactos y nombre agenda, creamos objeto agenda
    }
}
