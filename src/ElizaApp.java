
import java.util.Random;
import java.util.Scanner;

public class ElizaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Reply r = new Reply();
		System.out.println("So tell me what brings you here");
		Thread threadC = new RandomQ();
		threadC.start();

		while(true)
		{
			String w = sc.nextLine();
			if (w.equalsIgnoreCase("quit"))
			{
				System.out.println("Well okay let us call it a day. See you later.");
				break;
			}
			String delim = " ";
			String[] parts = w.split(delim);
			Random rnd = new Random();
			int i = 1 + rnd.nextInt(2);
			if (i==1)
				System.out.println(r.Hedge() + " ");
			else if(i==2)
			{
				System.out.print(r.Qualifier());
				for (int j =0; j<parts.length; j++)
				{
					System.out.print(r.Replacer(parts[j]) + " ");
				}
				System.out.print("\n");
			}
			
		}

	}

}
