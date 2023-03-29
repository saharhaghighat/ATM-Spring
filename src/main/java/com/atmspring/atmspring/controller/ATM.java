package com.atmspring.atmspring.controller;

package controller;

import exceptions.AgeException;
import exceptions.NotFoundException;
import model.Account;
import model.User;
import service.AccountService;
import service.UserService;
import utill.Utill;

import java.time.LocalDate;

public class ATM {
    private static final int LOGIN = 1;
    private static final int REGISTER = 2;


    private static final int BALANCE = 1;
    private static final int DEPOSIT = 2;
    private static final int WITHDRAW = 3;
    private static final int TRANSACTIONS = 4;
    private static final int TRANSFER = 5;
    private static final int EXIT = 9;


    private UserService userService = new UserService();
    private AccountService accountService = new AccountService();
    private DataBase database = DataBase.getInstance();


    Account currentAccount;
    private boolean isAuthenticated = false;
    private boolean isUserExited = false;


    public void run() {
        if (!isAuthenticated || isUserExited)
            firstMenu();
        while (!isUserExited && isAuthenticated) {
            try {
                Integer item = (Integer) Utill.getInput("""
                        1-Show Balance
                        2-Deposit
                        3-Withdraw
                        4-Get last 10 transactions
                        5-Transfer money
                        9-Exit
                        """, Integer.class);
                mainMenu(item);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                run();
            }
        }
    }


    //for logging or registering
    public void firstMenu() {
        int select = (int) Utill.getInput("1-Login as a member\n2-Create a new account", int.class);
        switch (select) {
            case LOGIN -> {
                while (!isAuthenticated) {
                    login();
                }
            }
            case REGISTER -> {
                register();
                run();
            }
            default -> {
                Utill.print("You did not enter a valid selection. Try again.");
                firstMenu();
            }
        }
    }

    public void mainMenu(Integer item) {
        switch (item) {
            case BALANCE -> Utill.print("your balance is:" +
                    currentAccount.getBalance() +
                    "$");
            case DEPOSIT -> {
                deposit();
                Utill.print("your balance is:" +
                        currentAccount.getBalance() +
                        "$");
            }
            case WITHDRAW -> {
                withdraw();
                Utill.print("your balance is:" +
                        currentAccount.getBalance() +
                        "$");
            }
            case TRANSACTIONS -> Utill.print(accountService.LastTenTransaction(currentAccount.getCard().getCardNumber()));

            case TRANSFER -> transfer();
            case EXIT -> isUserExited = true;
        }
    }

    private void deposit() {
        Double amount = (Double) Utill.getInput("Please Enter amount:", Double.class);
        currentAccount.deposit(amount);
    }

    private void withdraw() {
        try {
            Double amount = (Double) Utill.getInput("Please Enter amount:", Double.class);
            currentAccount.withDraw(amount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            run();
        }
    }

    private void register() {
        try {
            String fName = (String) Utill.getInput("Enter your Name :", String.class);
            String lName = (String) Utill.getInput("Enter your family :", String.class);
            String nId = (String) Utill.getInput("Enter your national ID :", String.class);

            Utill.print("Enter your date of birth (yyyy-mm-dd): ");
            String date = (String) Utill.getInput("", String.class);
            LocalDate bDay = LocalDate.parse(date);
            User user = userService.createUser(fName, lName, nId, bDay);
            String password = (String) Utill.getInput("Enter password :", String.class);
            Integer type = (Integer) Utill.getInput("""
                    Enter the account type you want:
                    1.jari
                    2.seporde
                    3.gharzolhasane
                    """, Integer.class);

            Account account = accountService.createAccount(user, type, password);
            Utill.print("your can login with your card number: " + account.getCard().getCardNumber());
        } catch (AgeException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            firstMenu();
        }
    }

    private void login() {
        try {
            String cardNumber = (String) Utill.getInput("please Enter your card Number:", String.class);
            String password = (String) Utill.getInput("please enter your password:", String.class);
            currentAccount = accountService.login(cardNumber, password);
            isAuthenticated = true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void transfer() {
        try {
            String toCard = (String) Utill.getInput("please Enter card Number:", String.class);
            Double amount = (Double) Utill.getInput("Please Enter amount:", Double.class);
            accountService.moneyTransfer(currentAccount.getCard().getCardNumber(), toCard, amount);
        } catch (NotFoundException ex) {
            ex.printStackTrace();
            run();
        }
    }

}
