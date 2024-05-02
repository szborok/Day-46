package be03.borok_szabolcs.Model;

public class Car extends Vehicle{
    
    private Integer seats;
    
    public Car(Integer id, Boolean state, Integer price, String brand, String model, Integer seats) {
        super(id, state, price, brand, model);
        this.seats = seats;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
