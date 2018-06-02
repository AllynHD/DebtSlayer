package com.company;

import java.util.*;

public class ListOfDebts {

    protected static HashMap<Integer, ArrayList<Debt>> payAllDebtsOnce(HashMap<Integer, ArrayList<Debt>> hashMap) {

        //Take in integer that triggers end of while loop, arraylist of Debt objects to iterate through for payment
        //need to pull that info out - so use entrySet(), then getKey and getValue - put those into new variables
        //Key will only change if makeFinalPayment gets run, then will be put back into genius (Final HM)
        //Value will run through forLoop

        ArrayList<Debt> debtsFromIncoming = new ArrayList<>();
        ArrayList<Debt> debtsForReturn = new ArrayList<>();
        HashMap<Integer, ArrayList<Debt>> genius = new HashMap<>();
        Integer[] debtList = new Integer[1];

        Set<Map.Entry<Integer, ArrayList<Debt>>> debtSet = hashMap.entrySet();
        for (Map.Entry<Integer, ArrayList<Debt>> entry : debtSet) {
            Integer check = entry.getKey();
            debtList[0] = check;
            ArrayList<Debt> holder = entry.getValue();
            debtsFromIncoming.addAll(holder);
            break;
        }

        for (Debt debt : debtsFromIncoming) {
            if (debt.getBalance() == 0) {
                debtsForReturn.add(debt);
                continue;

            }
            else if (debt.getPayment() < debt.getBalance() * (1 + debt.getInterestRate() / 12)) {

                Debt newDebt = debt.makeFullPayment(debt);
                debtsForReturn.add(newDebt);
            } else {
                Debt newDebt = debt.makeFinalPayment(debt);
                debtsForReturn.add(newDebt);
                debtList[0] += 1;
            }
        }

        genius.put(debtList[0], debtsForReturn);
        return genius;
    }

    protected static HashMap<Integer, ArrayList<Debt>> payAllDebtsInFull(HashMap<Integer, ArrayList<Debt>> debtMap) {
        Integer[] keyArray = {0};
        boolean check;
        ArrayList<Debt> debtList = new ArrayList<>();
        //ArrayList<Debt> debtList = new ArrayList<>();
        /*for (ArrayList<Debt> list : debtMap.values()) {
            debtList.addAll(list);
        }*/
        Set<Map.Entry<Integer, ArrayList<Debt>>> debtSet = debtMap.entrySet();
        for (Map.Entry<Integer, ArrayList<Debt>> entry : debtSet) {
            ArrayList<Debt> holder = entry.getValue();
            debtList.addAll(holder);
            break;
        }


        //int count = 0;

        do {
            debtMap = payAllDebtsOnce(debtMap);

            System.out.println(debtMap.values());
            System.out.println("-----");

            Set<Integer> keySet = debtMap.keySet();
            keyArray = keySet.toArray(new Integer[0]);
            Integer key = keyArray[0];
            check = (key < debtList.size() - 1);
            System.out.println(check);


            /*for (ArrayList<Debt> list : debtMap.values()) {
                for (int i = 0; i < list.size(); i++) {
                    debtList.set(i, list.get(i));
                    }
            } */

        }
        while (check);

        /*for (ArrayList<Debt> banana : debtMap.values()){
            debtsReturned.addAll(banana);
        }*/

        return debtMap;
    }

}
