package com.francis.example.login;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class RecordTest {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    @org.junit.Before
    public void setUp() throws Exception {


    }

    @org.junit.Test
    public void loginTest() {
        Record record = new Record();

        assertEquals("mark.f.v.macandile" +"\t\t"+ dtf.format(now) + "\n",record.enterLearner("mark.f.v.macandile"));
    }

    @org.junit.Test
    public void printResult() {


    }
}