
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ElizaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Reply r = new Reply();
		System.out.println("So tell me what brings you here today\t:");
//		random question generator
//		Thread threadC = new RandomQ();
//		threadC.start();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
			stmt = con.createStatement();

		try 
		{
			pstmt = con.prepareStatement("SELECT * FROM   (SELECT description  FROM   reply  Where t ='h' ORDER BY DBMS_RANDOM.RANDOM) WHERE  rownum=1");
			pstmt2 = con.prepareStatement( "SELECT * FROM   (SELECT description  FROM   reply  Where t ='q' ORDER BY DBMS_RANDOM.RANDOM) WHERE  rownum=1");
		} 
		catch (SQLException e2) 
		{
			e2.printStackTrace();
		}
		

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
			{
				rs = pstmt.executeQuery();
				while(rs.next())
				{
				System.out.println(rs.getString("description") + " ");
				}
			}
			else if(i==2)
			{
				rs = pstmt2.executeQuery();
				while(rs.next())
				{
					System.out.print(rs.getString("description") + " ");
				}
				for (int j =0; j<parts.length; j++)
				{
					System.out.print(r.Replacer(parts[j]) + " ");
				}
				System.out.print("\n");
			}
			
		}

		}catch (SQLException e) 
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e) 
		{
				e.printStackTrace();
		}finally 
		{
				try 
				{
					rs.close();
					stmt.close();
					con.close();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
//		threadC.stop();
		}
	

}
