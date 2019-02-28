package com.francis.example.breakdown;

import static org.junit.Assert.*;

public class MoneyProcessTest {

    @org.junit.Test
    public void moneyProcessTest() {

        MoneyProcess moneyProcess = new MoneyProcess();
        moneyProcess.breakdown(4324);

        assertEquals(4, moneyProcess.getThousand());

        assertEquals(0, moneyProcess.getFiveHundred());

        assertEquals(1, moneyProcess.getTwoHundred());

        assertEquals(1, moneyProcess.getOneHundred());

        assertEquals(0, moneyProcess.getFifty());

        assertEquals(1, moneyProcess.getTwenty());

        assertEquals(0, moneyProcess.getTen());

        assertEquals(0, moneyProcess.getFiveHundred());

        assertEquals(4, moneyProcess.getOne());



    }

}