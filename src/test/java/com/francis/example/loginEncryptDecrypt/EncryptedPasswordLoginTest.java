package com.francis.example.loginEncryptDecrypt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EncryptedPasswordLoginTest {

    @Test
    public void registerValidTest() {
        EncryptedPasswordLogin epl = new EncryptedPasswordLogin();

        assertEquals("Added new Account",epl.register("franciso","password"));
    }

    @Test
    public void registerErrorUsernameExists() {
        EncryptedPasswordLogin epl = new EncryptedPasswordLogin();

        assertEquals("Sorry Username Already exist",epl.register("francis","password"));
    }

    @Test
    public void loginValid() {
        EncryptedPasswordLogin epl = new EncryptedPasswordLogin();
        assertEquals("SUCCESSFULLY LOGIN", epl.login("francis","password"));
    }

    @Test
    public void loginError() {
        EncryptedPasswordLogin epl = new EncryptedPasswordLogin();
        assertEquals("No accounts found", epl.login("francisaaaa","password"));
    }



    @Test
    public void readFile() {
        EncryptedPasswordLogin epl = new EncryptedPasswordLogin();
        List<Account> exptected = new ArrayList<>();
        List<Account> actual = epl.readFile("listOfAccountsTest.csv");
        exptected.add(new Account("ronelle", "YQ=="));
        assertEquals(exptected.get(0).getUsername() + exptected.get(0).getPassword(),actual.get(0).getUsername() + actual.get(0).getPassword());
    }

    @Test
    public void writeFile() {

        EncryptedPasswordLogin epl = new EncryptedPasswordLogin();
        List<Account> exptected = new ArrayList<>();
        exptected.add(new Account("ronelle", "YQ=="));
        epl.readFile("listOfAccountsTest.csv");
        epl.writeFile();
        List<Account> actual = epl.readFile("listOfAccounts.csv");

        assertEquals(exptected.get(0).getUsername() + exptected.get(0).getPassword(),actual.get(0).getUsername()+actual.get(0).getPassword());
//        assertEquals();
    }
}