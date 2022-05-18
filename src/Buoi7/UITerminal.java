package Buoi7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UITerminal {
    private static Scanner scanner = new Scanner(System.in);
    private Account account;
    private String prompt;//thong bao hop thoai
    private String command;
    /**
     * @param account
     */
    public UITerminal(Account account) {
        this.account = account;
    }




    public void displayOptions(){

        System.out.println("~~~~~~~~~~~~~MENU~~~~~~~~~~~");

        //check
        if(!account.checkLoggedIn()){
            this.prompt = "Enter one of the commands in the brackets [] \n" +
            "[CA] Create account\n" +
            "[LI] Login";
        }else{
            this.prompt = "LOGGED IN AS # " + account.getUsername() + 
            "\n Enter on of the commands in brackets:\n" +
            "[LO] Logout";
        }

    }

    /**
     * @return the prompt
     */
    public String getPrompt() {
        return prompt;
    }

    public String handleCommands(String rep){
        String cmd = rep.toUpperCase();
        this.command = cmd;

        if(this.command.equals("CA")){
            return "Enter an username, a password, a email";
        }else if(this.command.equals("LI")){
            return "Enter a username, a password";
        }else if(this.command.equals("LO")){
            return "Logging out...";
        }else{
            return "unknown command.";
        }

    }

    public void handleInputs(){

        if(this.command.equals("CA")){
            Account account =  createAccountInputs();

            Account.createAccount(account.getUsername(), account.getPassword(), account.getEmail());
        }else if(this.command.equals("LI")){
            List<Object> list = loginInputs();// Implementation
            //accObject.login(list.get(0).toString(), ((int)list.get(1)));
        }

    }

    private List<Object>  loginInputs(){
        List<Object> list = new ArrayList<>();
        System.out.println("USERNAME: ");
        String username = scanner.nextLine();
        System.out.println("PASSSWORD: ");
        Integer password = scanner.nextInt();
        list.add(username);
        list.add(password);
        return list;
    }

    private static Account createAccountInputs(){
        System.out.print("USERNAME: ");
        String username = scanner.nextLine();
        System.out.print("PASSWORD: ");
        Integer password = scanner.nextInt();
        scanner.nextLine();
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        return new Account(username, password, email);
    }

}
