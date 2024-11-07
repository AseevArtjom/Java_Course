package com.company;

import Model.*;
import Model.Menu.MenuExecutor;
import Model.Shop.Shop;
import Model.Shop.ShopDepartment;
import Service.Hospital.HospitalPrintableFullImpl;
import Service.Residential.ResidentialPrintableFullImpl;
import Service.Shop.ShopPrintableFullImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<House> buildingList = new ArrayList<>(Arrays.asList(
                new Hospital("301 Avenue", new HospitalPrintableFullImpl()),
                new Residential("302 Avenue",20,new ResidentialPrintableFullImpl()),
                new Shop("303 Avenue",new ArrayList<>(List.of(
                        ShopDepartment.MEAT,
                        ShopDepartment.ALCOHOL
                )),new ShopPrintableFullImpl()),
                new Residential("304 Avenue",20,new ResidentialPrintableFullImpl()),
                new Residential("305 Avenue",20,new ResidentialPrintableFullImpl()),
                new Shop("306 Avenue",new ArrayList<>(List.of(
                        ShopDepartment.GROCERIES,
                        ShopDepartment.FLOUR
                )),new ShopPrintableFullImpl()),
                new Residential("307 Avenue",20,new ResidentialPrintableFullImpl()),
                new Residential("308 Avenue",20,new ResidentialPrintableFullImpl()),
                new Residential("309 Avenue",20,new ResidentialPrintableFullImpl()),
                new Shop("310 Avenue",new ArrayList<>(List.of(
                        ShopDepartment.MEAT,
                        ShopDepartment.FUNKFOOD,
                        ShopDepartment.SEAFOOD,
                        ShopDepartment.ALCOHOL,
                        ShopDepartment.HOUSEHOLD
                )),new ShopPrintableFullImpl())
        ));
        Street street = new Street("Downing street",buildingList);
        MenuExecutor menuExecutor = new MenuExecutor(street);
        menuExecutor.startMenu();
    }
}