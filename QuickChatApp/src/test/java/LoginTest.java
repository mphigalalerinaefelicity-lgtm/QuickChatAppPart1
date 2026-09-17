package com.mycompany.quickchatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testValidUsername() {

        Login userAccount = new Login();

        assertTrue(
                userAccount.checkUsername("sessy")
        );
    }

    @Test
    public void testInvalidUsername() {

        Login userAccount = new Login();

        assertFalse(
                userAccount.checkUsername("rinaesessy")
        );
    }

    @Test
    public void testValidPassword() {

        Login userAccount = new Login();

        assertTrue(
                userAccount.checkPassword("Sessy@2026")
        );
    }

    @Test
    public void testInvalidPassword() {

        Login userAccount = new Login();

        assertFalse(
                userAccount.checkPassword("sessy123")
        );
    }

    @Test
    public void testValidPhoneNumber() {

        Login userAccount = new Login();

        assertTrue(
                userAccount.checkPhoneNumber("+27876543210")
        );
    }

    @Test
    public void testInvalidPhoneNumber() {

        Login userAccount = new Login();

        assertFalse(
                userAccount.checkPhoneNumber("0876543210")
        );
    }

    @Test
    public void testSuccessfulLogin() {

        Login userAccount = new Login();

        userAccount.registerUser(
                "sessy",
                "Sessy@2026",
                "+27876543210"
        );

        assertTrue(
                userAccount.loginUser(
                        "sessy",
                        "Sessy@2026"
                )
        );
    }

    @Test
    public void testFailedLogin() {

        Login userAccount = new Login();

        userAccount.registerUser(
                "sessy",
                "Sessy@2026",
                "+27876543210"
        );

        assertFalse(
                userAccount.loginUser(
                        "sessy",
                        "Wrong@123"
                )
        );
    }
}