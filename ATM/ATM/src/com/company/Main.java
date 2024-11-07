package com.company;

import com.company.model.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.Initialize(5,5000);
        System.out.println("Old cash: " + bank.getAtmByIndex(0).getCash());
        bank.loadCashToATMByIndex(0,2000);
        System.out.println("New cash: " + bank.getAtmByIndex(0).getCash());
        System.out.println("Total cash: " + bank.getTotalCash());
    }
}