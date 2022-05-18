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

    public void logIn(String username, Integer password){
        //to do
        //un --> sreach(un. username)
            //FOUND -> index
        //pass -> check pass by index
        //get email
        //logged
        //object account (empty) chua
            //value un, ps, email
        //GET LAST ALL ACCOUNTS FROM DATABASE
        JsonArray tempMemory = accounts.getAll();
        int index = -1;
        accounts.search("un", username);
        if(this.username.equals(username)){
            System.out.println("[ALREADY LOGGED IN] You Have Already Logged In.");

        }else if(this.username != null && this.username.equals(username)){
            System.out.println("[INVALID MULTIPLE LOGGINS] You need to logout frist to try another login.");

        }else if(index != -1){//accountObject => un , ps,email
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            Integer passwordAcc = jsonObject.get("ps").getAsInt();
            if(passwordAcc == password){
                String email = jsonObject.get("email").getAsString();
                //update value date to account
                setAccount(username, password, email);
            }
        }

        //1. already logined
            //logedIn = true 
        //2. dang nhap nhieu tai khoan => username nhap vao != objcAccount.username 
        //3. chua dang ky 
        //4. dang nhap binh thuong

    }

    private void setAccount(String username, Integer password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = true;
    }

    public void logOut(){
        this.loggedIn = false;
        this.username = null;
        this.password = null;
        this.email = email;


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

