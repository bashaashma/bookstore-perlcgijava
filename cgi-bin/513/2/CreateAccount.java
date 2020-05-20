import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class CreateAccount{

	public static void main (String [] args)throws SQLException {

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
	       
	    String query = "insert into customers2 values (cust_id_seq.nextval,\'"+ args[0]+"\', account_t(list_of_purchased_books_t()))";
	    stmt.executeUpdate(query);
	    System.out.print(query);
	    stmt.close();




     	   System.out.print(
	"<!DOCTYPE html>\n"+
	"<html>\n"+
           "\n<head>\n"+
               "\n<title>Enter Book</title>\n"+
	   "\n</head>\n"+
	   "\n<body>\n"+
	      "<h1>Account Created!</h1>\n<br />\n"+
	      "<br/><form method =\"post\" action =\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/LogIn.cgi\">"+
	      "\n<table width=\"90%\" cellspacing =\"3\" cellpadding =\"10\" border=\"0\" class=\"shadow\"> \n"+
	      	"&nbsp;&nbsp;<input type =\"submit\" name =\"act\"  value = \"Return to Login\">"+
		"</form>\n"+
		"</body>\n"+
		"</html>"); 
	} 
	catch (SQLException ex){

	    System.out.println(ex);
	}
	conn.close();
	}
}

