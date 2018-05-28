package com.company;

public class Payment {

    private double previousBalance;
    private double paymentAmount;
    private double interestAmount; //= ;
    private double principalPaid;
    private double newBalance; // = debt.getBalance() - debt.getPayment() + interestAmount;

    public Payment(double interestAmount, double newBalance) {

        this.interestAmount = interestAmount;
        this.newBalance = newBalance;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalanceAfterPayment(Debt debt) {
        this.newBalance = debt.getBalance() + interestAmount - debt.getPayment();
    }

    public Debt makePayment(Debt debt) {
        Debt newDebt = new Debt;
        newDebt.setBalance();
    }
}
