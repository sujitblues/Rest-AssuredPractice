package retryDemo;

import java.time.Duration;

import org.awaitility.Awaitility;

public class createBookingTests {
	public static void main(String[] args)
	{
		/*
		 * //Approach 1 for(int i=0;i<5;i++) { if(createBooking.create()==200) break; }
		 */
		
		//Approach 2:
		Awaitility
		.await()
		.atMost(Duration.ofSeconds(30))
		.pollInterval(Duration.ofSeconds(2))
		.until(()->createBooking.create()==200);
		
	}
}
