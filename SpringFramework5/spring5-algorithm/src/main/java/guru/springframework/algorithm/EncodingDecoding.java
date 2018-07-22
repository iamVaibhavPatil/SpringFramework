package guru.springframework.algorithm;

public class EncodingDecoding {

	private static String encode(String text) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			b.append(c += c + i);
		}
		return b.reverse().toString();
	}	
	
	static String decode(String encodedMessage) {
		StringBuilder encodedMsg = new StringBuilder(encodedMessage).reverse();
		StringBuilder returnValue = new StringBuilder();
		for (int i = 0; i < encodedMsg.length(); i++) {
			char c = encodedMsg.charAt(i);
			c -=i;
			c /=2;
			returnValue.append(c);
		}
		return returnValue.toString();
    }	
	
	public static void main(String[] args) {
		System.out.println(encode("Vaibhav"));
		System.out.println(decode(encode("Vaibhav")));
	}
}
