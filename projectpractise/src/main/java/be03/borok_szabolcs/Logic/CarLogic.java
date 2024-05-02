package be03.borok_szabolcs.Logic;

import be03.borok_szabolcs.Model.Car;
import be03.borok_szabolcs.Repository.CarRepository;

public abstract class CarLogic implements IMainLogic<Car> {
    CarRepository repository;

    public CarLogic() {
        this.repository = new CarRepository();
    }







}
