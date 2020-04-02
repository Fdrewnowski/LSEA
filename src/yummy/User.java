/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yummy;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
/**
 *Class <i> User</i>, extends class <i>Account</i>. It is specific account for 
 * typical user who only can order products.
 * Class <i>User</i> following fields:
 *  String nickname, is users unique nickname
 *  int age, is the age of the user calculated from its birth date
 *  String dateOfBirth, is the user birth date 
 *  Yummy yummyApp, is a refference to the system
 * @author fdrew
 */
public final class User extends Account implements Comparable<User> {

    protected String nickname;      //users nickname  
    private int age;                //age of user crucial if user want to buy items 
    private String dateOfBirth;     //not dedicated for his/her age
    private final Yummy yummyApp;


    /**
     *<b>Constructor</b> for class <i>User</i>, gives null values for all fields. 
     * Made mostly for testing, example of overloading.
     */
    public User(){
        super(null, null, null, null, null);
        this.age = 0;
        this.dateOfBirth = null;
        this.nickname = null;
        this.yummyApp = null;
    } 
    
    /**
    *<b>Constructor</b> for class <i>User</i>, it needs following parameters 
     * seven string parameters describing object and reference for yummy class. Variables name, surname, email, password and localization
     * are given to super constructor in class <i>Account</i>.     
     * @param nickname is a unique user nickname in String format
     * @param name is a user firstname in String format
     * @param surname is a user surname in String format
     * @param email is a user email in String format
     * @param password is a user password in String format
     * @param localization is a user current localization in String format
     * @param dateOfBirth is a user date of birth in String format
     * @param yummyApp is a refference for yummy class
     */
    
    public User(String nickname,String name, String surname, String email, String password,String localization, String dateOfBirth, Yummy yummyApp){
        super(name, surname, email, password, localization);
        this.setAgeAndBirthDate(dateOfBirth);
        this.setNickname(nickname);
        this.yummyApp = yummyApp;
    } 
    
    //Hermetization OOP principle - Accessors 

    /**
     *Method <b> getAge()</b> is an accessor in class <i>User</i>.
     * @return age of the user in int format
     */
    
    public int getAge(){
        return age;
    }
    
    /**
     *Method <b> getDateOfBirth()</b> is an accessor in class <i>User</i>.
     * @return users birth date in string format
     */
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    
    /**
     *Method <b> getNickname()</b> is an accessor in class <i>User</i>.
     * @return users unique Nickname in String format
     */
    public String getNickname(){
        return nickname;
    }
    
    /**
     *Method <b> getYummyApp()</b> is an accessor in class <i>User</i>.
     * @return refference to class <i>Yummy</i> 
     */
    public Yummy getYummyApp(){
        return yummyApp;
    }
    
    //Hermetization OOP principle - Mutators

    /**
     *Method <b> setAgeAndBirthDate(String birth)</b> is an mutator in class <i>Product</i>. It sets birth date and count users age.
     * @param birth birth date in String format
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
     *Method <b> setNickname(String newNickname)</b> is an mutator in class <i>Product</i>. It sets user new nickname.
     * @param newNickname new nickname in String format
     */
    public void setNickname(String newNickname){
        this.nickname = newNickname;
    }
    
    /**
     *Method <b>printProfile()</b> ia a function, which prints into console all
     * crucial information about user profile with proper comments. We get
     * information about nickname, name , surname, birthday, age and localization.
     */
    @Override
    public void printProfile(){ 
        System.out.print("Information about user account: \n");
        System.out.print("Nickname: " + this.getNickname() + "\n");
        System.out.print("Name: " + super.getName() + " Surname: " + super.getSurname() + "\n" );
        System.out.print("Birth date: " + this.getDateOfBirth() + " Age: " + this.getAge() + "\n" );
        System.out.print("Localization: " + super.getLocalization() + "\n \n");
    }    
    

    /**
     * 
     * @param u2
     * @return 
     */
    @Override
    public int compareTo(User u2) {
        String userName1 = this.getNickname();
	String userName2 = u2.getNickname();
	//ascending order
	return userName1.compareTo(userName2);
    }

    /**
     *Method <b>main()</b> for testing: creating user, checking if profile was created succesfully and
     * printing list of orders
     * @param args optional parameters, not used
     */
    public static void main(String[] args) {
        User me = new User("Drewno", "Filip","Drewnowski","f@wp.pl","123","Kielpino gorne","17-02-1998", null);
        me.printProfile();
        me.printHistoryOrders();
    }


}
