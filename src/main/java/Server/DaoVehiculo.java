package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoVehiculo {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final String INSERT_CAR = "INSERT INTO autos (marca, modelo, color, numero_serie) VALUES (?, ?, ?, ?)";
    private final String GET_CARS = "SELECT * FROM autos";

    public List<Vehiculo> showUsers (){
        List<Vehiculo> carList = new LinkedList<>();
        Vehiculo car = null;
        try{
            conn = new Coneccion().getConnection();
            String query = GET_CARS;
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                car = new Vehiculo();
                car.setMarca(rs.getString("marca"));
                car.setModelo(rs.getString("modelo"));
                car.setColor(rs.getString("color"));
                car.setNumSerie(rs.getString("numero_serie"));
                carList.add(car);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoVehiculo.class.getName())
                    .log(Level.SEVERE, "Error -> ", e);
        }finally {
            closeConnections();
        }
        return carList;
    }

    public boolean saveCar(Vehiculo car){
        try {
            conn = new Coneccion().getConnection();
            String query = INSERT_CAR;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, car.getMarca());
            pstm.setString(2, car.getModelo());
            pstm.setString(3, car.getColor());
            pstm.setString(4, car.getNumSerie());

            return pstm.executeUpdate()==1; //1==1

        }catch (SQLException e){
            Logger.getLogger(DaoVehiculo.class.getName())
                    .log(Level.SEVERE, "Error -> ", e);
            return false;
        } finally {
            closeConnections();
        }
    }
    public void closeConnections(){
        try{
            if (conn!= null){
                conn.close();
            }
            if (pstm!= null){
                pstm.close();
            }
            if (rs!= null){
                rs.close();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
