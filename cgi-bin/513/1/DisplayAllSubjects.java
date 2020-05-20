import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


public class DisplayAllSubjects{

	public static void main( String[] args) throws SQLException {


 	    String user ="C##mark.arinaitwe";
	    String password ="arinaitwe9120";
	    String database="65.52.222.73:1521/cdb1";
            //String title= "null";  
	    String subjectid = " "; 
	    String subject =" ";       
            
	    //connect and open to the oracle database
	    OracleDataSource ods = new OracleDataSource();
	    ods.setURL ("jdbc:oracle:thin:@" + database );
	    ods.setUser (user);
	    ods.setPassword(password);
	   
	    Connection conn = ods.getConnection();
             
        try
        {
	    Statement stmt = conn.createStatement();
	       
	    String query = "SELECT subjectid, subject from subjects1";

            //System.out.println("Content-type: text/plain\n\n");
            //System.out.println("<!DOCTYPE html>");
           // System.out.println("<html><head>\n</head>\n<body>");
            //System.out.println("<h3><em>" +query+ "</em></h3>");
                
            ResultSet rset =  stmt.executeQuery(query);
                  
           // System.out.println("<h3><em>" +query+ "</em></h3>");
          //  boolean inTable = false;
          //System.out.println("<br><tr>");

 	   System.out.print(
	   "<!DOCTYPE html>" +
	      "\n<html>\n"+
      		"\n<head>\n"+
         	   "\n<title>Subjects</title>\n"+
      	 	"\n</head>\n"+
      		"\n<body>\n"+
         	   "<h1>Subjects</h1>\n<br />");
	   System.out.print("\n<br/><form method =\"post\" action =\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/SearchForBooks.cgi\" target=\"view\">");

            while (rset.next())
            {
		            	//title=    rset.getString("title");
	     	subjectid = rset.getString("subjectid");
		subject = rset.getString("subject");
                System.out.println("<input type =\"checkbox\" name =\"subjects\" value = \""+subjectid + "\"><a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/SubjectDetails.cgi?subjectid=" +subjectid+"'>"+subject+"</a>&nbsp;&nbsp;"+
"<br/><br/><br/>");
		              
            }
	   System.out.print("<input type =\"submit\" name =\"act\"  value = \"SearchForBooks\">"+
   		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Java source\">"+
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Java source2\">"+
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Perl source\">"+
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Perl source2\">"+
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Java source3\">"+
		"</form>\n"+
		"</body>\n"+
		"</html>");

           //System.out.println("</tr>");
	   //System.out.print("</body>\n</html>");
                             
	    	
	   // System.out.println("</body>\n</html>");
	    
               
            rset.close();
            stmt.close();
         }
         catch( SQLException ex){
             System.out.println( ex);
         }

 	conn.close();



	}
}
