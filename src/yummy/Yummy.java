/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fdrew
 */
public class Yummy {

    /**
     * @param args the command line arguments
     */
    
    private final List<Company> listOfCompanies;  //list of all companies in aplication
    private final List<User> listOfUsers;         //list of all users in aplication
    private int countCompanies;      //total number of companies
    private int countUsers;          //total number of users
    
    public Yummy(){
        this.listOfCompanies = new ArrayList<Company>();
        this.listOfUsers = new ArrayList<User>();
        this.countCompanies = 0;
        this.countUsers = 0;
    }
    
    //Hermetization OOP principle - Accessors 
    
    public List<Company> getListOfCompanies(){
        return this.listOfCompanies;
    }
    
    public List<User> getListOfUsers(){
        return this.listOfUsers;
    }
    
    public int getCountCompanies(){
        return this.countCompanies;
    }
    
    public int getCountUsers(){
        return this.countUsers;
    }
    
    //Hermetization OOP principle - Mutators

    public void incrementCountCompanies(){
        this.countCompanies += 1;
    }
    
    public void incrementCountUsers(){
        this.countUsers += 1;
    }
    
    public void decreaseCountCompanies(){
        this.countCompanies -= 1;
    }
    
    public void decreaseCountUsers(){
        this.countUsers -= 1;
    }
    
    //Methods which helps managing list of users and companies
    
    public void addElementToListOfCompanies(Company newCompany){    
        this.listOfCompanies.add(newCompany);
        this.incrementCountCompanies();
    }
    
    public void addElementToListOfUsers(User newUser){
        this.listOfUsers.add(newUser);
        this.incrementCountUsers();
    }
    
    public void removeElementToListOfCompanies(Company newCompany){
        this.listOfCompanies.remove(newCompany);
        this.decreaseCountCompanies();
    }
    
    public void removeElementToListOfUsers(User newUser){
        this.listOfUsers.remove(newUser);
        this.decreaseCountUsers();
    }
    
    public Company chooseCompany(String compName){ //go through list and search 
        for(Company C : this.getListOfCompanies()){    // for named product
            if(C.getCompanyName().equals(compName)){
                return C;
            }
        }
        System.out.print("\n No such company");
        return null;
    }
    
    //method for making invoice
    public void createInvoice(User orderingUser){
        Scanner myObj = new Scanner(System.in); 
        System.out.print("Select company: ");
        String compName = myObj.nextLine();
        Company comp = this.chooseCompany(compName); //looking for company
        
        if(comp != null){
            Order firstOrder =  comp.createOrder(orderingUser); //creating invoice
            firstOrder.printOrder();
        }
    }
    
    
    public static void main(String[] args) {
        // creating 3 main classes
        System.out.print("Welcome to Yummy\n");
        System.out.print("This is demo with hardcoded one company acount and one user account \n\n");
        Yummy app = new Yummy();
        User me = new User("Drewno", "Filip","Drewnowski","fd@vp.pl","123","Kielpino gorne","17-02-1998", app);
        Company comp = new Company("NiceShop","Roman","Nice","nice@ro.pl","1234","Wrzeszcz");
        //printing objects
        comp.printProfile();
        me.printProfile();
        
        
        //SHOW POLYMORPHISM EXAMPLE - having such table we can call printProfile method for every object in that table
        
        System.out.print("\nPOLYMORPHISM EXAMPLE \n\n");
        
        Account[] tab = new Account[4];
        tab[0] = new User();
        tab[1] = new User("BOB", "bob","Smith","fdsd@pr.eu","123","Sopot","17-08-1954", app);
        tab[2] = new Company("NiceShop","Roman","Nice","nice@ro.pl","1234","Wrzeszcz");
        tab[3] = new Company("BadShop","Jack","Bad","bad@ru.pl","12we34","Orunia");
        
        int i=0;
        while(i < tab.length){
            tab[i].printProfile();
            i++;
        }
        
        //GIT

        
        
        //adding elements to main base of user and companies
        app.addElementToListOfUsers(me);
        app.addElementToListOfCompanies(comp);
        //checking if insert was succesfully       
        //System.out.print("Elements in user list: " + app.listOfUsers.size() + "\n");
        //System.out.print("Elements in company list: " + app.listOfCompanies.size() + "\n\n");

        //company perspective
        System.out.print("\nCompany perspective \n\n");

        // Create a Scanner object
        Scanner myObj = new Scanner(System.in);  

        String operation = "6";    
        while(!(operation.equals("5"))){
            switch(operation){
                case "1": comp.printProfile();
                    break;
                case "2": comp.printAssortment();
                    break;
                case "3": comp.printHistoryOrders();
                    break;
                case "4": comp.addAssortment();  //creating some new products(need to be added via console)
            }
            System.out.print("Menu for company, press:\n");
            System.out.print("1 - to print profile \n");
            System.out.print("2 - to print all asortment \n");
            System.out.print("3 - to print order history \n");
            System.out.print("4 - to add new assortment \n");
            System.out.print("5 - to quit \n");
            operation = myObj.nextLine();    
        }


        //user perspective 
        System.out.print("\nUser perspective \n\n");

        operation = "5";    
        while(!(operation.equals("4"))){
            switch(operation){
                case "1": me.printProfile();
                    break;
                case "2": me.printHistoryOrders();
                    break;
                case "3": me.getYummyApp().createInvoice(me);
                    break;
            }
            System.out.print("Menu for User, press:\n");
            System.out.print("1 - to print profile \n");
            System.out.print("2 - to print order history \n");
            System.out.print("3 - make order \n");
            System.out.print("4 - to quit \n");
            operation = myObj.nextLine();    
        }
    }
    
}