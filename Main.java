package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main implements Cloneable{

    public static void main(String[] args) {
	// write your code here

        ArrayList<Debt> listOfDebts = new ArrayList<>();
        ArrayList<Debt> snowDebts = new ArrayList<>();

        Debt debt1 = new Debt(500, .41, 50); listOfDebts.add(debt1);
        Debt debt2 = new Debt(600, .25, 100); listOfDebts.add(debt2);
        Debt debt3 = new Debt(150, .2, 175); listOfDebts.add(debt3);
        Debt debt4 = new Debt(500, .25, 110); listOfDebts.add(debt4);

        for (Debt debt : listOfDebts) {
            Debt clone = new Debt(debt);
            snowDebts.add(clone);

        }

        //435



        HashMap<Integer, ArrayList<Debt>> snowMap = new HashMap<Integer, ArrayList<Debt>>();

        HashMap<Integer, ArrayList<Debt>> newMap = new HashMap<>();

        //System.out.println(listOfDebts);
        //System.out.println("****");

        newMap.put(0, listOfDebts);
        snowMap.put(0, snowDebts);


        /*ListOfDebts.payAllDebtsInFull(newMap);
        System.out.println("newMap = ");
        System.out.println(newMap);
        System.out.println("snowMap = ");
        System.out.println(snowMap); */
        Snowball.payAllDebtsInFull(snowMap);
        //System.out.println("newMap = ");
        //System.out.println(newMap);
        System.out.println("snowMap = ");
        System.out.println(snowMap);
        //


       // ListOfDebts.payAllDebtsOnce(snowMap);


    }


}
