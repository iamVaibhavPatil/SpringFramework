package guru.springframework.algorithm;

import java.util.Stack;

public class ParenthesisMatcher {

	Stack<Character> stack = new Stack<Character>();
	
	public boolean isParenthesisBalanced(char ch[]) {
		for(int i = 0; i < ch.length; i++) 
		{
			if(ch[i] == '{' || ch[i] == '[' || ch[i] == '(') {
				stack.push(ch[i]);
			}
			else if(ch[i] == '}' || ch[i] == ']' || ch[i] == ')') {
				if(!stack.isEmpty()) {
					char openingBracket = stack.pop();
					char closingBracket = ch[i];
					if(!match(openingBracket, closingBracket)) {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true; /*balanced*/
		}
		else
		{
			return false;
		} 
	}
	
	private boolean match(char openingBracket, char closingBracket) {
		if(openingBracket == '(' && closingBracket == ')') {
			return true;
		}
		else if(openingBracket == '[' && closingBracket == ']') {
			return true;
		}
		else if(openingBracket == '{' && closingBracket == '}') {
			return true;
		}
		else return false;
	}

	public static void main(String[] args) {
		ParenthesisMatcher matcher = new ParenthesisMatcher();
		String expression = "(()){}";
		System.out.println(matcher.isParenthesisBalanced(expression.toCharArray()));
	}
}
