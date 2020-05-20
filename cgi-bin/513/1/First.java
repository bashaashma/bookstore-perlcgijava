import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class First{

    public static void main(String[] args) throws SQLException
    {      
           
	System.out.print(
	"<!DOCTYPE html>\n"+
	"<html>\n"+
           "\n<head>\n"+
               "\n<title>Enter Book</title>\n"+
	   "\n</head>\n"+
	   "\n<body>\n"+
	      "<h1>Enter Book</h1>\n<br />\n"+
	      "<br/><form method =\"post\" action =\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/books.cgi\" target=\"view\">"+
	      "\n<table width=\"90%\" cellspacing =\"3\" cellpadding =\"10\" border=\"0\" class=\"shadow\"> \n"+
	      "<tr>\n"+
	         "<td> ISBN:</td>\n<td><input type=\"text\" name =\"isbn\"></td>\n "+
	      "</tr>\n"+
	      "<tr>\n"+
	         "<td> Title:</td> \n<td><input type=\"text\" name =\"title\"></td>\n"+
	      "</tr>\n"+
	      "<tr>\n"+
	         "<td> Price:</td>\n<td><input type=\"text\" name =\"price\"></td>\n"+
	      "</tr>"+
	      "\n<tr>\n"+
	        "<td>Subject(use semi-colons when inputing  multiple subjects):</td>\n<td><input type=\"text\" name=\"subject\"></td>\n"+
	      "</tr>\n"+
	         "</table>");




       	    
	    String user ="C##mark.arinaitwe";
	    String password ="arinaitwe9120";
	    String database="65.52.222.73:1521/cdb1";
            String sub= "null";          
            
	    //connect and open to the oracle database
	    OracleDataSource ods = new OracleDataSource();
	    ods.setURL ("jdbc:oracle:thin:@" + database );
	    ods.setUser (user);
	    ods.setPassword(password);
	   
	    Connection conn = ods.getConnection();
             
        try
        {
	    Statement stmt = conn.createStatement();
	       
	    String query = "SELECT subject from subjects1";

            //System.out.println("Content-type: text/plain\n\n");
            //System.out.println("<!DOCTYPE html>");
           // System.out.println("<html><head>\n</head>\n<body>");
            //System.out.println("<h3><em>" +query+ "</em></h3>");
                
            ResultSet rset =  stmt.executeQuery(query);
                  
           // System.out.println("<h3><em>" +query+ "</em></h3>");
            boolean inTable = false;
          //System.out.println("<br><tr>"); 
            while (rset.next())
            {
             sub=    rset.getString("subject");
             System.out.println("<input type =\"checkbox\" name = \"subjectList\" value = \""+sub + "\">"+sub+"&nbsp;&nbsp;");
             
            }
           //System.out.println("</tr>");
           System.out.print("<br><br><br><input type =\"submit\" name =\"act\"  value = \"Submit Book\">"+
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Java source\">"+
		"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Perl source\">"+
		"</form>\n"+
		"</body>\n"+
		"</html>");                   
	    	
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
