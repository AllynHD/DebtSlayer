package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Snowball {

    public static ArrayList<Debt> growSnowball(ArrayList<Debt> list) {

        list.sort(Debt.DebtBalanceComparator);
        HashMap<Boolean, ArrayList<Debt>> snowMap = new HashMap();
        snowMap.put(true, list);
        list = ListOfDebts.payAllDebtsInFull(snowMap);
        return list;


    }

}
