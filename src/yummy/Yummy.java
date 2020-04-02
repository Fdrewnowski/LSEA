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
 *Class Yummy is main class for this project. It stores two lists of companies in the system and users.
 * 
 * @author fdrew
 */
public class Yummy {
    
    private final List<Company> listOfCompanies;  //list of all companies in aplication
    private final List<User> listOfUsers;         //list of all users in aplication
    private int countCompanies;      //total number of companies
    private int countUsers;          //total number of users
    
    /**
     *<b>Constructor</b> for class <i>Yummy</i>, no parameters needed. Creates two ArrayList 
     * one for all companies that will be in the system second for all the users that will be in system.
     * There are also two fields which count number of objects in this lists. 
     */
    public Yummy(){
        this.listOfCompanies = new ArrayList<Company>();
        this.listOfUsers = new ArrayList<User>();
        this.countCompanies = 0;
        this.countUsers = 0;
    }
    
    //Hermetization OOP principle - Accessors 

    /**
     *Method <b> getListOfCompanies()</b> is an accessor in class<i>Yummy</i>.
     * @return field listOfCompanies which is array list of companies
     */
    
    public List<Company> getListOfCompanies(){
        return this.listOfCompanies;
    }
    
    /**
     *Method <b> getListOfUsers()</b> is an accessor in class<i>Yummy</i>.
     * @return field listOfUsers which is array list of users
     */
    public List<User> getListOfUsers(){
        return this.listOfUsers;
    }
    
    /**
     *Method <b> getCountCompanies()</b> is an accessor in class<i>Yummy</i>.
     * @return number of companies entered to the system, int type
     */
    public int getCountCompanies(){
        return this.countCompanies;
    }
    
    /**
     *Method <b> getCountUsers()</b> is an accessor in class<i>Yummy</i>.
     * @return number of users entered to the system, int type
     */
    public int getCountUsers(){
        return this.countUsers;
    }
    
    //Hermetization OOP principle - Mutators

    /**
     *Method <b>incrementCountCompanies()</b> increment field countCompanies.
     */

    public void incrementCountCompanies(){
        this.countCompanies += 1;
    }
    
    /**
     *Method <b>incrementCountCompanies()</b> increment field countUsers.
     */
    public void incrementCountUsers(){
        this.countUsers += 1;
    }
    
    /**
     *Method <b>incrementCountCompanies()</b> decrement field countCompanies.
     */
    public void decreaseCountCompanies(){
        this.countCompanies -= 1;
    }
    
    /**
     *Method <b>incrementCountCompanies()</b> decrement field countUsers.
     */
    public void decreaseCountUsers(){
        this.countUsers -= 1;
    }
    
    //Methods which helps managing list of users and companies
    
    /**
     *Method <b> addElementToListOfCompanies(Company newCompany)</b> is a function which save new object
     * <i>Company</i> to existing list on field listOfCompanies in class <i>Yummy</i>
     * and increment number of companies.
     * @param newCompany Company object that will be added to list 
     */
    public void addElementToListOfCompanies(Company newCompany){    
        this.listOfCompanies.add(newCompany);
        this.incrementCountCompanies();
    }
    
    /**
     *Method <b> addElementToListOfUsers(User newUser)</b> is a function which save new object
     * <i>User</i> to existing list on field listOfUsers in class <i>Yummy</i> and 
     * increments number of users.
     * @param newUser user object that will be added to list 
     */
    public void addElementToListOfUsers(User newUser){
        this.listOfUsers.add(newUser);
        this.incrementCountUsers();
    }
    
    /**
     *Method <b> removeElementToListOfCompanies(Company newCompany)</b> is a function which remove object
     * <i>Company</i> from existing list on field listOfCompanies in class <i>Yummy</i> 
     * and decrement number of companies.
     * @param newCompany company object that will be removed from the list 
     */
    public void removeElementToListOfCompanies(Company newCompany){
        this.listOfCompanies.remove(newCompany);
        this.decreaseCountCompanies();
    }
    
    /**
     *Method <b> removeElementToListOfUsers(User newUser)</b> is a function which remove object
     * <i>User</i> from existing list on field listOfUsers in class <i>Yummy</i> 
     * and decrement number of users.
     * @param newUser user object that will be removed from the list
     */
    public void removeElementToListOfUsers(User newUser){
        this.listOfUsers.remove(newUser);
        this.decreaseCountUsers();
    }
    
    /**
     *Method <b> chooseCompany(String compName)</b> is a function, which goes through
     * list of companies and return refference to Company with specified Company name, if
     * there is no such name return null value.
     * @param compName name of company that is search
     * @return object <i>Company</i> if compName matches name or null
     */
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

    /**
     *Method <b>createInvoice(User orderingUser)</b> allows to create <i>Order</i> by the <i>User</i>.
     * <i>User</i> in terminal is asked to choose company from which he want to order and 
     * then Order is created.
     * @param orderingUser User who is making order
     */
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
    
    /**
     *Main for general testing
     * @param args
     */
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
