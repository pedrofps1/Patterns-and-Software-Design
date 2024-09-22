public class AccountProxy implements BankAccount{
    private BankAccount account;

    AccountProxy(BankAccount account){
        this.account = account;
    }

    public void deposit(double amount){
        account.deposit(amount);
    }

    public boolean withdraw(double amount){
        if(Company.user.equals(User.OWNER)){
            return account.withdraw(amount);
        }
        else{
            System.out.println("Nao autorizado");
            return false;
        }
    }

    public double balance(){
        if(Company.user.equals(User.OWNER)){
            return account.balance();
        }
        else{
            System.out.println("Nao autorizado");
            return 0;
        }
    }

}
