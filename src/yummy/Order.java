/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

import java.util.ArrayList;
import java.util.List;

/**
 *Class <i>Order</i> is made to allow users making orders. Object <i>Order</i>
 * contains information about company and user which were making deal, list of
 * ordered products and total price for this products.
 * Class <i>Order</i> following fields:
 * double totalPrice total price of all products
 * List of Product allOrderedItems list of all products on invoice
 * String companyFrom company from which order was made
 * String whoOrdered user nickname who made order
 * @author fdrew
 */
public final class Order {
    
    private double totalPrice;                      //total price from order 
    private final List<Product> allOrderedItems;    //list of all selected products
    private String companyFrom;                     //company in which user buys
    private String whoOrdered;                      //nickname of user
    
    /**
     *<b>Constructor</b> for class <i>Order</i>, gives null values for all fields. 
     * Made mostly for testing, example of overloading.
     */
    public Order(){
        this.totalPrice=0;
        this.allOrderedItems = new ArrayList<Product>();
        this.companyFrom = null;
        this.whoOrdered = null;
    }
    
    /**
     *<b>Constructor</b> for class <i>Order</i>, it needs following parameters 
     * two string parameters describing object(company from, who ordered) and ArrayList of Products.
     * @param companyFrom is name of company in which order was made 
     * @param whoOrdered is nickname of user who made order
     * @param listOfProducts is list of all products in order
     */

    public Order(String companyFrom, String whoOrdered, List<Product> listOfProducts){
        this.setCompanyFrom(companyFrom);
        this.setWhoOrdered(whoOrdered);
        this.allOrderedItems = listOfProducts;
        this.setTotalPrice();

    }

    //Hermetization OOP principle - Accessors 

    /**
     *Method <b> getTotalPrice()</b> is an accessor in class <i>Order</i>.
     * @return total price for an order in double format
     */
 
    public double getTotalPrice(){
        return this.totalPrice;
    }
    
    /**
     *Method <b> getAllOrderedItems()</b> is an accessor in class <i>Order</i>.
     * @return field allOrderedItems which is List of all products on order
     */
    public List<Product> getAllOrderedItems(){
        return this.allOrderedItems;
    }
    
    /**
     *Method <b> getCompanyFrom()</b> is an accessor in class <i>Order</i>.
     * @return name of the company from which specific user is ordering
     */
    public String getCompanyFrom(){
        return this.companyFrom;
    }   
    
    /**
     *Method <b> getWhoOrdered()</b> is an accessor in class <i>Order</i>.
     * @return field whoOrdered, so nickname of user who made order 
     */
    public String getWhoOrdered(){
        return this.whoOrdered;
    }
    
    //Hermetization OOP principle - Mutators

    /**
     *Method <b> setTotalPrice()</b> is an mutator in class <i>Order</i>. It goes
     * through list of product and sum their price to get total price.
     */

    public void setTotalPrice(){    //goes through all list and sum their price
        double sum = 0;
        for(Product p : this.getAllOrderedItems()){
            sum += p.getPrice();
        }
        this.totalPrice = sum;
    }
    
    /**
     *Method <b>setCompanyFrom(String companyFrom)</b> is a mutator which set 
     * name of the company from which Order was made.
     * @param companyFrom name of the company in String format.
     */
    public void setCompanyFrom(String companyFrom){
        this.companyFrom = companyFrom;
    }   
    
    /**
     *Method <b>setWhoOrdered(String whoOrdered)</b> is a mutator which set 
     * name of the user who ordered.
     * @param whoOrdered nickname of the user who order in String format
     */
    public void setWhoOrdered(String whoOrdered){
        this.whoOrdered = whoOrdered;
    }
    
    //Methods which help dealing with list add and remove element

    /**
     *Method <b> saveOrderedItem(Product newAssortment)</b> is a function which save new object
     * <i>Product</i> to existing list on field allOrderedItems in class <i>Order</i>.
     * @param newAssortment element which will be added to the list, type <i>Product</i>
     */
    
    public void saveOrderedItem(Product newAssortment){
        this.allOrderedItems.add(newAssortment);
    }

    /**
     *Method <b> removeOrderedItem(Product assortmentToRemove)</b> is a function which remove object
     * <i>Product</i> from existing list on field allOrderedItems in class <i>Order</i>.
     * @param assortmentToRemove element which will be removed from the list, type <i>Product</i>
     */
    public void removeOrderedItem(Product assortmentToRemove){
        this.allOrderedItems.remove(assortmentToRemove);
    }
    
    /**
     *Method <b>printOrder()</b> ia a function, which prints into console all
     * crucial information about order with proper comments. We get
     * information about who made order, company from which order was made, total price
     * and list of ordered products.
     */
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
