package Buoi7;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Account {
    private static StoredFiles accounts = new StoredFiles
    ("accounts.json");

    private String username;
    private Integer password;
    private String email;
    private boolean loggedIn;

    /**
     * 
     */
    public Account() {
        this.username = null;
        this.password = null;
        this.email = null;
        this.loggedIn = false;
    }

    /**
     * @param username
     * @param password
     * @param email
     */

    public Account(String username, Integer password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = false;
    }

    public void logIn(){

    }

    public void logOut(){

    }

    public boolean checkLoggedIn(){
        return this.loggedIn;
    }

    public static void createAccount(String username, Integer password, String email){

        //username/email check;
        //...
        List<Object> list =  accountValid(username, email);
        if(!(boolean)list.get(0)){//false
            System.out.println(list.get(1));
        }else{
            //theem c
            //sdl => StoredFiles
            //un: mssen
            //ps: 123
            //mail:mssen@gmail.com
            accounts.update(username, password, email);
            accounts.write();
        }

    }

    public static List<Object> accountValid(String username, String email){
        List<Object> list = new ArrayList<>();
       
        int index = 0;
        index = accounts.search("un", username);
        if(index != -1){
            list.add(false);
            list.add("[USERNAME EXISTS] An user with that username already exists.");
            return list;
        }
        //check email
        index = accounts.search("email", email);
        if(index != -1){
            list.add(false);
            list.add("[EMAIL EXISTS] An email with that mail already exists.");
            return list;
        }

        if(index == -1){
            list.add(true);
            list.add("[ACCOUNT CREATED] An account has been created.");
        }

        return list;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public Integer getPassword() {
        return password;
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

}

