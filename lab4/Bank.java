/**
 *
 * @author Oliver Mo
 * Student id: 500844905
 */
package coe318.lab4;

public class Bank {
    private String name;
    /**
     * An array of Accounts managed by
     * this bank.
     */
    private Account [] accounts;
    private int numAccounts;//number of active accounts

    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        this.accounts = new Account[maxNumberAccounts];
        this.numAccounts = 0;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;  //Fix this
    }
    /**
     * @return the numAccounts
     */
    public int getNumAccounts() {
        return numAccounts; //Fix this
    }
    public Account[] getAccounts() {
        return accounts; //Fix this
    }
    /**
     * Return true if the Bank already has an account
     * with this number; otherwise false.
     * @param accountNumber
     * @return
     */
    public boolean hasAccountNumber(int accountNumber) {
        for (int i =0; i<this.numAccounts;i++)//Runs loop based on the number of accounts present. Note, if you use the max number of accounts allowed, may run into NullExceptionError
        {  
            System.out.println("hi");
                if(this.accounts[i].getNumber() == accountNumber) {
                    System.out.println("no");
                    return true;
                }    
        }
        return false;
    }
    /**
     * Adds the specified account to the Bank if possible. If the account number
     * already exists or the Bank has reached its maximum
     * number of accounts, return false and do not add it; otherwise,
     * add it and return true.
     * @param account
     * @return true if successful
     */
    public boolean add(Account account) {
        if(numAccounts != accounts.length)//Checks if there is already max number of accounts
        {           
            for (int i = 0; i<numAccounts;i++) {
                    if(hasAccountNumber(account.getNumber()))//Calls hasAccountNumber Method to check if the account exist
                    {
                        return false;
                    }
                }
            }
        accounts[numAccounts] = account;
        numAccounts++;
        return true;
    }
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        String s = getName() + ": " + getNumAccounts() +
                " of " + getAccounts().length +
                " accounts open";
        for(Account account : getAccounts()) {
            if (account == null) break;
            s += "\n  " + account;
        }
        return s;
    }
}
