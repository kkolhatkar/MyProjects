public class CS401BSTArray<E extends Comparable <E>> {
   protected TreeNode<E> [] tree;
   protected int root, size, indx;
	
   public CS401BSTArray() {
       /**
        * Do not initialize tree as: tree=(TreeNode<E> []) new Object[50];
        * While this will compile, it will throw a ClassCastException
        * when run.  Instead, use the initialization below.  Even the one
        * shown below is not the best, since Java does not allow a clean
        * way to allocate memory to hold an array of generic class objects.
        * For more information, see
        * https://courses.cs.washington.edu/courses/cse332/10su/notes/
        * genericArrays.html 
        * (Mind the line break in the above URL.  When you go to the above
        * URL, see Workaround #2.) */
      tree =  (TreeNode<E>[]) new TreeNode[50];
      root = 0;
      size = 0;
      indx = 0;
   }

   protected static class TreeNode<E> {
      E element;
      int parent, left, right;
		
      public TreeNode (E element, int parent, int left, int right) {
         this.element = element;
         this.parent = parent;
         this.left = left;
         this.right = right;
      }
   }

   public boolean add(E element)  {

      boolean r = false;
     
      /**
       * Example code to demonstrate creating a simple tree.  You will
       * replace this code to create a more complex tree */
     

       //Comparable<E> tempelement = (Comparable<E>)element;

       if (size==0) {
          tree[0] = new TreeNode<E>(element,-1,-1,-1);
          indx  ++;
       }
       else 
       {
          boolean added = false;
          int currentIndex = 0;

          while (!added) 
          {
             if (element.compareTo(tree[currentIndex].element) < 0) 
             {
                // go left
                if (tree[currentIndex*2+1] == null) 
                {
                   tree[currentIndex*2+1].element = element;
                   added = true;
                   if (currentIndex*2+1 > indx)
                      indx = currentIndex*2+1;
                }
                else
                   currentIndex = currentIndex*2+1;
             }
             else {
                // go right
                if (tree[currentIndex*2+2] == null) 
                {
                   tree[currentIndex*2+2].element = element;
                   added = true;
                   if (currentIndex*2+2 > indx)
                      indx = currentIndex*2+2;
                }
                else
                   currentIndex = currentIndex*2+2;
             }
             
          }//while
       }//else

       //height = (int)(Math.log(maxIndex + 1) / Math.log(2)) + 1;
       size++;

      
      
      
      
      
      
      /* if (indx == 0)  {
         tree[indx] = new TreeNode(element, -1, -1, -1);
         r = true;
      }
      else if (indx == 1)  {
         tree[indx] = new TreeNode(element, 0, -1, -1);
         r = true;
      }
      else if (indx == 2)  {
         tree[indx] = new TreeNode(element, 0, -1, -1);
         r = true;
      }

      indx++;
      size++;*/

      return r;
   }

   /**
    * print - Prints the array based tree as a table with 4 columns.
    */
   void print()  {
      int indx;

      for (indx = 0; indx < size; indx++)  {
         System.out.println(tree[indx].element + ", " +
                            tree[indx].parent  + ", " +
                            tree[indx].left    + ", " +
                            tree[indx].right);
      }
   }

   public static void main(String[] args)  {
      CS401BSTArray<Integer> myGenClassArray = new CS401BSTArray<Integer>();

      myGenClassArray.add(33);
      myGenClassArray.add(20);
      myGenClassArray.add(40);

      myGenClassArray.print();
   }
}
