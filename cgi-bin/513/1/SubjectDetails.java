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
	        String query = "select subject from subjects1 where subjectid= "+args[0];
		
		ResultSet rset = stmt.executeQuery(query);

		rset.next();
		System.out.print(
	       "<!DOCTYPE html>" +
	      "\n<html>\n"+
      		"\n<head>\n"+
         	   "\n<title>SubjectDetails</title>\n"+
      	 	"\n</head>\n"+
      		"\n<body>\n"+
         	   "<h1>Subject Details</h1>\n<br />");
		System.out.print(
		"Subject: " +rset.getString("subject")+
		"<br/><br/>"+
		"Books: "
		);	

		rset.close();
		stmt.close();
		
		stmt = conn.createStatement();
		query = "select isbn from book_subjects1 where subjectid= "+args[0];
	 	rset = stmt.executeQuery(query);

		while (rset.next()){

			Statement stmt2 = conn.createStatement();
			String query2 = "select title from books1 where isbn = '"+rset.getString("isbn")+"'";
			ResultSet rset2 = stmt2.executeQuery(query2);
			rset2.next();	
			System.out.println("<a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/BookDetails.cgi?isbn="+rset.getString("isbn")+"'>"+rset2.getString("title")+"</a> &nbsp; &nbsp;");		
			stmt2.close();
			rset2.close();
		}//end while

		rset.close();
		stmt.close();

 
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
