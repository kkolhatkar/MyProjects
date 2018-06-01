
public class StackArrayMain {
	public static void main(String[] args) {

		CS401StackArrayImpl<Character> ex = new CS401StackArrayImpl(10);
		ex.push('a');
		ex.push('b');
		ex.push('c');
		ex.push('d');
		ex.push('e');
		ex.push('f');
		ex.push('g');
		ex.push('h');
		ex.push('i');
		ex.push('j');
		System.out.println("Number of elements on Stack: " + ex.size());
		ex.push('k');
		System.out.println("Number of elements on Stack: " + ex.size());
		System.out.println("Poping the topmost element " + ex.pop());
		System.out.println("Poping the topmost element " + ex.pop());
		System.out.println("Peeking the top most element on stack " + ex.peek());
		System.out.println("Number of elements on Stack: " + ex.size());

	
		

	}
}
