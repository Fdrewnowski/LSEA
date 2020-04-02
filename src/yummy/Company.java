/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *Class <i> Company</i>, extends class <i>Account</i>. It is speciffic account
 * for companies, which can provide their servieces by yummy app.
 * Class <i>Company</i> following fields:
 *  String companyName, is name of the company
 *  double rate, is rating of the company in the system
 *  List Product assortment, is list of all products offered by company
 * Beyond setting appropriate paramiters, it also create ArrayList which
 * can store class <i>Product</i>. 
 * @author fdrew
 */
public class Company extends Account{
    private String companyName;             //company name
    private final List<Product> assortment; //list of products that are sold by comp.
    private double rate; //this option is yet not developed
   
    //Constructor assinging values after creating company account

    /**
     *<b>Constructor</b> for class <i>Company</i>, it needs following parameters: 
     * six string parameters describing object and one double parameter for rate.
     * Beyond setting appropriate paramiters, it also create ArrayList which
     * can store class <i>Product</i>. Variables name, surname, email, password and localization
     * are given to super constructor in class <i>Account</i>.
     * @param companyName is a name of company for which account was made
     * @param name is account owner firstname
     * @param surname is account owner surname
     * @param email is account owner email
     * @param password is account owner password 
     * @param localization is account owner current localization
     * @param initRate is rate of the company
     */

    public Company(String companyName,String name, String surname, String email, String password, String localization, double initRate) {
        super(name, surname, email, password, localization);
        this.setCompanyName(companyName);
        this.assortment = new ArrayList<Product>();
        this.rate = initRate; // yet not available
        
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
     * rate, which is assigned to company, for example after actualization,
     * in class <i>Company</i>.
     * @param newRate new rate number in double format
     */
    public void setRate(double newRate){
        this.rate = newRate;
    }
    
    /**
     *Method <b>printProfile()</b> ia a function, which prints into console all
     * crucial information about company profile with proper comments. We get
     * information about company name, owners name and surname, localization 
     * of the company and rate.
     */
    @Override
    public void printProfile(){
        System.out.print("Information about Company: \n");
        System.out.print("Company name: " + this.getCompanyName() + "\n");
        System.out.print("Owner name: " + super.getName() + " Owner surname: " + super.getSurname() + "\n" );
        System.out.print("Localization: " + super.getLocalization() + "\n");
        System.out.print("Rate: " + this.getRate() + "\n \n");
    }
    
    //Methods which helps dealing with list of assortment

    /**
     *Method <b> saveAssortment(Product newAssortment)</b> is a function which save new object
     * <i>Product</i> to existing list on field assortment in class <i>Company</i>.
     * @param newAssortment element which will be added to the list, type <i>Product</i>
     */
    public void saveAssortment(Product newAssortment){
        this.assortment.add(newAssortment);
    }

    /**
     *Method <b> removeAssortment(Product assortmentToRemove)</b> is a function which remove object
     * <i>Product</i> from existing list on field assortment in class <i>Company</i>.
     * @param assortmentToRemove element which will be removed from the list, type <i>Product</i>
     */
    public void removeAssortment(Product assortmentToRemove){
        this.assortment.remove(assortmentToRemove);
    }
    
    /**
     *Method <b> addAssortment()</b> is a function which creates new object
     * <i>Product</i> from input provided by user(in terminal). After creating new object
     * it is saved into existing list on field assortment using method <b> saveAssortment(Product newAssortment)</b>,
     * in class <i>Company</i>.
     */
    public void addAssortment(){
        String name, desc;
        boolean onStock;
        double price;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        
        System.out.print("Insert: name(String format),\n price(double format),\n short description(String format),\n is it available(true/false)" + "\n");

        name = myObj.nextLine();                           //   
        price = Double.parseDouble(myObj.nextLine());      //  
        desc = myObj.nextLine();                           // Read user input
        onStock = Boolean.parseBoolean(myObj.nextLine());  // 
 
        Product newAssortment = new Product(name,price, desc, onStock);
        this.saveAssortment(newAssortment);
        //newAssortment.printProduct();         checking what was inserted
    }
    
    /**
     *Method <b> chooseAssortment(String name)</b> is a function which goes through
     * list of assortment and is searching for product with specific name. Name of 
     * <i>Product</i> is in String format. Function returns object <i>Product</i>, 
     * which name is the same as the parameter, if there isnt such object it returns
     * null value.
     * @param name it is a name of the product we are looking for
     * @return object <i>Product</i> which name equals param name or null value if 
     * there is no such object
     */
    public Product chooseAssortment(String name){  
        for(Product p : this.getAssortment()){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    
    /**
     *Method <b>printAssortment()</b> ia a function, which goes through assortment
     * list and triger method <b>printProduct()</b> for all products in the list.
     */
    public void printAssortment(){      //prints all products in an offer
        for(Product p : this.getAssortment()){
            p.printProduct();  
        }
    }
    
    /**
     *Method <b> createOrder(User orderingUser)</b> is a function which creates new object
     * <i>Order</i>. Firstly, it call method <b>printAssortment()</b> to show list of all
     * products in specific company, then user enters in terminal names of products, then if 
     * such <i>Product</i> exists it is added to <i>Order</i>. Writting "ok" in terminal ends process
     * of selecting products. After it, other crucial information are filled in like who ordered, from which 
     * company and total price for order. Then <i>Order</i> is saved in <i>User</i> history of orders.
     * Function returns created object <i>Order</i>.
     * @param orderingUser object <i>User</i> which is creating <i>Order</i>
     * @return object <i>Order</i> which was made during this function
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

    /**
     *Method <b>main()</b> for testing, creating company, checking if adding assortment
     * from terminal works and then chcecking if proper <i>Product</i> was made
     * @param args eventual params for main  
     */
    
     public static void main(String[] args) {
        Company comp = new Company("Nice shop","Roman","Nice","nice@ro.tu","1234","Wrzeszcz", 3.23);
        System.out.print("Size of assortment: " + comp.assortment.size() + "\n\n");
        comp.addAssortment();
        System.out.print("Size of assortment: " +comp.assortment.size() + "\n\n");
        comp.printAssortment();
        
    }
}
