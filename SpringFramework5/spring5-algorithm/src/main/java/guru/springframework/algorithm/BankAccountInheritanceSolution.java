package guru.springframework.algorithm;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class BankAccountInheritanceSolution {

	private static final String TEXT =  "I am a {0} account with {1,number,#} units of {2} currency";

    public static void main(String args[] ) throws Exception {

        List<BankAccount> accounts = new ArrayList<BankAccount>();
        accounts.add(new SavingsAccount("USD",3));//Savings
        accounts.add(new SavingsAccount("EUR",2));//Savings
        accounts.add(new CheckingAccount("HUF",100));//Checking
        accounts.add(new CheckingAccount("COP",10000));//Checking
        accounts.add(new BrokerageAccount("GBP",2));//Brokerage
        accounts.add(new BrokerageAccount("INR",600));//Brokerage
        
        accounts.stream().forEach(
                                    account -> System.out.println(
                                        MessageFormat.format(TEXT,
                                            new Object[]{
                                            account.getAccountType().getName(),//make this work
                                            account.getUnits(),//make this work
                                            account.getCurrency()//make this work
                                                           })));
    }
    
    static abstract class BankAccount {
    	String currency;
    	int units;
    	AccountType accountType;

		public BankAccount(String currency, int units, AccountType accountType) {
			this.currency = currency;
			this.units = units;
			this.accountType = accountType;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public int getUnits() {
			return units;
		}

		public void setUnits(int units) {
			this.units = units;
		}

		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
    }
    
    enum AccountType {
    	SAVING("Savings"), CHECKING("Checking"), BROKERAGE("Brokerage");
    	final String value;
    	
    	private AccountType(String value) {
    		this.value = value;
    	}
    	
    	String getName() {
    		return this.value;
    	}
    }
    
    static class SavingsAccount extends BankAccount {
		public SavingsAccount(String currency, int units) {
			super(currency, units, AccountType.SAVING);
		}
    }

    static class CheckingAccount extends BankAccount {
		public CheckingAccount(String currency, int units) {
			super(currency, units, AccountType.CHECKING);
		}
    }    
    
    static class BrokerageAccount extends BankAccount {

		public BrokerageAccount(String currency, int units) {
			super(currency, units, AccountType.BROKERAGE);
		}
    }     
    
}
