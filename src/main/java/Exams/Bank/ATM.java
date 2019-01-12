package Exams.Bank;


public class ATM {

    public static void main(String[] args) {

        Account account = new Account(100.0);
        try {
            account.withdraw(101);
            System.out.println(account.getBalance());
        } catch (OverdraftException e) {
            System.out.println("透资金额：" + e.getDeficit());
            e.printStackTrace();
        }


        CheckingAccount ca = new CheckingAccount(100, 100);
        try {
            ca.withdraw(50);
            System.out.println(ca.getBalance() + " " + ca.getOverdraftProtection());
            ca.withdraw(80);
            System.out.println(ca.getBalance() + " " + ca.getOverdraftProtection());
            ca.withdraw(100);
            System.out.println(ca.getBalance() + " " + ca.getOverdraftProtection());
        } catch (OverdraftException e) {
            System.out.println("透资金额：" + e.getDeficit());
            e.printStackTrace();
        }
    }
}
