import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Reply {
	
	private Map <Integer, String> hedgeMap = new HashMap <Integer,String>();
	private Map <Integer, String> qualifierMap = new HashMap <Integer, String>();
	private Map <String,String> replacementMap = new HashMap <String,String>();
	
	public String Hedge()
	{
		hedgeMap.put(0, "Please tell me more. " );
		hedgeMap.put(1, "Many of my patients tell me the same thing. " );
		hedgeMap.put(2, "I understand, but it is getting late, maybe we had better quit " );
		hedgeMap.put(3, "Interesting, " );
		hedgeMap.put(4, "I find it peculiar, " );
		Random rnd = new Random();
		int i = rnd.nextInt(5);
		return hedgeMap.get(i);
	}
	
	public String Qualifier( )
	{
		qualifierMap.put(0, "Why do you say that " );
		qualifierMap.put(1, "It might not be true when you seem to think that " );
		qualifierMap.put(3, "So, you are concerned that " );
		qualifierMap.put(4, "How do you feel about " );
		Random rnd = new Random();
		int i = rnd.nextInt(5);
		return qualifierMap.get(i);
	}
	
	public String Replacer(String z)
	{
		replacementMap.put("i", "you" );
		replacementMap.put("I", "you" );
		replacementMap.put("me", "you" );		
		replacementMap.put("my", "your" );
		replacementMap.put("am", "are" );
		String re;
		if (replacementMap.containsKey(z))
			re = replacementMap.get(z);
		else 
			re = z;
		return re;
 	}

	
}
