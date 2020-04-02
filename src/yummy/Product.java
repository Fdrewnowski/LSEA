/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

import java.util.Scanner;

enum State {LIQUID, FOOD, ITEM, ICE};

/**
 *Class <i>Product</i> represent real products offered by companies. It has its
 * unique name, description, price and information about availability.
 * @author fdrew
 */
public class Product implements Cloneable{
    
    private String name;                //name of product
    private double price;               //price of product
    private static String description;  //short product description
    private boolean onStock;            //info about availablility
    private State productState; //info about product
    

    /**
     *<b>Constructor</b> for class <i>Product</i>, it needs following parameters 
     * two string parameters describing object(name,description), double parameter
     * for price and boolean type for availability.
     * @param name is a name of product in String format
     * @param price is a price of a product in double format
     * @param description is a description of a product in String format
     * @param onStock  is a boolean type and represent availability of a product
     */
    
    public Product(String name, double price, String description, boolean onStock){
        this.setName(name);
        this.setPrice(price);
        this.setdescription(description);
        this.setIfOnStock(onStock);
        this.setState();
    }
    
    /**
     * Method <b>clone()</b> useing interface <i>Cloneable</i> allows for deep cloning
     * of <i>Product</i> objects.
     * @return new <i>Product</i> object which is a copy of orginal <i>Product</i>
     * @throws CloneNotSupportedException 
     */
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        Product cloned = (Product)super.clone();
        return cloned;
    }
    
    //Hermetization OOP principle - Accessors 

    /**
     *Method <b> getName()</b> is an accessor in class <i>Product</i>.
     * @return name of the product in String format
     */

    public String getName(){
        return this.name;
    }

    /**
     *Method <b> getPrice()</b> is an accessor in class <i>Product</i>.
     * @return price of the product in double format
     */
    public double getPrice(){
        return this.price;
    }

    /**
     *Method <b> getdescription()</b> is an accessor in class <i>Product</i>.
     * @return description of the product in String format
     */
    public String getdescription(){
        return this.description;
    }

    /**
     *Method <b> getIfOnStock()</b> is an accessor in class <i>Product</i>.
     * @return true/false value about availability of the product 
     */
    public boolean getIfOnStock(){
        return this.onStock;
    }
    
    /**
     *Method <b> getState()</b> is an accessor in class <i>Product</i>.
     * @return enum type State {LIQUID, FOOD, ITEM, ICE} 
     */
    public State getState(){
        return this.productState;
    }

    //Hermetization OOP principle - Mutators

    /**
     *Method <b> setName(String newName)</b> is an mutator in class <i>Product</i>. It changes name of the product.
     * @param newName it gets new product name in String format
     */

    public void setName(String newName){
        this.name = newName;
    }

    /**
     *Method <b> setPrice(double newPrice)</b> is an mutator in class <i>Product</i>. It changes price of the product.
     * @param newPrice new price of the product in double format
     */
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    /**
     *Method <b> setdescription(String newDesc)</b> is an mutator in class <i>Product</i>. It changes description of the product.
     * @param newDesc new description of the product in String format
     */
    public void setdescription(String newDesc){
        this.description = newDesc;
    }

    /**
     *Method <b> setIfOnStock(boolean IfOnStock</b> is an mutator in class <i>Product</i>. It changes onStock field in the product.
     * @param IfOnStock boolean type which tells us if its available
     */
    public void setIfOnStock(boolean IfOnStock){
        this.onStock = IfOnStock;
    }
    
    /**
     *Method <b> setName(String newName)</b> is an mutator in class <i>Product</i>. It changes name of the product.
     * @param newName it gets new product name in String format
     */

    public void setState(){
        Scanner myObj = new Scanner(System.in);  
        System.out.print("Select state of your product:\n 1 - Liquid \n 2 - Food \n 3 - Item \n 4 - ICE \n");
        String operation = myObj.nextLine();    
        switch(operation){
        case "1":
            this.productState = State.LIQUID;
            break;
        case "2":
            this.productState = State.FOOD;
            break;
        case "3":
            this.productState = State.ITEM;
            break;
        case "4":
            this.productState = State.ICE;
            break;
        default:
            this.productState = State.ITEM;
            break;
        }
    }
    
    
    /**
     *Method <b>printProduct()</b> ia a function, which prints into console all
     * crucial information about product with proper comments. We get
     * information about product name, price, description and its availability.
     */
    public void printProduct(){    
        System.out.print("Information about Product: \n");
        System.out.print("Name: " + this.getName() + " Price: " + this.getPrice() + "\n" );
        System.out.print("Description: " + this.getdescription() + "\n" );
        System.out.print("Is it on stock: " + this.getIfOnStock() + "\n\n" );
    }
}
