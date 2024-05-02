package be03.borok_szabolcs.Logic;

import java.sql.SQLException;

import java.util.List;

import be03.borok_szabolcs.Model.Car;
import be03.borok_szabolcs.Repository.CarRepository;

public class CarLogic implements IMainLogic<Car> {

    CarRepository repository;

    public CarLogic() {
        this.repository = new CarRepository();
    }

    @Override
    public Car GetOne(Integer id) {
        try {
            return this.repository.GetOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> GetAll() {
        try {
            return this.repository.GetAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Insert(Car obejct) {
        try {
            repository.Insert(obejct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(Integer id) {
        try {
            repository.Delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Car object, Integer id) {
        try {
            repository.Update(object,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
