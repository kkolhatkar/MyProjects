public class CS401BSTArrayExample  {
  public static void main (String[] args)
  {
    new CS401BSTArrayExample().run();
  } // method main
  
  public void run()  {
     run_example_1();
   
   }

   public void run_example_1()  {


	      CS401BSTArray<Integer> t = new CS401BSTArray<Integer>();
	      int nums[] = {100, 59, 13, 82, 58, 63, 65, 46, 80, 62, 28, 71, 
	                    92, 47, 93, 8};

	      for (int i = 0; i < nums.length; i++)
	          t.add(nums[i]);
	     
     
    
     t.print();

   }
  
} // class BinarySearchTreeExample
