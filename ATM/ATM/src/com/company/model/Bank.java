package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Bank
{
    private List<ATM> ATMS;
    private int ATMSCount;

    public Bank(){
        ATMS = new ArrayList<>();
        ATMSCount = 0;
    }

    public void Initialize(int atmscount,int cash){
        for (int i = 0; i < atmscount; i++) {
            ATMS.add(new ATM(cash));
        }
        this.ATMSCount = ATMS.size();
    }

    public int getTotalCash(){
        int total = 0;
        for (ATM atm : ATMS){
            total += atm.getCash();
        }
        return total;
    }

    public void loadCashToATMByIndex(int index,int amount){
        if(index >= 0 && index < ATMS.size() && amount > 0){
            ATMS.get(index).loadCash(amount);
        }
    }

    public ATM getAtmByIndex(int index){
        if(index >= 0 && index < ATMS.size()){
            return ATMS.get(index);
        }
        return null;
    }

    public int getATMSCount() {
        return ATMSCount;
    }

    public List<ATM> getATMS() {
        return ATMS;
    }
}
