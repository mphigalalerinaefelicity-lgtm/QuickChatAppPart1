package com.mycompany.quickchatapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login userAccount = new Login();

        System.out.println("================================");
        System.out.println("       QUICKCHAT REGISTER       ");
        System.out.println("================================");

        System.out.print("Create username: ");
        String username = input.nextLine();

        System.out.print("Create password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone number (+27): ");
        String phoneNumber = input.nextLine();

        String registrationMessage =
                userAccount.registerUser(
                        username,
                        password,
                        phoneNumber
                );

        System.out.println(registrationMessage);

        if (registrationMessage.equals("User successfully registered.")) {

            System.out.println();
            System.out.println("================================");
            System.out.println("             LOGIN              ");
            System.out.println("================================");

            System.out.print("Username: ");
            String loginUsername = input.nextLine();

            System.out.print("Password: ");
            String loginPassword = input.nextLine();

            boolean loginStatus =
                    userAccount.loginUser(
                            loginUsername,
                            loginPassword
                    );

            System.out.println(
                    userAccount.returnLoginStatus(loginStatus)
            );
        }

        input.close();
    }
}