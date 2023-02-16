package teoria.introduccion;

public class EstaticoInstancia {
    private Persona persona1 = new Persona("luis", 12);
    private static Persona persona2 = new Persona("luisa", 16);

    public static void main(String[] args) {
        System.out.println(persona2); //la persona1 no la veo
        //mostrar()  no lo puedo invocar, porque es de instancia y main static
        EstaticoInstancia instancia = new EstaticoInstancia();
        instancia.mostrar();
    }
    public void mostrar() {
        System.out.println(persona1);
        System.out.println(persona2);
    }

}
