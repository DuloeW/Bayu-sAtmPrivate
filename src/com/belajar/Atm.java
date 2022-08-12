package com.belajar;
import java.util.Date;
import java.io.*;
import java.util.*;
public class Atm {
    private String name;
    private String date;
    private String dateNow;
    private Date dateAndTime;
    private Person person;
    private Scanner userInput;
    private FileWriter writeToFile;
    private FileReader readFile;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    
    public Atm() {
        this.name = "Gelgel Atm";
    } 
    
    private String setDate() {
        this.dateAndTime = new Date();
        return this.date = this.dateAndTime.toString();
    }

    private String setDateBill(String dateAndTime) {
        return this.dateNow = dateAndTime;
    }

    private void getBill(String dateAndTime) {
       System.out.println(setDateBill(dateAndTime));
    }

    public void showBill(Person opponent, int took) {
       setDateBill(setDate());
       System.out.println("\n======BILL======");
       System.out.println("Took\t : " + took);
       System.out.print("Balance\t : "); System.out.println(opponent.getBalance());
       System.out.print("Date/Day : "); getBill(setDate());
       System.out.println("================\n");
    }

    public static void displayAtm() {
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("\tPrivate Atm");
        System.out.println("+++++++++++++++++++++++++++");
    }

    // create file log login
    public void logLogin(String mesagge, Person oppPer) throws IOException{
        this.date = "" + setDateBill(setDate()) + "";
        String succes;

        if (!oppPer.getIsRobot()) {
            succes = " Succes ";
        } else {
            succes = " Failed ";
        }
        
        this.writeToFile = new FileWriter("D:\\Bayu Folder\\coding\\Belajar Java\\Dimata Sora Jayate\\Projoect\\dataBase\\logLogin.txt", true);
        this.bufferedWriter = new BufferedWriter(this.writeToFile);
        this.writeToFile.write( succes + mesagge + " on " + this.date);
        this.bufferedWriter.newLine();
        this.bufferedWriter.flush();
        this.writeToFile.close();
        this.bufferedWriter.close();          
    }

    public void readLogLogin() throws IOException{
        Person.clearScreen();
        this.readFile = new FileReader("D:\\Bayu Folder\\coding\\Belajar Java\\Dimata Sora Jayate\\Projoect\\dataBase\\logLogin.txt");
        this.bufferedReader = new BufferedReader(this.readFile);
        this.userInput = new Scanner(this.bufferedReader);

        System.out.println("\n================================Log Login====================================");
        while (this.userInput.hasNextLine()) {
            System.out.println("---------------------------------------------");
            System.out.println(this.userInput.nextLine());
            System.out.println("---------------------------------------------");
        }
        System.out.println("===============================================================================\n");

        this.readFile.close();
        this.bufferedReader.close();
    }
    
}