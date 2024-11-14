package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<ATM> ATMS;

    public Bank() {
        this.ATMS = new ArrayList<>();
    }

    public void initialize(int atmCount) {
        for (int i = 0; i < atmCount; i++) {
            ATMS.add(new ATM());
        }
    }

    public void loadCashToATMByIndex(int index, Bills bill, int count) {
        if (index >= 0 && index < ATMS.size() && count > 0) {
            ATMS.get(index).loadCash(bill, count);
        }
    }

    public int getTotalCash() {
        return ATMS.stream()
                .mapToInt(ATM::getTotalCash)
                .sum();
    }

    public ATM getAtmByIndex(int index) {
        if (index >= 0 && index < ATMS.size()) {
            return ATMS.get(index);
        }
        return null;
    }


    public List<ATM> getATMS() {
        return ATMS;
    }
}
