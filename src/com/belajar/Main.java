package com.belajar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner userInput = new Scanner(System.in);
        int choose;
        Person person1 = new Person();
        Atm atm1 = new Atm();
        person1.setAtm(atm1);
        Person.clearScreen();
        
        // proses user login hingga benar
        while (person1.getFirstRepeat()) {
            Atm.displayAtm();
            person1.login(person1, atm1);  
            Person.delay();
        }   

        // proses user memilih menu pilihan
        while (person1.getSecondRepeat()) {
            if (!person1.getIsRobot()) {
                person1.showBalance();
                System.out.println("+++++++++++++++++++++++++++");
                System.out.println("Please select the menu below");
                System.out.println("\n[1] Saving\n[2] Took saving\n[3] Show saving\n[4] Log login\n");
                System.out.print("Choose\t\t: ");
                choose = userInput.nextInt();

                if (choose == 1) {
                    person1.saving();
                } else if (choose == 2) {
                    person1.tookSaving(atm1, person1);
                } else if (choose == 3) {
                    person1.showBalance();
                } else if (choose == 4) {
                    atm1.readLogLogin();
                } else {
                    System.out.println("+++++++++++++++++++++++++++");
                    System.out.println("Your input is wrong!!");
                }
 
                person1.backToMenu();

            } else {
                Person.endRobot();
                System.out.println(" ");
                person1.setSecondRepeat();
            }
        }
    }
}
