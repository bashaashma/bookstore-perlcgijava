import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


public class SearchForBooks{

	public static void main( String[] args) throws SQLException {


 	    String user ="C##mark.arinaitwe";
	    String password ="arinaitwe9120";
	    String database="65.52.222.73:1521/cdb1";
            //String title= "null";  
	    String title = " "; 
	    String count =" ";       
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
	       
	    String query = "select e.title, e.isbn, count(*) from books1 e, book_subjects1 f where e.isbn=f.isbn and (";
       
            for (int i = 0; i< args.length-1; i++){
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
		
		System.out.println("<input type =\"checkbox\" name =\"books\" value = \""+isbn + "\"><a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/BookDetails.cgi?isbn="+isbn+"'>"+title+"</a>&nbsp;&nbsp Number of matched subjects: "+count+
"<br/><br/><br/>");		




	    } //end while loop


	    System.out.print("<input type =\"submit\" name =\"act\"  value = \"DeleteBooks\">"+
"</form>\n");

           //System.out.println("</tr>");
	   System.out.print("</body>\n</html>");
                             
	    	
	   // System.out.println("</body>\n</html>");
	    
               
            rset.close();
            stmt.close();


	   /* Statement stmt = conn.createStatement();
	       
	    String query = "select unique isbn from book_subjects1 where";
       
            for (int i = 0; i< args.length; i++){
		query = query+" subjectid = "+args[i];
	
	    }
	    System.out.println(query);


	    ResultSet rset =  stmt.executeQuery(query);
	   
	    while(rset.next()){

		Statement stmt2 = conn.createStatement();
		String query2 = "select title from books1 where isbn ='"+rset.getString("isbn")+"'";
		ResultSet rset2 = stmt2.excuteQuery(query2);
		rset2.next();
		title = rset2.getString("title");
		rset2.close();
		stmt2.close();
		
		stmt2 = conn.createStatment();
		query2 ="select count(*) from book_subjects1 where isbn ='"+rset.getString("isbn")+"' and (";

		for (int i = 0; i< args.length; i++){
		    query = query+" subjectid = "+args[i];
	
	        }//end for loop 






	    } //end while loop





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
         	   "<h1>Books</h1>\n<br />");
	   System.out.print("\n<br/><form method =\"post\" action =\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/SearchForBooks.cgi\" target=\"view\">");

            while (rset.next())
            {
		            	//title=    rset.getString("title");
	     	subjectid = rset.getString("subjectid");
		subject = rset.getString("subject");
                System.out.println("<input type =\"checkbox\" name =\"subjects\" value = \""+subjectid + "\"><a href='http://www.google.com'>"+subject+"</a>&nbsp;&nbsp;"+
"<br/><br/><br/>");
		              
            }
	   System.out.print("<input type =\"submit\" name =\"act\"  value = \"SearchForBooks\">"+
"</form>\n");

           //System.out.println("</tr>");
	   System.out.print("</body>\n</html>");
                             
	    	
	   // System.out.println("</body>\n</html>");
	    
               
            rset.close();
            stmt.close();***/
         }
         catch( SQLException ex){
             System.out.println( ex);
         }

 	conn.close();



	}
}
