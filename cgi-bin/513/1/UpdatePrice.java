import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;
class UpdatePrice{
	public static void main( String[] args)throws SQLException{

 	    String user ="C##mark.arinaitwe";
	    String password ="arinaitwe9120";
	    String database="65.52.222.73:1521/cdb1";
            String title= "null";  
	    String price = " ";        
            
	    //connect and open to the oracle database
	    OracleDataSource ods = new OracleDataSource();
	    ods.setURL ("jdbc:oracle:thin:@" + database );
	    ods.setUser (user);
	    ods.setPassword(password);
	   
	    Connection conn = ods.getConnection();
             
            try
            {

		if( args.length != 2){
			System.out.println("not enough args");
		}
		else{
	        	Statement stmt = conn.createStatement();
	       
	        	String query = "Update books1 set price = "+args[1]+" where isbn = '"+args[0]+"'";

            System.out.println("Content-type: text/plain\n\n");
            //System.out.println("<!DOCTYPE html>");
           // System.out.println("<html><head>\n</head>\n<body>");
            System.out.println("<h3><em>" +query+ "</em></h3>");
                
               		stmt.executeUpdate(query);
	      		stmt.close();
			System.out.println("Price Updated!!!");
               }                     

	    }  

	   catch( SQLException ex){
             System.out.println( ex);
         }
	conn.close();
	}
}
