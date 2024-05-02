package be03.borok_szabolcs.Model;


public class Vehicle extends Product{
    
    private String brand;
    private String model;

    public Vehicle(Integer id, Boolean state, Integer price, String brand, String model) {
        super(id, state, price);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
