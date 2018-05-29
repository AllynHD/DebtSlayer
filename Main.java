package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Debt debt = new Debt(500, .25, 175);
        debt.makeFullPayment(debt);
        debt.makeFullPayment(debt);
        debt.makeFinalPayment(debt);

        debt.setBalance(500);
        debt.setInterestRate(.25);
        debt.setPayment(175);
        System.out.println(debt.toString());
        debt.seeAllPayments(debt);
    }
}
