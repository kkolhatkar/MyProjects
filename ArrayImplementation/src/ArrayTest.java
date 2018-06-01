
public class ArrayTest {

	public static void main(String[] args) {
		ArrayImpl<Integer> numbers = new ArrayImpl<Integer>();
		numbers.add(100);
		numbers.add(200);
		numbers.add(300);
		numbers.add(400);
		numbers.add(500);
		numbers.add(600);
		numbers.add(700);
		numbers.add(700);
		print_list(numbers);
		ArrayImpl<Integer> sub = numbers.subList(1,4);
		print_list(sub);
	}
	
	
	private static void print_list(ArrayImpl<Integer> numbers){
		
		for (int i = 0; i < numbers.size(); i++)
		{
		System.out.print(numbers.get(i) + " ");
		} System.out.println();

	}

}
