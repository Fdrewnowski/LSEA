/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author fdrew
 */
public final class User extends Account {
    
    /**
     *
     */
    protected String nickname;      //users nickname  
    private int age;                //age of user crucial if user want to buy items 
    private String dateOfBirth;     //not dedicated for his/her age
    private final Yummy yummyApp;
    //Constructor for testing if object creates properly
    // example of overloading

    /**
     *
     */
    public User(){
        super(null, null, null, null, null);
        this.age = 0;
        this.dateOfBirth = null;
        this.nickname = null;
        this.yummyApp = null;
    } 
    
    //Constructor assinging values after creating user account

    /**
     *
     * @param nickname
     * @param name
     * @param surname
     * @param email
     * @param password
     * @param localization
     * @param dateOfBirth
     * @param yummyApp
     */
    
    public User(String nickname,String name, String surname, String email, String password,String localization, String dateOfBirth, Yummy yummyApp){
        super(name, surname, email, password, localization);
        this.setAgeAndBirthDate(dateOfBirth);
        this.setNickname(nickname);
        this.yummyApp = yummyApp;
    } 
    
    //Hermetization OOP principle - Accessors 

    /**
     *
     * @return
     */
    
    public int getAge(){
        return age;
    }
    
    /**
     *
     * @return
     */
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    
    /**
     *
     * @return
     */
    public String getNickname(){
        return nickname;
    }
    
    /**
     *
     * @return
     */
    public Yummy getYummyApp(){
        return yummyApp;
    }
    
    //Hermetization OOP principle - Mutators

    /**
     *
     * @param birth
     */

    public void setAgeAndBirthDate(String birth){
        //initializing local variable needed to transform date and count age
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        Date birthDate;
        String transformedDate;
        //sample using "try-catch" mechanizm during date transformation
        try{
            //transformating date and string types
            birthDate = dateFormat.parse(birth);
            transformedDate = dateFormat.format(currentDate);
            currentDate = dateFormat.parse(transformedDate);
            
            //counting how many days someone is old and then divided by 365
            long diff = currentDate.getTime() - birthDate.getTime();
            int days  = (int)(diff / (1000 * 60 * 60 * 24));
            
            //assigning values to age and date of birth
            this.age = (days / 365);
            this.dateOfBirth = birth;
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     *
     * @param newNickname
     */
    public void setNickname(String newNickname){
        this.nickname = newNickname;
    }
    
    /**
     *
     */
    @Override
    public void printProfile(){ //Prints information about user
        System.out.print("Information about user account: \n");
        System.out.print("Nickname: " + this.getNickname() + "\n");
        System.out.print("Name: " + super.getName() + " Surname: " + super.getSurname() + "\n" );
        System.out.print("Birth date: " + this.getDateOfBirth() + " Age: " + this.getAge() + "\n" );
        System.out.print("Localization: " + super.getLocalization() + "\n \n");
    }    
    
    //main for testing 
    //creating user
    //print profile 
    //look for past orders (no orders)

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        User me = new User("Drewno", "Filip","Drewnowski","f@wp.pl","123","Kielpino gorne","17-02-1998", null);
        me.printProfile();
        me.printHistoryOrders();
    }
}
