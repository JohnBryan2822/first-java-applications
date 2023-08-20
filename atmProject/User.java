package atmProject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;

    /**
     * Create a new user
     * @param firstName
     * @param lastName
     * @param pin
     * @param theBank
     */
    public User(String firstName, String lastName, String pin, Bank theBank) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Store the pin's MD5 hash, rather than the original value,
        // for the security reason
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error occured: NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        // get a new, Unique universal ID for User
        this.uuid = theBank.getNewUserUUID();

        // Create an empty list of accounts
        this.accounts = new ArrayList<Account>();

        // print log message
        System.out.printf("New user %s, %s, with ID %s created.\n", lastName, firstName, this.uuid);
    }

    /**
     * Add an Account
     * @param acct   the account to add
     */
    public void addAccount(Account acct) {
        this.accounts.add(acct);
    }

    /**
     * Return user's UUID
     * @return the uuid
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Check whether the given pin matches the true User's pin
     * @param apin   the pin to check
     * @return       whether the pin is valid or not
     */
    public boolean validatePin(String apin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(apin.getBytes()),
                    this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error occured: NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    /**
     * Return the user's first name
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Print summary for account
     */
    public void printAccountsSummary() {
        System.out.printf("\n\n%s's account summary\n", this.firstName);
        for(int i=0; i<this.accounts.size(); i++) {
            System.out.printf("  %d) %s\n",i+1,
                    this.accounts.get(i).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * Get the number of accounts of the user
     * @return
     */
    public int numAccounts() {
        return this.accounts.size();
    }

    /**
     * print Transactions history for a particular account
     * @param acctIdx
     */
    public void printAcctTransHistory(int acctIdx) {
        this.accounts.get(acctIdx).printTransHistory();
    }

    /**
     * get the balance of a particular account
     * @param acctIdx
     * @return
     */
    public double getAcctBalance(int acctIdx) {
        return this.accounts.get(acctIdx).getBalance();
    }

    /**
     * get the UUID of a particular account
     * @param acctIdx   the index of the account to use
     * @return   	    the UUID of the account
     */
    public String getAcctUUID(int acctIdx) {
        return this.accounts.get(acctIdx).getUUID();
    }

    /**
     * Add Transaction to the particular amount
     * @param acctidx   the index of the account
     * @param amount	the amount of the transaction
     * @param memo		the memo of the transaction
     */
    public void addAcctTransaction(int acctidx, double amount, String memo) {
        this.accounts.get(acctidx).addTransaction(amount, memo);
    }
}
