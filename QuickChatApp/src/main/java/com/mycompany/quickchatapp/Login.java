package com.mycompany.quickchatapp;

public class Login {

    private String savedUsername;
    private String savedPassword;
    private String savedPhoneNumber;

    // Registers the user
    public String registerUser(String username, String password, String phoneNumber) {

        if (!checkUsername(username)) {
            return "Username is not correctly formatted.";
        }

        if (!checkPassword(password)) {
            return "Password is not correctly formatted.";
        }

        if (!checkPhoneNumber(phoneNumber)) {
            return "Phone number is not correctly formatted.";
        }

        savedUsername = username;
        savedPassword = password;
        savedPhoneNumber = phoneNumber;

        return "User successfully registered.";
    }

    // Username must contain an underscore and be no longer than five characters
    public boolean checkUsername(String username) {

        return username != null
                && username.length() <= 5
                && username.contains("_");
    }
               
    // Password must have 8+ characters, a capital letter, number and special character
    public boolean checkPassword(String password) {

        if (password == null || password.length() < 8) {
            return false;
        }

        boolean capital = false;
        boolean number = false;
        boolean special = false;

        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                capital = true;
            }

            if (Character.isDigit(character)) {
                number = true;
            }

            if (!Character.isLetterOrDigit(character)) {
                special = true;
            }
        }

        return capital && number && special;
    }

    // Phone number must start with +27
    public boolean checkPhoneNumber(String phoneNumber) {

        return phoneNumber != null
                && phoneNumber.startsWith("+27")
                && phoneNumber.length() == 12;
    }

    // Checks login details
    public boolean loginUser(String username, String password) {

        return username.equals(savedUsername)
                && password.equals(savedPassword);
    }

    // Returns login result
    public String returnLoginStatus(boolean loggedIn) {

        if (loggedIn) {
            return "Welcome " + savedUsername + ", it is great to have you back.";
        }

        return "Username or password incorrect, please try again.";
    }
}
