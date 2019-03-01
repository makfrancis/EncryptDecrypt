package com.francis.example.attendanceSummary;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessTest {

    @Test
    public void readFileTest() {
        Process process = new Process();


    }

    @Test
    public void getOnTimeTextTest() {
        Process process = new Process();

        process.readFile("C:\\Users\\mark.f.v.macandile\\IdeaProjects\\Tester\\result.csv");

        assertEquals("",process.getOnTimeText());
    }

    @Test
    public void getLateTextTest() {
        Process process = new Process();

        process.readFile("C:\\Users\\mark.f.v.macandile\\IdeaProjects\\Tester\\result.csv");

        assertEquals("mark\t\t13:12",process.getLateText());

    }
}