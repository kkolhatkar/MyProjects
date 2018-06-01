import java.util.*;

public class CarWash
{
     
  
     protected int departurePointer=0;
     Poisson p ;
     List<Integer> poissonAns ;
     protected Queue<Car> carQueue;  
     protected LinkedList<String> results;  
     protected int  meanServiceTime,nextDepartureTime,maxArrivalTime,meanArrivalTime,nextArrivalTime,currentTime,
		           	sumOfWaitingTimes,overflowCount,numberOfCars, waitingTime, totalArrivedCars;




     public CarWash(int meanArrivalTime, int meanServiceTime, int maxArrivalTime)
     {
         carQueue = new LinkedList<Car>();
         results = new LinkedList<String>();
         results.add ("\n\nTime\tEvent\t\tWaiting Time\n");
         this.meanArrivalTime = meanArrivalTime;
         this.meanServiceTime = meanServiceTime;
         this.maxArrivalTime = maxArrivalTime;
         currentTime = 0;
         numberOfCars = 0;
         waitingTime = 0;
         sumOfWaitingTimes = 0;
         nextDepartureTime = maxArrivalTime; 
         p = new Poisson();
         poissonAns=  p.run(meanArrivalTime,maxArrivalTime);
         this.nextArrivalTime = poissonAns.get(0);
        
     } 
     
     public void Process()
     {
    	 int i=1;
    	 while(nextArrivalTime < maxArrivalTime)
    	 
    	 {
			totalArrivedCars=totalArrivedCars+1;
			NextCar(nextArrivalTime);
			nextArrivalTime=poissonAns.get(i);
			i++;
    	 }
    	 finish();
     }
     
     protected int getServiceTime()
     {
    	 departurePointer =meanServiceTime;
    	 return departurePointer;
  
     }
     
     public LinkedList<String> NextCar (int nextArrivalTime)
     {
         if (nextArrivalTime < currentTime)
              throw new IllegalArgumentException ("Time of the next arrival cannot be less than the current time");
         while (nextArrivalTime >= nextDepartureTime)
              Departure();
         return Arrival (nextArrivalTime);
     } 

     protected LinkedList<String> Arrival (int nextArrivalTime)
     {        

         currentTime = nextArrivalTime;         
         if (carQueue.size() == 5)        
         { 
             results.add (Integer.toString (currentTime) + "\tArrival" +  "Overflow\n");
             overflowCount++;
         }
         else
         {
              results.add (Integer.toString (currentTime) + "\tArrival");
              numberOfCars++;
              if (nextDepartureTime == maxArrivalTime) 
                  nextDepartureTime = currentTime + getServiceTime();
              else
                  carQueue.add (new Car (nextArrivalTime));
              results.add ("\n");
         } 
         return results;
     } 


     protected LinkedList<String> Departure()
     {
         final String DEPARTURE = "\tDeparture\t\t";
         int arrivalTime;
         currentTime = nextDepartureTime;
         results.add (Integer.toString (currentTime) + DEPARTURE +
                         Integer.toString (waitingTime) + "\n");
         if (!carQueue.isEmpty())
         {
              Car car = carQueue.remove();
              arrivalTime = car.getArrivalTime();
              waitingTime = currentTime - arrivalTime;
              sumOfWaitingTimes += waitingTime;
              nextDepartureTime = currentTime + getServiceTime();
     
         } 
         else
         {
              waitingTime = 0;
              nextDepartureTime = maxArrivalTime; 
         } 
         return results;
     } 

     public LinkedList<String> finish()
     {
         while (!carQueue.isEmpty())  
               Departure();
         return results;
     } 


     public LinkedList<String> Results()
     {

         if (numberOfCars == 0)
              results.add ("There were no cars in the car wash.\n");
         else
         {
             	results.add ("\nAverage waiting time is "+ Double.toString (Math.round(((double) sumOfWaitingTimes/numberOfCars)*10)/ 10.0) + " minutes per car.");
             	results.add ("\nAverage queue length is" + Double.toString (Math.round(((double) sumOfWaitingTimes/nextDepartureTime)*10)/10.0) + " cars per minute.");
             	results.add("\nThe number of overflows was " + overflowCount + ".");
         }
         return results;
     } 

} 