package Model;

public abstract class House implements Building {
    String Address;

    public House(String address){
        this.Address = address;
    }
    public House(){}

    @Override
    public void setAddress(String address) {
        this.Address = address;
    }

    public String getAddress() {
        return Address;
    }
}
