
import java.util.*;

public class CarWashUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter mean Arrival Time: ");
		int meanArrivalTime = sc.nextInt();
		System.out.print("Please Enter mean Service Time: ");
		int meanServiceTime = sc.nextInt();
		System.out.print("Please Enter maximum Arrival Time: ");
		int maxArrivalTime = sc.nextInt();

		CarWash carWash = new CarWash(meanArrivalTime, meanServiceTime, maxArrivalTime);
		carWash.Process();
		LinkedList<String> results = carWash.Results();
		for (String s : results)
			System.out.print(s);
	}

}
