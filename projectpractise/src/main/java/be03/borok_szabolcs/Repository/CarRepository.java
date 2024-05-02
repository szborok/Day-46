package be03.borok_szabolcs.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be03.borok_szabolcs.Model.Car;

public class CarRepository extends MainRepository<Car>{

    @Override
    public Car GetOne(Integer id) throws SQLException {
        Car car = null;
        try(PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(
            "SELECT * FROM CarVehicleProducts WHERE id = ?")){
            preparedStatement.setInt(1, id);
            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    car = CarRepository.carFromResultSet(rs);
                }
            }
        }
        return car;
    }

    @Override
    public void Insert(Car object) throws SQLException {
        try(PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(
            "INSERT INTO CarVehicleProducts (state, price, brand, model, seats) VALUES(?,?,?,?,?)")){
            preparedStatement.setBoolean(1, object.getState());
            preparedStatement.setInt(2, object.getPrice());
            preparedStatement.setString(3, object.getBrand());
            preparedStatement.setString(4, object.getModel());
            preparedStatement.setInt(5, object.getSeats());

            preparedStatement.executeUpdate();

        }
    }

    @Override
    public void Delete(Integer id) throws SQLException {
        try(PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(
            "DELETE FROM CarVehicleProducts WHERE id = ?")){
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void Update(Car object, Integer id) throws SQLException {
        try (PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(
            "UPDATE CarVehicleProducts SET state = ?, price = ?, brand = ?, model = ?, seats = ? WHERE id = ?")){
                preparedStatement.setBoolean(1, object.getState());
                preparedStatement.setInt(2, object.getPrice());
                preparedStatement.setString(3, object.getBrand());
                preparedStatement.setString(4, object.getModel());
                preparedStatement.setInt(5, object.getSeats());
                preparedStatement.setInt(6, id);

                preparedStatement.executeUpdate();
            }}

    @Override
    public List<Car> GetAll() throws SQLException {
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(
            "SELECT * FROM CarVehicleProducts")){
            try(ResultSet rs = preparedStatement.executeQuery()){
                while(rs.next()){
                    Car car = new Car(
                        rs.getInt("id"),
                        rs.getBoolean("state"),
                        rs.getInt("price"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("seats")
                    );
                    
                    cars.add(car);
                }
            }
        }
        return cars;
    }

public static Car carFromResultSet(ResultSet rs) {
    try {
        return new Car(
            rs.getInt("id"),
            rs.getBoolean("state"),
            rs.getInt("price"),
            rs.getString("brand"),
            rs.getString("model"),
            rs.getInt("seats")
        );
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;


}


}
