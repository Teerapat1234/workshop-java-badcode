package badcode;

public class DemoBank {
    public static void main(String[] args) {
        // Local transfer
        TransferMoneyProcess bankAccount = new LocalBankAccount();
        bankAccount.transferMoney(1000);

        // Inter transfer
        TransferMoneyProcess interBankAccount = new InterBankAccount();
        interBankAccount.transferMoney(2000);
    }
}

enum AccountType {
    Local,
    Inter
}

interface TransferMoneyProcess {
    void transferMoney(int amount);
}

class LocalBankAccount implements  TransferMoneyProcess{
    public void transferMoney(int amount) {
        System.out.println("Transfer money in Thailand only");
        // TODO
    }
}

class InterBankAccount implements TransferMoneyProcess {
    public void transferMoney(int amount) {
        System.out.println("Transfer money (International)");
        // TODO
    }
}

class InterV2BankAccount implements TransferMoneyProcess {
    public void transferMoney(int amount) {
        System.out.println("Transfer money (International V2)");
        // TODO
    }
}

class XXXBankAccount implements TransferMoneyProcess {
    public void transferMoney(int amount) {
        System.out.println("Transfer money (XXX)");
        // TODO
    }
}