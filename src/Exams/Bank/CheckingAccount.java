package Exams.Bank;

//支票账户
public class CheckingAccount extends Account {

    private double overdraftProtection;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    public void withdraw(double amt) throws OverdraftException {

        if (amt > this.balance + this.overdraftProtection) {
            throw new OverdraftException("透资额度超标！", amt - this.balance - this.overdraftProtection);
        } else if (this.balance < amt) {
            this.overdraftProtection -= amt - this.balance;
            balance = 0;
        } else {
            this.balance -= amt;
        }
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }


}
