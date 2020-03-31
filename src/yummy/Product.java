/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

/**
 *
 * @author fdrew
 */
public class Product {
    
    private String name;                //name of product
    private double price;               //price of product
    private static String description;  //short product description
    private boolean onStock;            //info about availablility
    
    //Constructor - creating product

    /**
     *
     * @param name
     * @param price
     * @param description
     * @param onStock
     */
    
    public Product(String name, double price, String description, boolean onStock){
        this.setName(name);
        this.setPrice(price);
        this.setdescription(description);
        this.setIfOnStock(onStock);
    }
    
    //Hermetization OOP principle - Accessors 

    /**
     *
     * @return
     */

    public String getName(){
        return this.name;
    }

    /**
     *
     * @return
     */
    public double getPrice(){
        return this.price;
    }

    /**
     *
     * @return
     */
    public String getdescription(){
        return this.description;
    }

    /**
     *
     * @return
     */
    public boolean getIfOnStock(){
        return this.onStock;
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
     * @param newPrice
     */
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    /**
     *
     * @param newDesc
     */
    public void setdescription(String newDesc){
        this.description = newDesc;
    }

    /**
     *
     * @param IfOnStock
     */
    public void setIfOnStock(boolean IfOnStock){
        this.onStock = IfOnStock;
    }
    
    /**
     *
     */
    public void printProduct(){    //Prints description about product
        System.out.print("Information about Product: \n");
        System.out.print("Name: " + this.getName() + " Price: " + this.getPrice() + "\n" );
        System.out.print("Description: " + this.getdescription() + "\n" );
        System.out.print("Is it on stock: " + this.getIfOnStock() + "\n\n" );
    }
}
