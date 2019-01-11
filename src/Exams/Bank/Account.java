package Exams.Bank;

public class Account {
    public double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double money) {
        this.balance += money;
    }

    public void withdraw(double money) throws OverdraftException {
        double resMoney = this.balance - money;
        if (money > this.balance) {
            throw new OverdraftException("余额不足！", money - this.balance);
        }
        this.balance -= money;
    }
}
