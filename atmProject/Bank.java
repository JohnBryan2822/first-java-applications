package atmProject;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    /**
     * Create a new Bank object with empty lists of users and accounts
     * @param name  the name of the Bank
     */
    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Generate a new universally unique ID for user
     * @return
     */
    public String getNewUserUUID() {
        // inits
        String uuid;
        Random rand = new Random();
        int len = 6;
        boolean nonUnique;

        // Continue looping until we get unique ID
        do {
            uuid = "";

            // generate the number
            for(int i=0;i<len;i++) {
                uuid += ((Integer)rand.nextInt(10)).toString();
            }

            // check to make sure it is unique
            nonUnique = false;
            for(User u : this.users) {
                if(uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return uuid;
    }

    /**
     * Generate a new universally unique ID for an account
     * @return
     */
    public String getNewAccountUUID() {
        // inits
        String uuid;
        Random rand = new Random();
        int len = 10;
        boolean nonUnique;

        // Continue looping until we get unique ID
        do {
            uuid = "";

            // generate the number
            for(int i=0;i<len;i++) {
                uuid += ((Integer)rand.nextInt(10)).toString();
            }

            // check to make sure it is unique
            nonUnique = false;
            for(Account a : this.accounts) {
                if(uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return uuid;
    }

    /**
     * Add an account
     * @param acct
     */
    public void addAccount(Account acct) {
        this.accounts.add(acct);
    }

    /**
     * Create a new user of the bank
     * @param firstName
     * @param lastName
     * @param pin
     * @return
     */
    public User addUser(String firstName, String lastName, String pin) {

        // Create a new user object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // Create savings Account for the User and add to User and Bank
        // accounts list
        Account newAccount = new Account(firstName, newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);
        return newUser;
    }

    /**
     * Get the user's object associated with a partecular userID and pin
     * if they are valid
     * @param userID
     * @param pin
     * @return
     */
    public User userLogin(String userID, String pin) {

        // Search through list of users
        for(User u : this.users){

            // Check userID is correct
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
                return u;
            }
        }
        //if we haven't found the user or have incorrent pin
        return null;
    }

    /**
     * to get the name of the  bank
     * @return
     */
    public String getName() {
        return this.name;
    }
}
