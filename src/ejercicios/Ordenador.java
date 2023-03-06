package ejercicios;

import java.util.Objects;

public class Ordenador {
    private int ram;
    private TipoPlaca tipoPlaca;
    private float cpu;
    private boolean grafica;
    private int disco;

    public Ordenador(int ram, TipoPlaca tipoPlaca, float cpu,
                     boolean grafica, int disco) {
        this.ram = ram;
        this.tipoPlaca = tipoPlaca;
        this.cpu = cpu;
        this.grafica = grafica;
        this.disco = disco;
    }

    public Ordenador(float cpu) {
        /*this.cpu = cpu;
        this.ram = 32;
        this.tipoPlaca = TipoPlaca.ASUS;
        this.grafica = true;
        this.disco = 500;*/
        this(32, TipoPlaca.ASUS, cpu, true, 500);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public TipoPlaca getTipoPlaca() {
        return tipoPlaca;
    }

    public void setTipoPlaca(TipoPlaca tipoPlaca) {
        this.tipoPlaca = tipoPlaca;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public boolean isGrafica() {
        return grafica;
    }

    public void setGrafica(boolean grafica) {
        this.grafica = grafica;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%.2f,%b,%d", ram, tipoPlaca,
                cpu, grafica, disco);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordenador ordenador = (Ordenador) o;
        return ram == ordenador.ram && Float.compare(ordenador.cpu, cpu) == 0 && grafica == ordenador.grafica && disco == ordenador.disco && tipoPlaca == ordenador.tipoPlaca;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, tipoPlaca, cpu, grafica, disco);
    }
}
