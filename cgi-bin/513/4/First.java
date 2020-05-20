import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class First{

    public static void main(String[] args) throws SQLException
    {
	
         
            
             	    
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
	       
	    String query = "SELECT subject from subjects2";

            //System.out.println("Content-type: text/plain\n\n");
            //System.out.println("<!DOCTYPE html>");
           // System.out.println("<html><head>\n</head>\n<body>");
            System.out.println("<h3><em>" +query+ "</em></h3>");
                
            ResultSet rset =  stmt.executeQuery(query);
                  
            System.out.println("<h3><em>" +query+ "</em></h3>");
            boolean inTable = false;
            while (rset.next())
            {
             sub=    rset.getString("subject");
             System.out.println("<h3><em>" +sub+ "</em></h3>");
            }
                
	    	
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
