package com.company.model;

import com.company.Main;
import com.company.exception.BelowMinimumLimitException;
import com.company.exception.ExceedMaximumLimitException;
import com.company.exception.InsufficientFundsException;

import java.util.*;

public class ATM
{
    private Map<Bills,Integer> cashInventory;
    private int minWithdrawalAmount;
    private int maxDispenseCount;

    public ATM() {
        this.cashInventory = new EnumMap<>(Bills.class);
        for (Bills bill : Bills.values()) {
            cashInventory.put(bill, 0);
        }
        this.minWithdrawalAmount = 50;
        this.maxDispenseCount = 80;
    }

    public void loadCash(Bills bill, int count) {
        if (count > 0) {
            cashInventory.put(bill, cashInventory.get(bill) + count);
        }
    }

    public int getTotalCash() {
        return cashInventory.entrySet().stream().mapToInt(entry -> entry.getKey().getValue() * entry.getValue()).sum();
    }

    public Map<Bills, Integer> getCashInventory() {
        return cashInventory;
    }

    public void withdrawCash(){
        int amount = InputAmount();
        try {
            if(amount < minWithdrawalAmount){
                throw new BelowMinimumLimitException("Amount is below the minimum limit");
            }
            if(amount > getTotalCash()){
                throw new InsufficientFundsException("The ATM doesnt have that much money");
            }
            Map<Bills,Integer> BillsTmp = calculateBillsForWithdraw(amount);
            if(BillsTmp == null){
                throw new InsufficientFundsException("Cannot dispense requested amount with available bills");
            }
            int totalBills = BillsTmp.values().stream().mapToInt(Integer::intValue).sum();
            if(totalBills > maxDispenseCount){
                throw new ExceedMaximumLimitException("Exceeds maximum limit of bills");
            }

            for(Map.Entry<Bills,Integer> entry : BillsTmp.entrySet()){
                cashInventory.put(entry.getKey(),cashInventory.get(entry.getKey()) - entry.getValue());
            }

            System.out.println("Withdraw successfully completed: " + BillsTmp);
        }
        catch (BelowMinimumLimitException ex){
            System.out.println(ex.getMessage());
            System.out.println("Minimum limit is " + this.minWithdrawalAmount);
            withdrawCash();
        }
        catch (ExceedMaximumLimitException ex){
            System.out.println(ex.getMessage());
            System.out.println("Maximum limit is " + this.maxDispenseCount + " bills");
            withdrawCash();
        }
        catch (InsufficientFundsException ex){
            System.out.println(ex.getMessage());
            System.out.println("Avaible amount in ATM: " + this.getTotalCash());
            withdrawCash();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private int InputAmount(){
        System.out.print("Enter amount: ");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        return amount;
    }

    private Map<Bills,Integer> calculateBillsForWithdraw(int amount){
        Map<Bills,Integer> tmp = new EnumMap<>(Bills.class);
        int RemainAmount = amount;

        List<Bills> ReverseBills = new ArrayList<>(List.of(Bills.values()));
        Collections.reverse(ReverseBills);

        for(Bills bill : ReverseBills){
            int billValue = bill.getValue();
            int avaibleBills = cashInventory.get(bill);
            int count = Math.min(RemainAmount / billValue,avaibleBills);

            if(count > 0){
                tmp.put(bill,count);
                RemainAmount -= count * billValue;
            }
            if(RemainAmount == 0){
                break;
            }
        }
        return (RemainAmount == 0) ? tmp : null;
    }

}
