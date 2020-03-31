
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
    protected String localization;  //localization where/from deliver 
    private List<Order> orders;     //history of orders

    //abstract method
    public abstract void printProfile();
    
    //super constructor for class user and company
    public Account(String name, String surname, String email, String password,String localization){
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
        this.setPassword(password);
        this.setLocalization(localization);
        this.orders = new ArrayList<Order>();
        
    }
    
    //Hermetization OOP principle - Accessors 
    
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getLocalization(){
        return localization;
    }
    
    public List<Order> getOrders(){
        return orders;
    }
    
    //Hermetization OOP principle - Mutators
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setSurname(String newSurname){
        this.surname = newSurname;
    }
    
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    
    public void setLocalization(String newLocalization){
        this.localization = newLocalization;
    }
    
    //Methods which helps dealing with list of orders - adding, removeing printing
    public void saveOrder(Order newOrder){
        this.orders.add(newOrder);
    }
    public void removeOrder(Order orderToRemove){
        this.orders.remove(orderToRemove);
    }
    
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
