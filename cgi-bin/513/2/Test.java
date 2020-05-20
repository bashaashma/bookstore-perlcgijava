import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class Test{

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
	       
	/*    CallableStatement cstmt = conn.prepareCall("{?= call raiseal (?, ?)}");
	    cstmt.registerOutParameter(1,Types.INTEGER);
	    cstmt.setString(2, "LESLIE");
	    int raise = new Integer( args[0].trim()).intValue();
	    cstmt.setInt(3, raise);
	    cstmt.execute();
	    int new_salary = cstmt.getInt(1);
	    System.out.print("The new salary is <i>" + new_salary + "</i>");

	    cstmt.close();*/
		
	    ResultSet rset = stmt.executeQuery("select b.price, b.price - b.get_discount() from books b where author ='Kevin Loney'");
	    rset.next();
	    String test = rset.getString(2);
	    System.out.println(test);
	    rset.close();



	} 
	catch (SQLException ex){

	    System.out.println(ex);
	}
	conn.close();
	}
}
