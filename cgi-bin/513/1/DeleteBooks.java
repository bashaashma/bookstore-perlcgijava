import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


public class DeleteBooks{

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


      
	    for (int i = 0; i< args.length; i++){
	
		Statement stmt = conn.createStatement();
	        String query = "select isbn, subjectid from book_subjects1 where isbn='"+args[i]+"'";
		
		ResultSet rset = stmt.executeQuery(query);

		while (rset.next()){

		    Statement stmt2 = conn.createStatement();
		    isbn = rset.getString("isbn");
		    subjectid = rset.getString("subjectid");
		    String query2 = "delete from book_subjects1 where isbn = '"+isbn+"' and subjectid = " +subjectid;
		    stmt2.executeUpdate(query2);
		    	
		    	

		    Statement stmt3 = conn.createStatement();
		    String query3 = "select count(*) from book_subjects1 where subjectid = " +subjectid;
		    ResultSet rset3 = stmt3.executeQuery(query3);
		    rset3.next();

		    count = rset3.getString("count(*)");
		    Integer countInt = Integer.parseInt(count);
		    System.out.println("HERE!!!!");
 
		    rset3.close();
		    stmt3.close();

		    if (countInt==0){
			stmt3 = conn.createStatement();
			query3 = "delete from subjects1 where subjectid = " + subjectid;
			stmt3.executeUpdate(query3);
		    }//end if
		    
		    	stmt3.close();



		}//end while loop

		//System.out.println(query+"    ");
		 Statement stmt3 = conn.createStatement();
	         String query3 = "delete from books1 where isbn = '" + args[i]+"'";
		 stmt3.executeUpdate(query3);
		 stmt3.close();
	
	    }







 
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
