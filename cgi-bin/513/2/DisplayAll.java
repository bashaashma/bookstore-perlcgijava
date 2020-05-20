import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


public class DisplayAll{

	public static void main( String[] args) throws SQLException {


 	    String user ="C##mark.arinaitwe";
	    String password ="arinaitwe9120";
	    String database="65.52.222.73:1521/cdb1";
                  
            
	    //connect and open to the oracle database
	    OracleDataSource ods = new OracleDataSource();
	    ods.setURL ("jdbc:oracle:thin:@" + database );
	    ods.setUser (user);
	    ods.setPassword(password);
	   
	    Connection conn = ods.getConnection();
             
        try
        {

	    System.out.print(
	   "<!DOCTYPE html>" +
	      "\n<html>\n"+
      		"\n<head>\n"+
         	   "\n<title>Books</title>\n"+
      	 	"\n</head>\n"+
      		"\n<body>\n"+
         	   "<h1>Books</h1>\n<br />");
	   System.out.print("\n<br/><form method =\"post\" action =\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/ListTitles.cgi\" target=\"view\">");

           
	    Statement stmt = conn.createStatement();
	       
	    String query = "SELECT title, isbn from books2";

            //System.out.println("Content-type: text/plain\n\n");
            //System.out.println("<!DOCTYPE html>");
           // System.out.println("<html><head>\n</head>\n<body>");
            //System.out.println("<h3><em>" +query+ "</em></h3>");
                
            ResultSet rset =  stmt.executeQuery(query);
                  
           // System.out.println("<h3><em>" +query+ "</em></h3>");
            boolean inTable = false;
          //System.out.println("<br><tr>");
	    System.out.print("Book Titles:<br/>");

	    String isbn ="";
	    String title= "";
            while (rset.next())
            {
		isbn=    rset.getString("isbn");
	     	title = rset.getString("title");
		System.out.println("<a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/BookDetails.cgi?isbn="+isbn+"'>"+title+"</a>&nbsp;&nbsp;"+"<br/><br/><br/>");
		              
            }
	    stmt.close();
	    rset.close();	



	   //get subjects

	    query = "SELECT distinct e.subject_name from books2 b, table(b.subjectList) e";
	    stmt = conn.createStatement();
	       

            //System.out.println("Content-type: text/plain\n\n");
            //System.out.println("<!DOCTYPE html>");
           // System.out.println("<html><head>\n</head>\n<body>");
            //System.out.println("<h3><em>" +query+ "</em></h3>");
                
           rset =  stmt.executeQuery(query);
                  
           // System.out.println("<h3><em>" +query+ "</em></h3>");
            //boolean inTable = false;
          //System.out.println("<br><tr>");
	    System.out.print("Subject Names:<br/>");
	    String subjectName ="";
            while (rset.next())
            {
		subjectName=    rset.getString("subject_name");
	     	
                System.out.println("<a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/SubjectDetails.cgi?subjectName="+subjectName+"'>"+subjectName+"</a>&nbsp;&nbsp;"+"<br/><br/><br/>");
		              
            }

	    rset.close();
            stmt.close();




















            //Get Customer Data

	    stmt = conn.createStatement();
	       
	    query = "SELECT customer_id, customer_name from customers2";

            //System.out.println("Content-type: text/plain\n\n");
            //System.out.println("<!DOCTYPE html>");
           // System.out.println("<html><head>\n</head>\n<body>");
            //System.out.println("<h3><em>" +query+ "</em></h3>");
                
           rset =  stmt.executeQuery(query);
                  
           // System.out.println("<h3><em>" +query+ "</em></h3>");
            //boolean inTable = false;
          //System.out.println("<br><tr>");
	    System.out.print("Customer Names:<br/>");
	    String customerName ="";
	    String customerId = "";
            while (rset.next())
            {
		customerName=    rset.getString("customer_name");
	     	customerId = rset.getString("customer_id");
                System.out.println("<a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/CustomerDetails.cgi?customerId="+customerId+"&customerName="+customerName+"'>"+customerName+"</a>&nbsp;&nbsp;"+"<br/><br/><br/>");
		              
            }
	   System.out.print("&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Java source\">"+	
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Perl source\">"+
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
