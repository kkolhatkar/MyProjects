/* 
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFixedImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {

      /*** Add code ***/
	   if(is_full()){
		   E[] temp=(E[]) new Object[capacity];
		 	   
		   for (int i = 0; i < temp.length; i++) {
					temp[i] = data[i];
		}
		   capacity = capacity*2;	
		   data = (E[]) new Object[capacity];
		   for (int i = 0; i < temp.length; i++) {
				data[i]=temp[i];
			}
	   }
	   data[back] = element;
	   back++;
		
	   
   }

   public E remove()  {
      
      /*** Add code ***/
	   E e = data[front];
	   
	   for (int i = 0; i < back-1; i++) {
		data[i]=data[i+1];
	}
	   data[back-1]=null;
	   back--;
	   return e;
	   
   }

   public E peek()  {

      /*** Add code ***/
	   return data[front];
   }

   public boolean is_empty()  {

      /*** Add code ***/
	   if(back==front){return true;}else{return false;}
	   
	   
   }

   public boolean is_full()  {

      /*** Add code ***/
	   if(back==capacity){
		   return true;
	   }else{
		   return false;
	   }
   }
}
