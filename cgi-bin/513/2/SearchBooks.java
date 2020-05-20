import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class SearchBooks{

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
	    String query = "select count(customer_name) from customers2 where customer_id ='"+args[1]+"'";
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
	"<form method=\"post\" action=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/CreateAccount.cgi\">"+
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
//	rset.close();
//	stmt.close();  


	stmt = conn.createStatement();
	query = "select customer_name, customer_id  from customers2 where customer_name ='"+args[0]+"'";

	rset = stmt.executeQuery(query);
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

	System.out.println("HHHHHHHHH"+args.length+"HHHHHHH"); 
        
	if(args.length == 2){
		System.out.print("Less than 3");
	


	stmt = conn.createStatement();
	query = "select b.title, b.isbn, b.price from books2 b";
	
	System.out.print("<br/>"+query+"<br/>");
	rset = stmt.executeQuery(query);
	



	String title ="";
	String isbn="";
	String price ="";
	while(rset.next()){ 
		title = rset.getString("title");
		isbn = rset.getString("isbn");
		price = rset.getString("price");
		System.out.println("<input type =\"checkbox\" name =\"books\" value = \""+isbn+":"+price+ "\"><a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/BookDetails.cgi?isbn="+isbn+"&customerName="+args[0]+"&customerId="+args[1]+"'>"+title+"</a>&nbsp;&nbsp Price: "+price+"&nbsp;&nbsp Quantity:<input type =\"text\" name =\""+isbn+":"+price+"\"/>"
+"<br/><br/><br/>");		

		}










	System.out.print("<tr>"+
  	" <td>"+
     	" <input type=\"submit\" name=\"act\" value=\"Purchase Books\"> &nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Back to Search\">&nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Perl Source\">&nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Java Source\">"+
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




	    String[] arrOfKeywords = args[2].split("\\.");
            //System.out.println(arrOfSubjects[1]);  
            //Integer len = args.length;      
            //System.out.println(args[2]); 
           
//	    	    System.out.println("Hello!!!!!!!!"+Integer.toString(arrOfKeywords.length)+" Hello!!!");
	    
	    boolean isNull = false;	
	    for (int i =0; i<arrOfKeywords.length; i++){

	    String testIfNull ="'"+arrOfKeywords[i]+"'"; 	
            if (testIfNull.equals("''")){
		System.out.print("IT is NULL!!!");
		i=arrOfKeywords.length;
		isNull = true;
		}
		
	    }	

	   if(isNull)	{	
	   System.out.print("Invalid subject entry");
	   }
	   
	   else{

	stmt = conn.createStatement();
	query = "select b.title, b.isbn, b.price,  count(*) from books2 b, table(b.subjectList) e where lower(e.subject_name) like lower('%" +arrOfKeywords[0]+"%')";
	
	for (int i=1; i<arrOfKeywords.length; i++){
		query = query+" or lower(e.subject_name) like lower('%"+arrOfKeywords[i]+"%')";
	}
	query = query +" group by isbn, title, price order by count(*) desc";

	System.out.print("<br/>"+query+"<br/>");
	rset = stmt.executeQuery(query);
	



	String title ="";
	String count="";
	String isbn="";
	String price ="";
	while(rset.next()){ 
		title = rset.getString("title");
		count = rset.getString("count(*)");
		isbn = rset.getString("isbn");
		price = rset.getString("price");
		System.out.println("<input type =\"checkbox\" name =\"books\" value = \""+isbn+":"+price+ "\"><a href='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/BookDetails.cgi?isbn="+isbn+"&customerId="+args[0]+"&customerName="+args[1]+"'>"+title+"</a>&nbsp;&nbsp Number of matched subjects: "+count+"&nbsp;&nbsp Price: "+price+"&nbsp;&nbsp Quantity:<input type =\"text\" name =\""+isbn+":"+price+"\"/>"
+"<br/><br/><br/>");		

		}

















       System.out.print("<tr>"+
  	" <td>"+
     	" <input type=\"submit\" name=\"act\" value=\"Purchase Books\"> &nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Back to Search\">&nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Perl Source\">&nbsp;&nbsp;<input type=\"submit\" name=\"act\" value=\"Java Source\">"+
   	"</td>"+
	"</tr>"+
	" </table><br />"+
	"</form>"+
	"</center>"+

	 "</body>"+
	"</html>");

	rset.close();
//	stmt.close();

		}
		}
	    }


	} 
	catch (SQLException ex){

	    System.out.println(ex);
	}
	conn.close();
	}
}

