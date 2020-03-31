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
public final class Order {
    
    private double totalPrice;                 //total price from order 
    private final List<Product> allOrderedItems;    //list of all selected products
    private String companyFrom;                 //company in which user buys
    private String whoOrdered;                  //nickname of user
    
    //constructor - order is empty 
    //example of overloading
    public Order(){
        this.totalPrice=0;
        this.allOrderedItems = new ArrayList<Product>();
        this.companyFrom = null;
        this.whoOrdered = null;
    }
    
    //constructor - when we arleady have all information for an order

    public Order(String companyFrom, String whoOrdered, List<Product> listOfProducts){
        this.setCompanyFrom(companyFrom);
        this.setWhoOrdered(whoOrdered);
        this.allOrderedItems = listOfProducts;
        this.setTotalPrice();

    }

    //Hermetization OOP principle - Accessors 
 
    public double getTotalPrice(){
        return this.totalPrice;
    }
    
    public List<Product> getAllOrderedItems(){
        return this.allOrderedItems;
    }
    
    public String getCompanyFrom(){
        return this.companyFrom;
    }   
    
    public String getWhoOrdered(){
        return this.whoOrdered;
    }
    
    //Hermetization OOP principle - Mutators

    public void setTotalPrice(){    //goes through all list and sum their price
        double sum = 0;
        for(Product p : this.getAllOrderedItems()){
            sum += p.getPrice();
        }
        this.totalPrice = sum;
    }
    
    public void setCompanyFrom(String companyFrom){
        this.companyFrom = companyFrom;
    }   
    
    public void setWhoOrdered(String whoOrdered){
        this.whoOrdered = whoOrdered;
    }
    
    //Methods which help dealing with list add and remove element
    
    public void saveOrderedItem(Product newAssortment){
        this.allOrderedItems.add(newAssortment);
    }
    public void removeOrderedItem(Product assortmentToRemove){
        this.allOrderedItems.remove(assortmentToRemove);
    }
    
    public void printOrder(){    //Prints description about product
        System.out.print("Information about Order: \n");
        System.out.print("Who ordered: " + this.getWhoOrdered() + "\nFrom which company: " + this.getCompanyFrom() + "\n" );
        System.out.print("Total price:" + this.getTotalPrice()+ "\n" );
        System.out.print("Things ordered: \n\n");
        for(Product p : this.getAllOrderedItems()){ //for all products in list make print
            p.printProduct();  
        }
        System.out.print("End of order list \n \n");
    }
}
