package com.company;

import com.company.model.ATM;
import com.company.model.Bank;
import com.company.model.Bills;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.initialize(5);

        bank.loadCashToATMByIndex(0, Bills.FIVE_HUNDRED,10);
        bank.loadCashToATMByIndex(0,Bills.HUNDRED,20);

        ATM FirstAtm = bank.getAtmByIndex(0);
//        System.out.println("Atm[0] = " + FirstAtm.getTotalCash());
//        System.out.println("Atm[0] bills = " + FirstAtm.getCashInventory());
//        System.out.println("Total cash in bank = " + bank.getTotalCash());
//
//        FirstAtm.withdrawCash();
//        System.out.println("Atm[0] = " + FirstAtm.getTotalCash());
//        System.out.println("Atm[0] bills = " + FirstAtm.getCashInventory());

        ATM SecondAtm = bank.getAtmByIndex(1);
        bank.loadCashToATMByIndex(1,Bills.ONE,50);
        bank.loadCashToATMByIndex(1, Bills.TEN,30);
        bank.loadCashToATMByIndex(1,Bills.FIVE,20);

        System.out.println("Atm[1] = " + SecondAtm.getTotalCash());
        System.out.println("Atm[1] bills = " + SecondAtm.getCashInventory());

        SecondAtm.withdrawCash();
        System.out.println("Atm[1] = " + SecondAtm.getTotalCash());
        System.out.println("Atm[1] bills = " + SecondAtm.getCashInventory());
    }
}