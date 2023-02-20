package teoria.composicion;

import javax.swing.*;

public class PruebaGrafica {
    public static void main(String[] args) {
       /* JOptionPane.showMessageDialog(
                null, "mensaje", "TÍTULO",
                    JOptionPane.WARNING_MESSAGE);*/
       /* int valor = JOptionPane.showConfirmDialog(null,
                "choose one", "TÍTULO", JOptionPane.YES_NO_OPTION);
        System.out.println(valor);*/
        String inputValue =
                JOptionPane.showInputDialog("Please input a value\n1. Listar contactos.\n2. Añadir contacto ...");
        System.out.println(inputValue);
        /*Object[] possibleValues = { "TRABAJO", "AMIGOS", "GIMNASIO", "FAMILIA" };

        Object selectedValue = JOptionPane.showInputDialog(null,
             "Choose one", "Input",
             JOptionPane.INFORMATION_MESSAGE, null,
             possibleValues, possibleValues[0]);
        String sValor = (String) selectedValue;
        NombreAgenda nombreAgenda = NombreAgenda.valueOf(sValor);
        System.out.println(sValor);*/

    }
}
