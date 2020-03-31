
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fdrew
 */

//abstract class, from it inheritance 'user' and 'company'

public abstract class Account {      
    private String name;            //account owner name 
    private String surname;         //account owner surname 
    private String email;           //account owner's email
    private String password;        //account owner password

    /**
     *
     */
    protected String localization;  //localization where/from deliver 
    private List<Order> orders;     //history of orders

    //abstract method

    /**
     *
     */
    public abstract void printProfile();
    
    //super constructor for class user and company

    /**
     *
     * @param name
     * @param surname
     * @param email
     * @param password
     * @param localization
     */
    public Account(String name, String surname, String email, String password,String localization){
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
        this.setPassword(password);
        this.setLocalization(localization);
        this.orders = new ArrayList<Order>();
        
    }
    
    //Hermetization OOP principle - Accessors 

    /**
     *
     * @return
     */
    
    public String getName(){
        return name;
    }
    
    /**
     *
     * @return
     */
    public String getSurname(){
        return surname;
    }
    
    /**
     *
     * @return
     */
    public String getEmail(){
        return email;
    }
    
    /**
     *
     * @return
     */
    public String getPassword(){
        return password;
    }
    
    /**
     *
     * @return
     */
    public String getLocalization(){
        return localization;
    }
    
    /**
     *
     * @return
     */
    public List<Order> getOrders(){
        return orders;
    }
    
    //Hermetization OOP principle - Mutators

    /**
     *
     * @param newName
     */
    
    public void setName(String newName){
        this.name = newName;
    }
    
    /**
     *
     * @param newSurname
     */
    public void setSurname(String newSurname){
        this.surname = newSurname;
    }
    
    /**
     *
     * @param newEmail
     */
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    
    /**
     *
     * @param newPassword
     */
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    
    /**
     *
     * @param newLocalization
     */
    public void setLocalization(String newLocalization){
        this.localization = newLocalization;
    }
    
    //Methods which helps dealing with list of orders - adding, removeing printing

    /**
     *
     * @param newOrder
     */
    public void saveOrder(Order newOrder){
        this.orders.add(newOrder);
    }

    /**
     *
     * @param orderToRemove
     */
    public void removeOrder(Order orderToRemove){
        this.orders.remove(orderToRemove);
    }
    
    /**
     *
     */
    public void printHistoryOrders(){      //prints all past orders
        if(this.getOrders().isEmpty()){
            System.out.print("Order list is empty!\n \n");
        }
        else{
            for(Order O : this.getOrders()){
                O.printOrder();
            }
        }
    }
}
