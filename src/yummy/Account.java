
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

import java.util.ArrayList;
import java.util.List;

/**
 *Abstract class <i> Account</i>, from it inheritance <i>User</i> and <i>Company</i>.
 * This is super class for all types of accounts.
 * Class <i>Account</i> following fields:
 *  String name, is account owner firstname
 *  String surname, is account owner surname
 *  String email, is account owner email
 *  String password, is account owner password 
 *  String localization, is account owner current localization
 *  List Order orders, is history of orders on owner account
 * Beyond setting appropriate paramiters, it also create ArrayList which
 * can store class <i>Order</i>. 
 * It is available for subclasses.
 * 
 * @author fdrew
 */

public abstract class Account {      
    
    private String name;            //account owner name 
    private String surname;         //account owner surname 
    private String email;           //account owner's email
    private String password;        //account owner password
    private String localization;    //localization where/from deliver 
    private List<Order> orders;     //history of orders


    /**
     *Abstract <b>printProfile()</b> method prints to terminal essensial information
     * about the object, which extends class <i>Account</i>. This method doesn't have
     * parameters, but it access specific variables in class useing accessors.
     */
    public abstract void printProfile();
    
    /**
     *<b>Constructor</b> for class <i>Account</i>, it needs five string parameters.
     * Beyond setting appropriate paramiters, it also create ArrayList which
     * can store class <i>Order</i>. 
     * It is available for subclasses.
     * @param name is account owner firstname
     * @param surname is account owner surname
     * @param email is account owner email
     * @param password is account owner password 
     * @param localization is account owner current localization
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
     *Method <b> getName()</b> is an accessor in class <i>Account</i>.
     * @return account owner firstname in String format
     */
    
    public final String getName(){
        return name;
    }
    
    /**
     *Method <b> getSurname()</b> is an accessorin class <i>Account</i>.
     * @return account owner surname in String format
     */
    public String getSurname(){
        return surname;
    }
    
    /**
     *Method <b> getEmail()</b> is an accessorin class <i>Account</i>.
     * @return account owner email in String format
     */
    public String getEmail(){
        return email;
    }
    
    /**
     *Method <b> getPassword()</b> is an accessorin class <i>Account</i>.
     * @return account owner password in String format
     */
    protected String getPassword(){
        return password;
    }
    
    /**
     *Method <b> getLocalization()</b> is an accessorin class <i>Account</i>.
     * @return current localization of account owner in String format
     */
    public String getLocalization(){
        return localization;
    }
    
    /**
     *Method <b> getOrders()</b> is an accessor to list of orders in class <i>Account</i>.
     * @return list of orders in List of <i>Order</i> class type
     */
    public List<Order> getOrders(){
        return orders;
    }
    
    //Hermetization OOP principle - Mutators

    /**
     *Method <b> setName(String newName)</b> is a mutator that changes
     * account owner firstname in class <i>Account</i>.
     * @param newName new account owner firstname provided in String format
     */
    
    public void setName(String newName){
        this.name = newName;
    }
    
    /**
     *Method <b> setSurname(String newSurname)</b> is a mutator that changes
     * account owner surname in class <i>Account</i>.
     * @param newSurname new account owner surname provided in String format
     */
    public void setSurname(String newSurname){
        this.surname = newSurname;
    }
    
    /**
     *Method <b> setEmail(String newEmail)</b> is a mutator that changes
     * account owner email address in class <i>Account</i>.
     * @param newEmail new account owner email provided in String format.
     */
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    
    /**
     *Method <b> setPassword(String newPassword)</b> is a mutator that changes
     * account owner password in class <i>Account</i>.
     * @param newPassword new password is set for specific account in string format.
     */
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    
    /**
     *Method <b> setLocalization(String newLocalization)</b> is a mutator that
     * changes account owner localization in class <i>Account</i>.
     * @param newLocalization new localization is set specific account.
     */
    public void setLocalization(String newLocalization){
        this.localization = newLocalization;
    }
    
    //Methods which helps dealing with list of orders - adding, removeing printing

    /**
     *Method <b> saveOrder(Order newOrder)</b> is a function which add new object
     * <i>Order</i> to existing list on field orders in class <i>Account</i>.
     * @param newOrder element which will be added to the list, type <i>Order</i>
     */
    public void saveOrder(Order newOrder){
        this.orders.add(newOrder);
    }

    /**
     *Method <b> removeOrder(Order orderToRemove)</b> is a function which remove object
     * <i>Order</i> from existing list on field this.orders in class <i>Account</i>.
     * @param orderToRemove element which will be removed from the list, type <i>Order</i>
     */
    public void removeOrder(Order orderToRemove){
        this.orders.remove(orderToRemove);
    }
    
    /**
     *Method <b> printHistoryOrders()</b> is a function which prints whole list
     * of made orders, when list is empty it prints appropriate message, for class <i>Account</i>.
     */
    public void printHistoryOrders(){
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
