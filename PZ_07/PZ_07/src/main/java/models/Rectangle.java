package models;

public class Rectangle implements Shape
{
    private final double lenght;
    private final double height;

    public Rectangle(double lenght,double height){
        this.lenght = lenght;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return lenght * height;
    }
}
