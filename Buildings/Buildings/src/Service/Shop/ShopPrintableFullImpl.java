package Service.Shop;

import Model.Shop.Shop;

public class ShopPrintableFullImpl implements ShopPrintable{
    @Override
    public void printShop(Shop shop) {
        System.out.println(shop.getShopType() + "(" + shop.getAddress() + ")");
        System.out.print("Departments: [");
        var departments = shop.getDepartments();
        for (int i = 0; i < departments.size(); i++) {
            System.out.print(departments.get(i));
            if (i < departments.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
