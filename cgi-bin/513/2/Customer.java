import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class Customer{

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
	    String query = "select count(customer_name) from customers2 where customer_name ='"+args[0]+"'";
	    System.out.print("<br/>"+query+"<br/>");
	    ResultSet rset = stmt.executeQuery(query);
	    rset.next();
	    if (rset.getString("count(customer_name)").equals("0"))
	    {
	System.out.print("<head>"+
  	"<title>Slide 2.6: HTML interface</title>"+
	" </head>"+
	"<center>"+
	"<br /><br />"+
	"<form method=\"post\" action=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/Register.cgi\">"+
 	"<table width=\"90%\" >"+
	"<tr>"+
   	"<td>Invalid User Name!</td>"+
	"</tr>"+	
	"<tr>"+
  	" <td>"+
     	" <input type=\"submit\" name=\"act\" value=\"CreateAccount\"> &nbsp;"+
   	"</td>"+
	"</tr>"+
	" </table><br />"+
	"</form>"+
	"</center>"+

	 "</body>"+
	"</html>");

	rset.close();
	stmt.close();
	}
	    else{	  
	rset.close();
	stmt.close();  


	stmt = conn.createStatement();
	query = "select customer_name, customer_id  from customers2 where customer_name ='"+args[0]+"'";

	rset = stmt.executeQuery(query);
	rset.next();
   
	System.out.print("<head>"+
  	"<title>Slide 2.6: HTML interface</title>"+
	" </head>"+
	"<center>"+
	"<br /><br />"+
	"<form method=\"post\" action=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/SearchBooks.cgi/?customerId="+rset.getString("customer_id")+"&customerName="+rset.getString("customer_name")+"\">"+
 	"<table width=\"90%\" >"+
	"<tr>"+
   	"<td>"+"<a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/CustomerDetails.cgi?customerId="+rset.getString("customer_id")+"&customerName="+rset.getString("customer_name")+"'>"+rset.getString("customer_name")+"</a>"+
	"'S ACCOUNT</td>"+
	"</tr>"+
	"<tr>"+
  	" <td>"+
	"Book Search: <input type=\"text\" name=\"keyWords\" size=\"20\" />"+
     	"<font size=\"0\"><br /><br /></font>"+
   	"</td>"+
	"</tr>"+
	"<tr>"+
  	" <td>"+
     	" <input type=\"submit\" name=\"act\" value=\"Search\"> &nbsp;"+
   	"</td>"+
	"</tr>"+
	"<tr>"+
  	" <td>"+
     	" <input type=\"submit\" name=\"act\" value=\"Log Out\"> &nbsp; <input type=\"submit\" name=\"act\" value=\"Java Source\"> &nbsp; <input type=\"submit\" name=\"act\" value=\"Perl Source\"> &nbsp;"+
   	"</td>"+
	"</tr>"+
	" </table><br />"+
	"</form>"+
	"</center>"+
	 "</body>"+
	"</html>");

	rset.close();
	stmt.close();
	    }


	} 
	catch (SQLException ex){

	    System.out.println(ex);
	}
	conn.close();
	}
}

