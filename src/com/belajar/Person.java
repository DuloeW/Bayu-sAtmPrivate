package com.belajar;

import java.util.Scanner;

public class Person {
    private String name;
    private String idCard;
    private int balance;
    private int maxTry;
    private boolean isRobot;
    private boolean firstRepeat;
    private boolean secondRepeat;
    private Atm atm;
    private Scanner userInput;

    public Person() {
        this.name = "Admin";
        this.idCard = "23102005";
        this.isRobot = true;
        this.balance = 0;
        this.maxTry = 3;
        this.firstRepeat = true;
        this.secondRepeat = true;
        this.userInput = new Scanner(System.in);
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    public boolean getIsRobot() {
        return this.isRobot;
    }

    public boolean getFirstRepeat() {
        return this.firstRepeat;
    }

    public boolean getSecondRepeat() {
        return this.secondRepeat;
    }

    public void setSecondRepeat() {
        this.secondRepeat = false;
    }

    public int getMaxTry() {
        return this.maxTry;
    }

    public int getBalance() {
        return this.balance;
    }

    // create login logic
    public void login(Person oppPer, Atm atm) throws Exception {
        String id;
        String userName;

        System.out.print("Login\t\t");
        System.out.println(getMaxTry() + " try");
        System.out.print("User name\t: ");
        userName = userInput.next();
        System.out.print("Id card\t\t: ");
        id = userInput.next();

        if (userName.equals(this.name) && id.equals(this.idCard)) {
            this.isRobot = false;
            delay();
            System.out.println("Login succes");
        } else {
            this.isRobot = true;
            delay();
            System.out.println("Id card / user name wrong!!");
        }

        delay();
        clearScreen();
        atm.logLogin("Login", oppPer);
        loginOpportunity(oppPer);

    }

    // create delay method
    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Bibs bez bub!!");
        }
    }

    // create saving logic
    public void saving() {
        int priceSaving;
        System.out.println("+++++++++++++++++++++++++++");
        System.out.print("How many? : ");
        priceSaving = userInput.nextInt();
        this.balance += priceSaving;
        System.out.println("Succes saving " + priceSaving + " " + valueOfMoney(priceSaving));
    }

    // create shoBalance method
    public void showBalance() {
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("Your balance\t: " + this.balance);
    }

    // create tookSaving logic
    public void tookSaving(Atm atmOpp, Person perOpp) {
        int priceTook;
        System.out.println("+++++++++++++++++++++++++++");
        System.out.print("How many? : ");
        priceTook = userInput.nextInt();

        if (this.balance == 0) {
            System.out.println("Can't took saving");
            System.out.println("Your balance is 0");
        } else {
            if (this.balance < priceTook) {
                System.out.println("Your balance is low");
            } else {
                this.balance -= priceTook;
                System.out.println("Succes took " + priceTook + " " + valueOfMoney(priceTook));
                delay();
                System.out.print("Wait for your nota ");

                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < 10; j++) {
                        delay();
                        System.out.print(" .");
                    }
                    System.out.print("\n");
                }

                delay();
                System.out.println("Succes creating nota :)");
                delay();
                clearScreen();
                atmOpp.showBill(perOpp, priceTook);
            }
        }
    }

    // create cls method
    static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (final Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // cerate opportunity logic
    private void loginOpportunity(Person oppPer) {
        this.maxTry -= 1;
        if (oppPer.getIsRobot() == false) {
            this.firstRepeat = false;
        } else {
            if (this.maxTry == 0) {
                this.firstRepeat = false;
                // this.secondRepeat = false;
            } else {
                for (int i = 30; i >= 0; i--) {
                    System.out.print("\n\n\n\t\tTry again after " + i + " seconds \n");
                    Person.delay();
                    Person.clearScreen();
                }
            }
        }
    }

    // create backToMenu method
    public void backToMenu() {
        String choose;
        System.out.print("Back to menu? (y/n): ");
        choose = userInput.next();
        if (choose.equalsIgnoreCase("y")) {
            System.out.print("\n");
            Person.clearScreen();
            this.secondRepeat = true;
        } else if (choose.equalsIgnoreCase("n")) {
            clearScreen();
            end();
            this.secondRepeat = false;
        } else {
            clearScreen();
            end();
            this.secondRepeat = false;
        }
    }

    private String valueOfMoney(int value) {
        if (value < 1000) {
            return "rupiah";
        } else if (value == 1000) {
            return "one thousand";
        } else if (value < 999999) {
            return "thousand";
        } else {
            return "million";
        }
    }

    public static void end() {
        System.out.println("        ==========");
        System.out.println("      ==============");
        System.out.println("    ==================");
        System.out.println("  ======================");
        System.out.println("==========================");
        System.out.println("\tThank you ");
        System.out.println("==========================");
        System.out.println("  ======================");
        System.out.println("    ==================");
        System.out.println("      ==============");
        System.out.println("        ==========\n");
    }

    public static void endRobot() {
        System.out.println("        ==========");
        System.out.println("      ==============");
        System.out.println("    ==================");
        System.out.println("  ======================");
        System.out.println("==========================");
        System.out.println("\tBye Bye Robot");
        System.out.println("==========================");
        System.out.println("  ======================");
        System.out.println("    ==================");
        System.out.println("      ==============");
        System.out.println("        ==========");
    }

}