package atmProject;

import java.util.ArrayList;

public class Account {
    private String name;
    private double balance;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transactions;

    /**
     * Account Cunstructor
     * @param name
     * @param holder
     * @param theBank
     */
    public Account(String name, User holder, Bank theBank) {
        this.name = name;
        this.holder = holder;

        // get new Account UUID
        this.uuid = theBank.getNewAccountUUID();

        // init Transactions
        this.transactions = new ArrayList<Transaction>();
    }

    /**
     * Return account's UUID
     * @return the uuid
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * get summary line for account
     * @return
     */
    public String getSummaryLine() {

        //get account's balance
        double balance = this.getBalance();

        // format the summary line, depending on whether the balance is negative
        if(balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        }
        else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }

    /**
     * get balance
     * @return
     */
    public double getBalance() {
        double balance = 0;
        for(Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    /**
     * Print Transaction history of the account
     */
    public void printTransHistory() {
        System.out.printf("\nTransaction history for account %s\n", this.uuid);
        for(int i = this.transactions.size()-1;i>=0;i--) {
            System.out.println(this.transactions.get(i).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * add a new transaction to this account
     * @param amount	the amount transacted
     * @param memo		the transaction memo
     */
    public void addTransaction(double amount, String memo) {

        // create a new Transaction object and add it to our list
        Transaction newTrans = new Transaction(amount, memo, this);
        this.transactions.add(newTrans);
    }
}
