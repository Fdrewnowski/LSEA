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
public final class Company extends Account{
    private String companyName;             //company name
    private final List<Product> assortment; //list of products that are sold by comp.
    private double rate; //this option is yet not developed
   
    //Constructor assinging values after creating company account

    /**
     *
     * @param companyName
     * @param name
     * @param surname
     * @param email
     * @param password
     * @param localization
     */

    public Company(String companyName,String name, String surname, String email, String password, String localization) {
        super(name, surname, email, password, localization);
        this.setCompanyName(companyName);
        this.assortment = new ArrayList<Product>();
        this.rate = 0; // yet not available
        
        //making some basic product for test
        Product firstProduct = new Product("Pasta",12.50,"Healthy product", true);
        this.saveAssortment(firstProduct);
    }
    
    //Hermetization OOP principle - Accessors 

    /**
     *
     * @return
     */

    public String getCompanyName(){
        return this.companyName;
    }
    
    /**
     *
     * @return
     */
    public double getRate(){
        return this.rate;
    }
    
    /**
     *
     * @return
     */
    public List<Product> getAssortment(){
        return this.assortment;
    }

    //Hermetization OOP principle - Mutators

    /**
     *
     * @param newCompanyName
     */

    public void setCompanyName(String newCompanyName){
        this.companyName = newCompanyName;
    }

    /**
     *
     * @param newRate
     */
    public void setRate(double newRate){
        this.rate = newRate;
    }
    
    /**
     *
     */
    @Override
    public void printProfile(){ //Prints information about company
        System.out.print("Information about Company: \n");
        System.out.print("Company name: " + this.getCompanyName() + "\n");
        System.out.print("Owner name: " + super.getName() + " Owner surname: " + super.getSurname() + "\n" );
        System.out.print("Localization: " + super.getLocalization() + "\n");
        System.out.print("Rate: " + this.getRate() + "\n \n");
    }
    
    //Methods which helps dealing with list of assortment

    /**
     *
     * @param newAssortment
     */
    public void saveAssortment(Product newAssortment){
        this.assortment.add(newAssortment);
    }

    /**
     *
     * @param assortmentToRemove
     */
    public void removeAssortment(Product assortmentToRemove){
        this.assortment.remove(assortmentToRemove);
    }
    
    /**
     *
     */
    public void addAssortment(){    //method through which new product can be added
        String name, desc;          //to assortment of company
        boolean onStock;
        double price;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        
        System.out.print("Insert: name(String format),\n price(double format),\n short description(String format),\n is it available(true/false)" + "\n");

        name = myObj.nextLine();                              // 
        price = Double.parseDouble(myObj.nextLine());        // 
        desc = myObj.nextLine();                            // Read user input
        onStock = Boolean.parseBoolean(myObj.nextLine());  // 
 
        Product newAssortment = new Product(name,price, desc, onStock);
        this.saveAssortment(newAssortment);
        //newAssortment.printProduct();         checking what was inserted
    }
    
    /**
     *
     * @param name
     * @return
     */
    public Product chooseAssortment(String name){ //go through list and search 
        for(Product p : this.getAssortment()){    // for named product
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    
    /**
     *
     */
    public void printAssortment(){      //prints all products in an offer
        for(Product p : this.getAssortment()){
            p.printProduct();  
        }
    }
    
    /**
     *
     * @param orderingUser
     * @return
     */
    public Order createOrder(User orderingUser){     //using this method user can order
        Order newOrder = new Order();           //his/her shopping
        Product pro;
        String name = " ";
        
        this.printAssortment();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        while(!(name.equals("ok"))){
            System.out.print("From list above please write name of product u want to order: " + "\n");
            name = myObj.nextLine(); // Read user input
            
            pro = this.chooseAssortment(name);  //looking for proper assortment
            if(pro != null){
                if(pro.getIfOnStock()==true){        //if product is out of stock
                    newOrder.saveOrderedItem(pro);  //it is impossible to order
                }
                else{
                System.out.print("Sorry product "+pro.getName()+  " is out of stock!\n");
                }
            }
            System.out.print("If its all write 'ok'" + "\n");
        }
        
        System.out.print("\n");
        newOrder.setCompanyFrom(this.getCompanyName());     //filling in order
        String nick = orderingUser.getNickname();
        newOrder.setWhoOrdered(nick);
        newOrder.setTotalPrice();                           //counting total price
        
        orderingUser.saveOrder(newOrder);       //saveing on user account this order
        return newOrder;
    }
    
    
    //main for testing 
    //creating company
    //adding first assortment from command line 
    //checking if it inserted and what was created

    /**
     *
     * @param args
     */
    
     public static void main(String[] args) {
        Company comp = new Company("Nice shop","Roman","Nice","nice@ro.tu","1234","Wrzeszcz");
        System.out.print("Size of assortment: " + comp.assortment.size() + "\n\n");
        comp.addAssortment();
        System.out.print("Size of assortment: " +comp.assortment.size() + "\n\n");
        comp.printAssortment();
        
    }
}
