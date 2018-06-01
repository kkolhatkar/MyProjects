

public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;
   
   public CS401QueueLinkedListImpl() {
		head = tail = null;
	}

   public void add(E element) {

      /*** Add code ***/
	   LinkEntry<E> newElement = new LinkEntry<E>();
	   newElement.element  = element;
		if (head == null && tail == null) {
			tail =head = newElement;
			num_elements++;
		}else{
			tail.next = newElement;
			tail = newElement;
			num_elements++;
		}
	   
   }

   public E remove()  {
      
      /*** Add code ***/
	   E e = head.element;
	   head  = head.next;
	   num_elements--;
	   return e;

   }
   public E peek()  {

      /*** Add code ***/
	   return head.element;

   }

   public boolean is_empty()  {

      /*** Add code ***/
	   if(head == null && tail == null)
		   return true;
	   else 
		   return false;

   }

   public boolean is_full()  {

      /*** Add code ***/
	  // if(num_elements==)
	   return false;

   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
      protected LinkEntry() { element = null; next = null; }
   }
}
