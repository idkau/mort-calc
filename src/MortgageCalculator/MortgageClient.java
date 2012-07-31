/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MortgageCalculator;


/**
 *
 * @author jason pearl
 */
public class MortgageClient {
    
    private String name;
    private double annualInterestRate;
    
    private int loanYears;
    private double loanAmount;
    private int startMonth;
    private int startYear;
    private double hoaFee;
    private double otherFee;
    
    private double monthlyInterestRate;
    private double monthlyPayment;
    private double totalPayment;
    private int monthsLeft;
    private double remainingBal;
    private double monthlyInterest;
    private double monthlyPrinciple;
    
     MortgageClient[] clientAccount;
    private int activeClientAccountCount;


    
    MortgageClient() {
        
        name = "";
        annualInterestRate = 0;
        loanYears = 0;
        loanAmount = 0;
        startMonth = 1;
        startYear = 2012;
        hoaFee = 0;
        otherFee = 0;
        monthlyInterestRate = 0;
        monthlyPayment = 0;
        totalPayment = 0;
        monthsLeft = 0;
        remainingBal = 0;
        monthlyInterest = 0;
        monthlyPrinciple = 0;
        clientAccount = new MortgageClient[10];
        activeClientAccountCount = 0;
    }
    
    MortgageClient(String clientName, double interestRate, int years, double loan, int month, int year, double hoa, double other) {
        
         name = clientName;
        annualInterestRate = interestRate;
        loanYears = years;
        loanAmount = loan;
        startMonth = month;
        startYear = year;
        hoaFee = hoa;
        otherFee = other;
        clientAccount = new MortgageClient[10];
        activeClientAccountCount = 0;
    }
    
    // Change input after initial var entry.
 
    public String getName() {
        
        return name;
    }
    
    public double getAnnualInterestRate() {
        
        return annualInterestRate;
    }
    
    public double getMonthlyInterestRate() {
        
        return monthlyInterestRate;
    }
    
    public double getMonthlyPrinciple() {
        
        return monthlyPrinciple;
    }
    
    public int getLoanYears() {
        
        return loanYears;
    }
    
    public double getLoanAmount() {
        
        return loanAmount;
    }
    
    public int getStartMonth() {
        
        return startMonth;
    }
    
    public int getStartYear() {
        
        return startYear;
    }
    
    public double getHoaFee() {
        
        return hoaFee;
    }
    
    public double getOtherFee() {
        
        return otherFee;
    }
    
    public int getActiveClientAccountCount() {
        
        return activeClientAccountCount;
    }
    
    public String calulateMortgage() {
        
        String output ="";
        
         monthlyInterestRate = annualInterestRate / 1200;
         
        monthlyPayment = (loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 +
				monthlyInterestRate, loanYears * 12))) + hoaFee + otherFee;
		totalPayment = (monthlyPayment * loanYears * 12) + (hoaFee * loanYears *12) + (otherFee  * loanYears *12);
		
		//format to keep 2 digits after the decimal
		monthlyPayment = (int)(monthlyPayment * 100) / 100.0;
		totalPayment = (int)(totalPayment * 100) / 100.0;
		
		// Create scheduler
		// Find out monthly principle
		
		
		monthsLeft = loanYears * 12;
		remainingBal = loanAmount;
		
		StringBuilder result = new StringBuilder()
		
                .append("\t\t\t\tMortgage Data Sheet\n")        
                .append("\nClient Name: " + name + "\n")
                .append("\nLoan Start Date: " + startMonth + "/" + startYear + "\n")
                .append("\nAnnual Interest Rate: " + annualInterestRate + "\n");
                        if (hoaFee > 0) {
                         result.append("HOA Monthly Fee: " + hoaFee + "\n");   
                        }
                        if (otherFee > 0) {
                         result.append("Other Monthly Fee: " + otherFee + "\n");   
                        }
		result.append("The monthly payment is " + monthlyPayment + "\nThe total payment is " + totalPayment + "\n\n\n")
	
		.append("Date\t\tPrinciple\t\tInterest\t\tPayment\t\tBalance\n\n");
		
		for (int m = monthsLeft; m > 0; m--) {
			
			monthlyInterest = (remainingBal * monthlyInterestRate) + .01;
				monthlyPrinciple = (monthlyPayment - monthlyInterest) + .01;
				remainingBal = (remainingBal - monthlyPrinciple) + .01;
				
				//format to keep 2 digits after the decimal
				monthlyPrinciple = (int)(monthlyPrinciple * 100) / 100.0;
				monthlyInterest = (int)(monthlyInterest * 100) / 100.0;
				remainingBal = (int)(remainingBal * 100) / 100.0;
   
                                
                                if (startMonth < 10){
                    result.append("0");
                }
                    
		result.append(startMonth + "/" + startYear + "\t\t" + monthlyPrinciple + "\t\t" + monthlyInterest + "\t\t" + monthlyPayment + "\t\t" + remainingBal + "\n");
                
                
                if (startMonth < 12) {
                    startMonth++;
                } else {startMonth = 1;
                        startYear++;}
                        
                
		}
		return output = result.toString();
		 
	} 
    
    void createClient(MortgageClient client) {
        
        int i = 0;
    	if (activeClientAccountCount < 10){
    		i = activeClientAccountCount;
    		clientAccount[i] = client;
    		activeClientAccountCount++;
        }        
    }

    
   
        
    }
    

