import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class Books{

    public static void main(String[] args) throws SQLException
    {
	
            if( !(args.length>4))
            {
	    System.out.println("Not enough arugments");
        
	    }
            else
            {
	    System.out.println("JavaElse");
	    String user ="C##mark.arinaitwe";
	    String password ="arinaitwe9120";
	    String database="65.52.222.73:1521/cdb1";
            
            
	    //connect and open to the oracle database
	    OracleDataSource ods = new OracleDataSource();
	    ods.setURL ("jdbc:oracle:thin:@" + database );
	    ods.setUser (user);
	    ods.setPassword(password);
	   
	    Connection conn = ods.getConnection();
            System.out.println("WORKS??"); 
        try
        {
	    Statement stmt = conn.createStatement();
	    String query = "INSERT into booktest2 ( ISBN, title, Price) VALUES (\'" +args[0]+"\', \'"+args[1]+"\', \'"+args[2]+"\')" ;	    

           for (int i =0; i<args.length; i++)
	   {
	       System.out.println(args[i]);
	   }
	      
 	    System.out.println("<h3><em>" +query+ "</em>"); 
	    stmt.execute( query);
            stmt.close();
            System.out.println("Bye from Java");  
 	    String[] arrOfSubjects = args[4].split("-");
  

            for (int i = 0; i < arrOfSubjects.length; i++){
               
	        query = "SELECT subjectid from subjects2 where subject = '"+arrOfSubjects[i]+"'";
                System.out.println("<h3><em>" +query+ "</em>");
                Statement stmt1 = conn.createStatement();
                ResultSet rset =  stmt1.executeQuery(query);
                  
                System.out.println("<h3><em>" +query+ "</em>");
                boolean inTable = false;
                while (rset.next())
                {
                   Statement stmt2 = conn.createStatement();
                   inTable = true;
                   System.out.print(rset.getString(1));
                   query = "INSERT into book_subjects2 (isbn, subjectid) values('"+args[0]+"', '" +rset.getString(1)+"')";
                   System.out.println("<h3><em>" +query+ "</em>");
                   stmt2.execute(query);
                   System.out.print("Data already in table");
 		   System.out.print("<h3><em>" +rset.getString("subjectid")+"</em>");
                   stmt2.close();  
                }
                rset.close();
                stmt1.close();
	 	if (inTable ==false)
                {
                   Statement stmt3 = conn.createStatement();
                   query = "INSERT into subjects2(subject) values('"+arrOfSubjects[i]+"')";
                   System.out.println("<h3><em>" +query+ "</em>");
                   stmt3.execute(query);
                   //stmt1.close();
                   stmt3.close();

                   query = "SELECT subjectid from subjects2 where subject = '"+arrOfSubjects[i]+"'";
                   System.out.println("<h3><em>" +query+ "</em>");
                   Statement stmt4 = conn.createStatement();
                   rset =  stmt4.executeQuery(query);                   
                  // rset.next();
                   String subid=""; 
                   while (rset.next())
                   { 
                      subid = rset.getString(1);
                  
                      System.out.print("Data not yet in table");
                   }
                   query = "INSERT into book_subjects2 (isbn, subjectid) values('"+args[0]+"', " +Integer.parseInt(subid)+")";
                    stmt4.execute(query); 
                   System.out.println("<h3><em>" +query+ "</em>"); 
                    System.out.print("HELLO!!!!");
                   rset.close();
                   stmt4.close();
                         
                }
             //rset.close(); 
            }
	    	
	    System.out.println("</h3>");
	    
           	   // stmt.close();
               

         }
         catch( SQLException ex){
             System.out.println( ex);
         }

 	conn.close();
        	
      }
    }
}
