import java.util.Iterator;


public class CS401StackLinkedListImpl<E> implements CS401StackInterface<E> 
{
   private LinkEntry<E> head;
   private int num_elements;

   public CS401StackLinkedListImpl()
   {
      head = null;
      num_elements = 0;
   }

   public void push(E e)
   {
      /** Add code here **/
	   LinkEntry<E> ne = new LinkEntry<E>();
		ne.element = e;
		if (num_elements==0) {
			head =  ne;
			//System.out.println(head.element+"  "+head.next);
			num_elements++;
		
		}else{
			ne.next = head;
			head = ne;
			num_elements++;
		}
     
   }

   public E pop()
   {
      /** Add code here **/
	   E e = head.element;
	   head=head.next;
	   num_elements--;
	   return e;
	   
	   
   }

   public E peek()
   {
      /** Add code here **/
	   return head.element;
   }

   public int size()
   {
      /** Add code here **/
	   return num_elements;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
	{
		protected E element;
		protected LinkEntry<E> next;

		protected LinkEntry() {
			element = null;
			next = null;
		}
   }
} /* CS401StackLinkedListImpl<E> */
