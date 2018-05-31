package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Debt> listOfDebts = new ArrayList<>();

        Debt debt1 = new Debt(500, .41, 175); listOfDebts.add(debt1);
        Debt debt2 = new Debt(600, .25, 175); listOfDebts.add(debt2);
        Debt debt3 = new Debt(150, .2, 175); listOfDebts.add(debt3);
        Debt debt4 = new Debt(500, .25, 130); listOfDebts.add(debt4);



        HashMap<Boolean, ArrayList<Debt>> newMap = new HashMap<>();

        System.out.println(listOfDebts);
        System.out.println("****");
        listOfDebts.sort(Debt.DebtBalanceComparator);

        newMap.put(true, listOfDebts);

        ListOfDebts.payAllDebtsInFull(newMap);


    }


}
