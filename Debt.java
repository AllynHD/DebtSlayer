package com.company;

import java.util.ArrayList;

public class Debt {

    private double balance;
    private double interestRate;
    private double monthlyPayment;
    private double totalPaid = 0;
    private double totalInterest = 0;
    private double interestAmount;
    //private int userId;

    public Debt(double balance, double interestRate, double payment) { //add userId into constructor after learning how to session
        //this();
        this.balance = balance;
        this.interestRate = interestRate;
        this.monthlyPayment = payment;

        //add userId after learning how to session
    }

    //public Debt(){
        //userid
    //}


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getPayment() {
        return monthlyPayment;
    }

    public void setPayment(double payment) {
        this.monthlyPayment = payment;
    }

    public void setInterestAmount(Debt debt) { //Can add term variability here eventually
        interestAmount = debt.getInterestRate() * debt.getBalance() / 12;}

    protected Debt seeAllPayments(Debt debt) { //ArrayList<Payment> for return type
        int numPayments = 0;
        while (debt.getPayment() < debt.getBalance() * (1 + debt.getInterestRate()/12)) {
            makeFullPayment (debt); //Add payment to payment list as final step, return
            numPayments++;} //numPayments in Payment class or in Debt class?
        makeFinalPayment(debt); //**
        return debt;

        //return paymentList;
    }

    protected Debt makeFullPayment(Debt debt){ //could do a "make payment" method, then call each of these where they differ.
        double newBalance;
        setInterestAmount(debt);
        newBalance = balance + interestAmount - monthlyPayment;
        totalInterest += interestAmount;
        totalPaid += monthlyPayment;
        balance = newBalance;
        System.out.println(debt.toString());
        return debt;
    }

    protected Debt makeFinalPayment(Debt debt){
        double transfer;
        setInterestAmount(debt);
        this.balance = this.balance + interestAmount;
        transfer = this.monthlyPayment - this.balance;
        this.monthlyPayment = this.balance;
        totalInterest += interestAmount;
        totalPaid += monthlyPayment;
        this.balance = 0;
        System.out.println(debt.toString());
        return debt;
    }

    @Override
    public String toString() {
        return "Debt{" +
                "balance=" + balance +
                ", interestRate=" + interestRate +
                ", monthlyPayment=" + monthlyPayment +
                ", totalPaid=" + totalPaid +
                ", totalInterest=" + totalInterest +
                ", interestAmount=" + interestAmount +
                '}';
    }
}
