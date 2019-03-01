package com.francis.example.attendanceList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecordTest {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    @org.junit.Before
    public void setUp() throws Exception {


    }

    @org.junit.Test
    public void enterLearnerValidTest() {
        Record record = new Record();

        assertEquals("EID Successfully added",record.enterLearner("mark.f.v.macandile"));

    }

    @org.junit.Test
    public void enterLearnerInvalidTest() {
        Record record = new Record();
        record.enterLearner("mark.f.v.macandile");
        assertEquals("User Already Exists" ,record.enterLearner("mark.f.v.macandile"));

    }

    @org.junit.Test
    public void printResult() {

        Record record = new Record();
        record.enterLearner("mark.f.v.macandile");
        List<Account> actual = record.getAccount();
        List<Account> expected = new ArrayList<>();
        expected.add(new Account("mark.f.v.macandile",now));
        assertEquals(expected.get(0).getEid() ,actual.get(0).getEid());
        assertEquals(dtf.format(expected.get(0).getNow()) ,dtf.format(actual.get(0).getNow()));




    }
}