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
     *<b>Constructor</b> for class <i>Company</i>, it needs following parameters 
     * six string parameters describing object. Beyond setting appropriate paramiters, it also create ArrayList which
     * can store class <i>Product</i>. Variables name, surname, email, password and localization
     * are given to super constructor in class <i>Account</i>.
     * @param companyName is a name of company for which account was made
     * @param name is account owner firstname
     * @param surname is account owner surname
     * @param email is account owner email
     * @param password is account owner password 
     * @param localization is account owner current localization
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
     *Method <b> getCompanyName()</b> is an accessor in class <i>Company</i>.
     * @return name of the company in String format
     */

    public String getCompanyName(){
        return this.companyName;
    }
    
    /**
     *Method <b> getRate()</b> is an accessor in class <i>Company</i>.
     * @return rate of the company in double format
     */
    public double getRate(){
        return this.rate;
    }
    
    /**
     *Method <b> getAssortment()</b> is an accessor in class <i>Company</i>, it
     * returns list of assortment.
     * @return list of objects type class <i>Product</i>
     */
    public List<Product> getAssortment(){
        return this.assortment;
    }

    //Hermetization OOP principle - Mutators

    /**
     *Method <b> setCompanyName(String newCompanyName)</b> is a mutator that changes
     * name of the company in class <i>Company</i>.
     * @param newCompanyName new name of the company in String format
     */

    public void setCompanyName(String newCompanyName){
        this.companyName = newCompanyName;
    }

    /**
     *Method <b> setRate(double newRate)</b> is a mutator that changes
     * rate which is assigned to company, for example after actualization, in class <i>Company</i>.
     * @param newRate new rate number in double format
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
