package be03.borok_szabolcs.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be03.borok_szabolcs.Model.Car;

public class CarRepository extends MainRepository<Car> {

    @Override
    public Car getOne(Integer id) throws SQLException {
        Car car = null;
        try(PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(
            "SELECT * FROM CarVehicleProducts WHERE id = ?" )) {
            preparedStatement.setInt(1, id);
            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()) {
                    car = new Car(id, null, id, null, null, id)
                }
            }x
        }   
    }

    @Override
    public void insert(Car object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(Car object, Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Car> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }



    

    
}
