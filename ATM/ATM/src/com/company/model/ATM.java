package com.company.model;

public class ATM
{
    private int cash;
    public ATM(int cash){
        this.cash = cash;
    }

    public void loadCash(int amount){
        if(amount > 0){
            this.cash += amount;
        }
    }


    public int getCash(){
        return cash;
    }
}
