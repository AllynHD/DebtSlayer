package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class ListOfDebts {

    protected HashMap<Boolean, ArrayList<Debt>> payAllDebtsOnce(ArrayList<Debt> debtArrayList) {
        Boolean check = true;
        ArrayList<Debt> debtsReturned = new ArrayList<>();
        HashMap<Boolean, ArrayList<Debt>> genius = new HashMap<>();

        for (Debt debt : debtArrayList) {
            if (debt.getBalance() == 0) {
                continue;

            }
            else if (debt.getPayment() < debt.getBalance() * (1 + debt.getInterestRate() / 12)) {
                Debt newDebt = debt.makeFullPayment(debt);
                debtsReturned.add(newDebt);
            } else {
                Debt newDebt = debt.makeFinalPayment(debt);
                debtsReturned.add(newDebt);
                check = false;
            }
        }

        genius.put(check, debtsReturned);
        return genius;
    }

    protected ArrayList<Debt> payAllDebtsInFull(HashMap<Boolean, ArrayList<Debt>> debtMap) {
        ArrayList<Debt> debtsReturned = new ArrayList<>();
        ArrayList<Debt> debtList = new ArrayList<>();
        for (ArrayList<Debt> list : debtMap.values()) {
            debtList.addAll(list);
        }
        int length = debtList.size();
        int count = 0;

        do {
            debtMap = payAllDebtsOnce(debtList);

            if (debtMap.containsKey(false)) {
                count++;
            }

            debtList.clear();
            System.out.println(debtMap.values());
            System.out.println("-----");

            for (ArrayList<Debt> list : debtMap.values()) {
                debtList.addAll(list);
            }
        }

        while (count < length);

        for (ArrayList<Debt> banana : debtMap.values()){
            debtsReturned.addAll(banana);
        }

        return debtsReturned;
    }

}
