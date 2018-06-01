/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;
   private int num_elements;
   public CS401QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

	public void add(E element) {

		/*** Add code ***/
		if (is_full()) {
			E[] temp = (E[]) new Object[capacity];

			for (int i = 0; i < temp.length; i++) {
				temp[i] = data[i];
			}
			capacity = capacity * 2;
			data = (E[]) new Object[capacity];
			for (int i = 0; i < temp.length; i++) {
				data[i] = temp[i];
			}
			
			back= num_elements;
			data[back]=element;
			num_elements++;
			back= num_elements;
		} else{
		
			data[back] = element;
			num_elements++;
			if(!is_full()){
				back = (back + 1) % capacity;
			}else{
				back = back+1;
			}
			
			//System.out.println(back);
		}
	}

   public E remove()  {
      
      /*** Add code ***/  
	   E e = data[front];
	   num_elements--;
	   data[front]=null;
	   if(!is_full()){
			front = (front + 1) % capacity;
		}else{
			front = front+1;
		}
	   return e;

   }
   public E peek()  {

      /*** Add code ***/
	   return data[front];
   }

   public boolean is_empty()  {

      /*** Add code ***/	
	   if (back==front) {
			return true;
		} else {
			return false;
		}

   }

   public boolean is_full()  {

      /*** Add code ***/
	   if(num_elements==capacity){
		   return true;
	   }else{
		   return false;
	   }
	   

   }

}
