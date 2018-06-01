import java.util.Scanner;

public class InfixToPostFix {
	public static void main(String[] args) {

		 Scanner input = new Scanner(System.in);
		System.out.println("Enter the Infix expression");
		 String infix= input.nextLine();
	//	String infix = "3+5*2-8/4";
		String postfix = "";

		CS401StackArrayImpl<Character> stack = new CS401StackArrayImpl(10);
		
		char[] convert = infix.toCharArray();
		for (int i = 0; i < convert.length; i++) {
			//System.out.println(convert[i]);
			if(convert[i]==' '){}
			else{
			if (convert[i] == '+' || convert[i] == '-' || convert[i] == '*' || convert[i] == '/') {
				if (stack.size() == 0) {
					stack.push(convert[i]);
				} else {
					if ((convert[i]=='+'|| convert[i]=='-') ) {
						while (stack.size() > 0) {
							postfix = postfix + stack.pop();
						}
						stack.push(convert[i]);
					} 
					if ((convert[i] == '/' || convert[i] == '*')) {
						if(stack.peek()== '/' || stack.peek() == '*'){
							while (stack.peek()!='-'||stack.peek()!='+') {
								postfix = postfix + stack.pop();
							}							
						}
						else{
							stack.push(convert[i]);
						}
					} 
				}

			} else {
				postfix = postfix + convert[i];
			}
		}
		}
		if (stack.size() != 0) {
			while (stack.size() > 0) {
				postfix = postfix + stack.pop();
			}
		}
		System.out.println("Corresponding postfix String "+postfix);
		// We got postfix expression
		/********************************************************************************************************************************************/
		// Now evaluating the expression 3 5 2 * + 8 4 / -
		char[] evaluator = postfix.toCharArray();

		float operand1 = 0;
		float operand2 = 0;
		CS401StackArrayImpl<Float> ans = new CS401StackArrayImpl(10);
		for (int i = 0; i < evaluator.length; i++) {
			if (evaluator[i] == '+' || evaluator[i] == '-' || evaluator[i] == '*' || evaluator[i] == '/') {
				operand1 = ans.pop();
				operand2 = ans.pop();
				float temp = 0;
				if (evaluator[i] == '+') {
					temp = operand2 + operand1;
				} else if (evaluator[i] == '-') {
					temp = operand2 - operand1;
				} else if (evaluator[i] == '*') {
					temp = operand2 * operand1;
				} else {
					temp = (operand2) / (operand1);
				}

				ans.push(temp);
			} else {
				ans.push((float)Character.getNumericValue(evaluator[i]));
			}
		}

		System.out.println("Evaluation of Postfix String: "+ans.pop());

	}
}
