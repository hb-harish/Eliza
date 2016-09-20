import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomQ extends Thread 
{
	private Map <Integer, String> hedgeMap = new HashMap <Integer,String>();
	public String Hedge()
	{
		hedgeMap.put(0, "\nType Faster" );
		hedgeMap.put(1, "\nGo on i havent got all day " );
		hedgeMap.put(2, "\nPatience is not my best quality" );
		hedgeMap.put(3, "\nMmmmhmmm" );
		hedgeMap.put(4, "\nRemember every second is costing you" );
		Random rnd = new Random();
		int i = rnd.nextInt(5);
		return hedgeMap.get(i);
	}
	
	public void run()
	{
			
			do
			{
								
				try {
					this.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Hedge());
				
			}while(true);
	

		
	}
	

}
