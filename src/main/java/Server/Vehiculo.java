package Server;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String color;
    private String numSerie;

    public Vehiculo(){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    @Override
    public String toString() {
        return "{" +
                "marca: '" + marca + '\'' +
                ", modelo: '" + modelo + '\'' +
                ", color: '" + color + '\'' +
                ", numSerie: " + numSerie +
                '}';
    }
}
