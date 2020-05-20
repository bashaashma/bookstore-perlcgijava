import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


public class ResetSystem{

	public static void main( String[] args) throws SQLException {


 	    String user ="C##mark.arinaitwe";
	    String password ="arinaitwe9120";
	    String database="65.52.222.73:1521/cdb1";
            //String title= "null";  
	    String subjectid = " "; 
	    String count = " ";    
            String isbn =" "; 
	    //connect and open to the oracle database
	    OracleDataSource ods = new OracleDataSource();
	    ods.setURL ("jdbc:oracle:thin:@" + database );
	    ods.setUser (user);
	    ods.setPassword(password);
	   
	    Connection conn = ods.getConnection();
             
        try
        {


                Statement stmt = conn.createStatement();
	        String query = "delete from book_subjects1";
		stmt.executeUpdate(query);
		

		query= "delete from books1";
		stmt.executeUpdate(query);
		
		query= "delete from subjects1";
		stmt.executeUpdate(query);
		stmt.close();

		System.out.print(
	   "<!DOCTYPE html>" +
	      "\n<html>\n"+
      		"\n<head>\n"+
         	   "\n<title>Reset System</title>\n"+
      	 	"\n</head>\n"+
      		"\n<body>\n"+
         	   "<h1>System Reset!</h1>\n<br />");
	   System.out.print("\n<br/><form method =\"post\" action =\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/ResetSystem.cgi\" target=\"view\">");

	   System.out.print("<input type =\"submit\" name =\"act\"  value = \"Java source\">"+
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Perl source\">"+
		"</form>\n"+
		"</body>\n"+
		"</html>");

 
         }
         catch( SQLException ex){
             System.out.println( ex);
         }

 	conn.close();



	}
}
