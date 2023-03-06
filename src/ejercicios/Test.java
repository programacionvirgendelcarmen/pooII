package ejercicios;

public class Test {
    public static void main(String[] args) {

        AulaInformatica aulaInformatica = new AulaInformatica("1.8");

        Ordenador ordenador1 = new Ordenador(2.5f);
        aulaInformatica.addOrdenador(ordenador1);

        Ordenador ordenador2 = new Ordenador(64, TipoPlaca.ASROCK,
                3.0f, false, 256);
        aulaInformatica.addOrdenador(ordenador2);

        Ordenador ordenador3 = new Ordenador(1.5f);
        aulaInformatica.addOrdenador(ordenador3);

        Ordenador ordenador4 = new Ordenador(16, TipoPlaca.GIGABYTE,
                3.0f, true, 1024);
        aulaInformatica.addOrdenador(ordenador4);

        System.out.println(aulaInformatica);

        Ordenador ordenadorAEliminar = new Ordenador(2.5f);

        aulaInformatica.eliminarOrdenador(ordenadorAEliminar);
        System.out.println("______________________________");
        System.out.println(aulaInformatica);
        System.out.println("______ORDENADOR MAYOR RAM_______");
        System.out.println(aulaInformatica.getOrdenadorMayorRAM());


    }
}
