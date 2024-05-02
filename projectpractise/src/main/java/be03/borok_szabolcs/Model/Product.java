package be03.hosszu_akos.Model;

public class Product {
    private Integer id;
    private Boolean state;
    private Integer price;

    public Product(Integer id, Boolean state, Integer price) {
        this.id = id;
        this.state = state;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }    
}
