import java.util.Iterator;


public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>, Iterable<E>
{
   protected LinkEntry<E> head;
   protected LinkEntry<E> tail;
   protected int num_elements = 0;
  
   public CS401LinkedListImpl()
   {
      head = tail = null;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /* 
    * Adds element e at the end of the linked list. */
   public boolean add(E e)
   {
      add(Where.BACK, e);
      
      return true;
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i)
   {
	  
		/**
		 * Add code here.
		 */ 
	   
	   E b =null;
	  
	   int temp = 1;
	   if(i>num_elements){
		   b=null;
	   }else{
		   Iterator<E> it = this.iterator();
			 while(it.hasNext()){
				 if(temp==i){
					 b=head.element;
					 it.remove();
					 break;
				 }
				 
				//
				
				temp++;
			 }
	   }
	   
		return b;
	}

   /**
    * Determines if e is in the collection. 
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
      	/**
		 * Add code here.
		 */
	   boolean b = false;
		Iterator<E> it = this.iterator();
		while (it.hasNext()) {
			if (e.equals(it.next())) {
				b= true;break;
				
			} else {
				b= false;
			}
		}
		return b;
	   
    
   }

   /**
    * Add e to either front of the linked list or the end of the linked
    * list, depending on the value of the parameter where.
    * If where == MIDDLE, return false.
    * Returns true if element added to back or front, or false if asked
    * to add in the middle. */
   public boolean add(Where where, E e)  {

      if (where == Where.MIDDLE) 
          return false;

      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
          num_elements++;
          return true;
      }

      if (where == Where.BACK) {
         tail.next = ne;
         tail = ne;
      }
      else if (where == Where.FRONT)  {
          /**
           * Add code here. */
    	  
    	  ne.next = head;
    	  head = ne;
      }
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  
    * First element of the linked list is 1, second is 2, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {
	   LinkEntry<E> ne = new LinkEntry<E>();
	   ne.element=e;
	    int position = index ;
	    LinkEntry<E> cur = head;
	    for (int i =1; i <= num_elements; i++) {
	      if(i == position) {
	        ne.next = cur.next;
	        cur.next = ne;
	      }
	      cur = cur.next;
	    }
	   num_elements++;
      return true;
   }

   /**
    * Print the collection class (linked list) by iterating over all of
    * the elements in the collection class and serializing them. 
    * Returns a Java String object that represents the serialization of
    * the collection class. */
   public String toString()  {

      StringBuilder result = new StringBuilder();
 
      /**
       * Add code here. 
       * Traverse the linked list and serialize each object.  Add the
       * serialized form to result. */
      Iterator<E> it = this.iterator();
      
      while(it.hasNext()){
     result.append(it.next());	 
      } 
      return result.toString();
   }
   

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
   }


	/*----------------------------------------------------------------- */

	public Iterator<E> iterator() /* From Interface Iterable */
	{
		return new CS401LinkedListIterator();
	}

	protected class CS401LinkedListIterator implements Iterator<E> {
		protected LinkEntry<E> current;
		//  private int position = 1;
		protected CS401LinkedListIterator() {
			current = head;
		}
		
		public E next() {
			/* To be filled in by students … */ 
			E data = current.element;
			 if (current != tail)  {
	             current = current.next;                  
	    	  } else {
	    		  current = null; 
	    	  }
            return data;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() /* Remove the element under the iterator. */
		{			
			 LinkEntry<E> removing = this.current;	
			head = removing.next;
				 num_elements--;
			
		}
   }
}