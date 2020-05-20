import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


public class SubjectDetails{

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

	        String query = "select b.isbn, b.title, b.subjectInside('"+ args[0]+"') as checkBook from books2 b";
		
		ResultSet rset = stmt.executeQuery(query);

	
		System.out.print(
	       "<!DOCTYPE html>" +
	      "\n<html>\n"+
      		"\n<head>\n"+
         	   "\n<title>SubjectDetails</title>\n"+
      	 	"\n</head>\n"+
      		"\n<body>\n"+
         	   "<h1>Subject Details</h1>\n<br />");
		System.out.print(
		"Subject: " +args[0]+
		"<br/><br/>"+
		"Books: "
		);	

	
		while (rset.next()){
			if(rset.getString("checkBook").equals("1")){
				
			System.out.println("<a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/BookDetails.cgi?isbn="+rset.getString("isbn")+"&customerId="+args[1]+"&customerName="+args[2]+"'>"+rset.getString("title")+"</a> &nbsp; &nbsp;");		
			}
		}//end while

		rset.close();
		stmt.close();
		System.out.print("<form method=\"post\" action=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/PurchaseBooks.cgi/?customerId="+args[1]+"&customerName="+args[2]+"\">"+"&nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Back to Search\"></form>");	


 
          /*  for (int i = 0; i< args.length-1; i++){
		query = query+" subjectid = "+args[i]+" or";
	
	    }

	    query = query + " subjectid = "+args[args.length-1]+") group by e.isbn, e.title order by count(*) desc";
	    System.out.println(query);


	    ResultSet rset =  stmt.executeQuery(query);
	  
	    System.out.print(
	       "<!DOCTYPE html>" +
	      "\n<html>\n"+
      		"\n<head>\n"+
         	   "\n<title>Subjects</title>\n"+
      	 	"\n</head>\n"+
      		"\n<body>\n"+
         	   "<h1>Books</h1>\n<br />");
	   System.out.print("\n<br/><form method =\"post\" action =\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/DeleteBooks.cgi\" target=\"view\">");


	    while(rset.next()){ 
		title = rset.getString("title");
		count = rset.getString("count(*)");
		isbn = rset.getString("isbn");
		
		System.out.println("<input type =\"checkbox\" name =\"books\" value = \""+isbn + "\"><a href='http://www.google.com'>"+title+"</a>&nbsp;&nbsp Number of matched subjects: "+count+
"<br/><br/><br/>");		




	    } //end while loop


	    System.out.print("<input type =\"submit\" name =\"act\"  value = \"DeleteBooks\">"+
"</form>\n");

           //System.out.println("</tr>");
	   System.out.print("</body>\n</html>");
                             
	    	
	   // System.out.println("</body>\n</html>");
	    
               
            rset.close();
            stmt.close();


	  */ 
         }
         catch( SQLException ex){
             System.out.println( ex);
         }

 	conn.close();



	}
}
