package com.company;

import java.util.*;

public class Snowball {

    public static HashMap<Integer, ArrayList<Debt>> singleSnowball(HashMap<Integer, ArrayList<Debt>> snowMap) {

        /*list.sort(Debt.DebtBalanceComparator);
        HashMap<Integer, ArrayList<Debt>> snowMap = new HashMap();
        snowMap.put(0, list);
        list = ListOfDebts.payAllDebtsInFull(snowMap);
        return list;  */

        ArrayList<Debt> debtsFromIncoming = new ArrayList<>();
        ArrayList<Debt> debtsForReturn = new ArrayList<>();
        HashMap<Integer, ArrayList<Debt>> genius = new HashMap<Integer, ArrayList<Debt>>();
        Integer[] debtList = new Integer[1];

        Set<Map.Entry<Integer, ArrayList<Debt>>> debtSet = snowMap.entrySet();
        for (Map.Entry<Integer, ArrayList<Debt>> entry : debtSet) {
            Integer check = entry.getKey();
            debtList[0] = check;
            ArrayList<Debt> holder = entry.getValue();
            debtsFromIncoming.addAll(holder);

            break;
        }


            for (Debt debt : debtsFromIncoming) {
                if (debt.getBalance() == 0) {
                    if (debt.getPayment() == 0) {
                        debt.setTransfer(0);
                        debtsForReturn.add(debt);
                        continue;
                    } else {
                        int setup = debtsFromIncoming.indexOf(debt);
                        if (setup < debtsFromIncoming.size() - 1) {
                            debt.setTransfer(debt.getPayment());
                            debt.setPayment(0);
                            Debt nextDebt = debtsFromIncoming.get(setup + 1);
                            nextDebt.setPayment(nextDebt.getPayment() + debt.getTransfer());
                        }

                        debtsForReturn.add(debt);
                        continue;
                    }

                } else if (debt.getPayment() < debt.getBalance() * (1 + debt.getInterestRate() / 12)) {

                    Debt newDebt = debt.makeFullPayment(debt);
                    debtsForReturn.add(newDebt);
                } else {
                    Debt newDebt = debt.makeFinalPayment(debt);
                    int setup = debtsFromIncoming.indexOf(debt);
                    if (setup < debtsFromIncoming.size() - 1) {
                        Debt nextDebt = debtsFromIncoming.get(setup + 1);
                        nextDebt.setPayment(nextDebt.getPayment() + debt.getTransfer());
                    }
                    debtsForReturn.add(newDebt);
                    debtList[0] += 1;
                }
            }

        //do above while debtList[0] < debtsFromIncoming.size()


        genius.put(debtList[0], debtsForReturn);
        return genius;


    }


    protected static HashMap<Integer, ArrayList<Debt>> payAllDebtsInFull(HashMap<Integer, ArrayList<Debt>> debtMap) {
        Integer[] keyArray = {0};
        //Debt[] debtArray = new Debt[...];
        boolean check;
        debtMap.keySet().toArray(keyArray);

        ArrayList<Debt> debtList = debtMap.get(keyArray[0]);
        System.out.println(debtList);
        debtList.sort(Debt.DebtBalanceComparator);
        System.out.println(debtList);

        int length = debtList.size();
        //ArrayList<Debt> debtList = new ArrayList<>();
        /*for (ArrayList<Debt> list : debtMap.values()) {
            debtList.addAll(list);
        }*/
        //Collection blah = debtMap.values();


        //int count = 0;

        do {
            debtMap = singleSnowball(debtMap);
            debtMap.keySet().toArray(keyArray);

            System.out.println(debtMap.values());
            System.out.println("-----");


            check = (keyArray[0] <length );
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
