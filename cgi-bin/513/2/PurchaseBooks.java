import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class PurchaseBooks{

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
	String query = "select customer_name, customer_id  from customers2 where customer_name ='"+args[1]+"'";

	ResultSet rset = stmt.executeQuery(query);
	rset.next();
   
	System.out.print("<head>"+
  	"<title>Slide 2.6: HTML interface</title>"+
	" </head>"+
	"<center>"+
	"<br /><br />"+
	"<form method=\"post\" action=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/PurchaseBooks.cgi/?customerId="+rset.getString("customer_id")+"&customerName="+rset.getString("customer_name")+"\">"+
 	"<table width=\"90%\" >"+
	"<tr>"+
   	"<td>"+
	rset.getString("customer_name")+
	"'S ACCOUNT</td>"+
	"</tr>"+
	"<tr>"+
  	" <td>"+
	"RESULTS"+
     	"<font size=\"0\"><br /><br /></font>"+
   	"</td>"+
	"</tr>");
	rset.close();
	stmt.close();
 
	boolean CorrectInput = true;
	for (int i = 2; i< args.length; i++){
		String[] checkInput = args[i].split(":");
		if (checkInput.length <3){
		CorrectInput = false;
		}
	}
	if(args.length==2)
	{
		System.out.print("</br>No books chosen</br>");

	}
	else if(CorrectInput==false)
	{
		System.out.print("</br>No quantities chosen</br>");

	} 
	else{     
	    for (int i = 2; i< args.length; i++){
		String[] iq = args[i].split(":");
	        stmt = conn.createStatement();
		query = "select e.customer_account.bookInside('";
		query+=iq[0]+"') as ISIN from customers2 e where e.customer_id ="+args[0];	
		

		rset = stmt.executeQuery(query);
		//System.out.print("</br>"+query+"</br>");
		rset.next();
		String isIn =rset.getString("ISIN");
		//System.out.print(isIn);
		rset.close();
		stmt.close();
		if (isIn.equals("0"))
		{
		query ="update customers2 e set e.customer_account.list_of_purchased_books = e.customer_account.list_of_purchased_books multiset union all list_of_purchased_books_t(purchased_books_t('"+iq[0]+"',"+iq[2]+","+iq[1]+")) where e.customer_id ="+args[0];
		stmt = conn.createStatement();
		stmt.executeUpdate(query);	
		System.out.print("</br>"+query+"</br>");
		stmt.close();
		}
		//rset.close();
		else{
		query = "select e.quantity from table(select c.customer_account.list_of_purchased_books from customers2 c where customer_id="+args[0]+") e where e.isbn = '"+iq[0]+"'";
		stmt = conn.createStatement();
		rset =stmt.executeQuery(query);

		rset.next();
		Integer quantity = 0;
		quantity = Integer.parseInt(rset.getString("quantity"));
		quantity +=Integer.parseInt(iq[2]);
	System.out.print("</br>quantity:"+quantity+"</br>");		
		//System.out.print("</br>"+query+"</br>");
		rset.close();
		stmt.close();

		stmt = conn.createStatement();
		query = "update table(select c.customer_account.list_of_purchased_books from customers2 c where customer_id ="+args[0]+") e set e.quantity ="+quantity+" where isbn ='"+iq[0]+"'";
		stmt.executeUpdate(query);
		//System.out.print("</br>"+query+"</br>");
		stmt.close();	
		}	
	
	    }
	}
	System.out.print("<tr>"+
  	" <td>"+
     	"&nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Back to Search\">"+
   	"</td>"+
	"</tr>"+
	" </table><br />"+
	"</form>"+
	"</center>"+

	 "</body>"+
	"</html>");
	

	} 
	catch (SQLException ex){

	    System.out.println(ex);
	}
	conn.close();
	}
}
