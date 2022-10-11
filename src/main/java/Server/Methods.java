package Server;

import java.util.List;

public class Methods {
    Vehiculo autos;
    DaoVehiculo dao = new DaoVehiculo();
    public List<Vehiculo> lista;

    public String registrarAuto(String modelo, String marca, String color, String serie){
        autos = new Vehiculo();
        autos.setModelo(modelo);
        autos.setMarca(marca);
        autos.setColor(color);
        autos.setNumSerie(serie);
        dao.saveCar(autos);

        return "Registro realizado con exito";
    }

    public String listadoAutos(String a, String b){
        String result = "";
        lista = dao.showUsers();
        for (int i = 0; i < lista.size(); i++) {
            result = result + lista.get(i).toString() + "\n";
        }
        return result;
    }
}
