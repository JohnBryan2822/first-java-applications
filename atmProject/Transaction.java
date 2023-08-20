package atmProject;

import java.util.Date;

public class Transaction {
    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    /**
     * Create a new Transaction
     * @param amount
     * @param inAccount
     */
    public Transaction(double amount, Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date(0, 0, 0);
        this.memo = memo;
    }

    /**
     //	 * Create a new Transaction
     * @param amount
     * @param memo
     * @param inAccount
     */
    public Transaction(double amount, String memo, Account inAccount) {
        // Call two-arg cunstructor first
        this(amount, inAccount);
        this.memo = memo;
    }

    /**
     * get amount of transactions
     * @return
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Get s String summarizing the transaction
     * @return
     */
    public String getSummaryLine() {
        if(this.amount >= 0) {
            return String.format("%s : $%.02f : %s", this.timestamp.toString(),
                    this.amount, this.memo);
        }
        else{
            return String.format("%s : $(%.02f) : %s", this.timestamp.toString(),
                    -this.amount, this.memo);
        }
    }
}
