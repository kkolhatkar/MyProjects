
public class MainRunner {
	public static void main(String[] args) {
		CS401QueueArrayFixedImpl<String> ex1 = new CS401QueueArrayFixedImpl<String>(10);
		ex1.add("a");
		ex1.add("b");
		ex1.add("c");
		ex1.add("d");
		ex1.add("e");
		ex1.add("f");
		ex1.add("g");
		ex1.add("h");
		ex1.add("i");
		ex1.add("j");
		System.out.println("CS401QueueArrayFixedImpl is full "+ ex1.is_full());
		ex1.add("k");
		System.out.println("Is empty "+ex1.is_empty());
		System.out.println("Removed "+ex1.remove());
		System.out.println("Peek "+ex1.peek());
		
		CS401QueueArrayFloatingImpl<String> ex2 = new CS401QueueArrayFloatingImpl<String>(10);
		ex2.add("a");
		ex2.add("b");
		ex2.add("c");
		ex2.add("d");
		ex2.add("e");
		ex2.add("f");
		System.out.println("CS401QueueArrayFloatingImpl is empty : "+ex2.is_empty());
		ex2.add("g");
		System.out.println("Removed :"+ex2.remove());
		ex2.add("h");
		System.out.println("Peek "+ex2.peek());
		
		
		CS401QueueLinkedListImpl<String> ex3 = new CS401QueueLinkedListImpl<String>();
		ex3.add("a");
		ex3.add("b");
		ex3.add("c");
		ex3.add("d");
		ex3.add("e");
		ex3.add("f");
		System.out.println("CS401QueueLinkedListImpl is empty "+ex3.is_empty());
		ex3.add("g");
		System.out.println("remove: "+ex3.remove());
		ex3.add("h");
		System.out.println("Peek "+ex3.peek());
		
	}
}
