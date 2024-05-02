package be03.borok_szabolcs.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.List;

import be03.borok_szabolcs.Model.Product;

public class ProductRepository extends MainRepository<Product>{

    @Override
    public Product GetOne(Integer id) throws SQLException {
        Product product = null;
        try(PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(
            "SELECT * FROM Product p " + 
            "INNER JOIN VehicleProduct vp ON p.ProductID = vp.ProductID " +
            "INNER JOIN MotorVehiclProducts mvp ON mvp.VehicleProductID = vp.VehicleProductID " +
            "WHERE id = ?")){
            preparedStatement.setInt(1, id);
            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    ResultSetMetaData rsmd = rs.getMetaData();
                    Boolean isCar = false;
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        isCar |= rsmd.getColumnName(i+1).equals("CarVehicleProductID");
                    }
                    if (isCar) {
                        product = CarRepository.carFromResultSet(rs);
                    }
                }
            }
        }
        return product;


    }

    @Override
    public void Insert(Product object) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Insert'");
    }

    @Override
    public void Delete(Integer id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }

    @Override
    public void Update(Product object, Integer id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public List<Product> GetAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetAll'");
    }

}
