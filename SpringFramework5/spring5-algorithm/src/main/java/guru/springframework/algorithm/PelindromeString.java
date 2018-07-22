package guru.springframework.algorithm;

public class PelindromeString {

	public static boolean isPelindrome(String input) {
		int low = 0;
		int high = input.length() - 1;
		while(low < high) {
			if(input.charAt(low) != input.charAt(high)) {
				return false;
			}
			low ++;
			high --;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String input = "WMMAMMW";
		
		System.out.println(isPelindrome(input));
		
	}
}
