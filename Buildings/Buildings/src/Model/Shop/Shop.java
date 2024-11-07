package Model.Shop;

import Model.House;
import Service.Shop.ShopPrintable;

import java.util.ArrayList;
import java.util.List;

public class Shop extends House
{
    private ShopPrintable ShopPrintable;
    private List<ShopDepartment> Departments;
    public Shop(String address,List<ShopDepartment> departments,ShopPrintable shopPrintable){
        super(address);
        Departments = departments;
        this.ShopPrintable = shopPrintable;
    }
    public Shop(ShopPrintable shopPrintable){
        this.ShopPrintable = shopPrintable;
        this.Departments = new ArrayList<>();
    }

    public String getShopType() {
        int departmentCount = Departments.size();
        if (departmentCount >= ShopEnum.SUPERMARKET.getMinSize()) {
            return ShopEnum.SUPERMARKET.getDescription();
        } else {
            return ShopEnum.SMALL_SHOP.getDescription();
        }
    }

    public void addDepartment(ShopDepartment department){
        this.Departments.add(department);
    }


    @Override
    public void printInfo() {
        ShopPrintable.printShop(this);
    }

    public void setShopPrintable(Service.Shop.ShopPrintable shopPrintable) { ShopPrintable = shopPrintable; }

    public List<ShopDepartment> getDepartments() {
        return Departments;
    }

    public void setDepartments(List<ShopDepartment> departments) {
        Departments = departments;
    }
}
