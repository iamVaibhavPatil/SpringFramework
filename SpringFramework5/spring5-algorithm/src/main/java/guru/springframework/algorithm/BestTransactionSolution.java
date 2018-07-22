package guru.springframework.algorithm;

public class BestTransactionSolution {
	 static String computeBestTransaction(int[] data) {
		 
		 int buyDay = 0;
		 int buyPrice = 0;
		 int sellDay = 0;
		 int sellPrice = 0;
		 int profit = 0;		 
		 
		 if(data !=null && data.length > 0)
		 {			 
			 for(int i=0; i<data.length;i++) {
				 for(int j=i+1; j<data.length;j++) {
					 if(data[j] - data[i] > profit) {
						 profit = data[j] - data[i];
						 buyDay = i+1;
						 buyPrice = data[i];
						 sellDay = j+1;
						 sellPrice = data[j];
					 }
				 }
			 }
		 }
		 return formatOutputString(buyPrice,buyDay,sellPrice,sellDay,profit);
	 }
	 
	 static String computeBestTransactionEfficient(int[] data) {
		 
		 int buyDay = 0;
		 int buyPrice = 0;
		 int sellDay = 0;
		 int sellPrice = 0;
		 int profit = 0;		 
		 
		 if(data !=null && data.length > 0)
		 {
			 int maxProfit = data[1] - data[0];
			 int buyAt = data[0];
			 buyDay = 0;
			 for(int i=0; i < data.length;i++) {
				 if(data[i] - buyAt > maxProfit) {
					 maxProfit = data[i] - buyAt;
					 
					 profit = maxProfit;
					 buyPrice = buyAt;
					 //buyDay = i;
					 sellDay = i+1;
					 sellPrice = data[i];
				 }
				 if(data[i] < buyAt) {
					 buyAt = data[i];
					 buyDay = i+1;
				 }
			 }
		 }
		 return formatOutputString(buyPrice,buyDay,sellPrice,sellDay,profit);
	 }	 
	 
	 static String formatOutputString(int buyPrice, int buyDay, int sellPrice, int sellDay, int profit){
  	   return "BUY@"+buyPrice+" on day "+buyDay+" and SELL@"+sellPrice+" on day "+sellDay+".  For a profit of $"+profit+" per share!";
	 }
	 
	public static void main(String[] args) {
		int[] data = {100,101,99,94,80,99,100,111,103,102,81,85,84,95,100,105,70,75,90,110,20};
		System.out.println(BestTransactionSolution.computeBestTransaction(data));
	}	 
}
