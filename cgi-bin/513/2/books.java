import java.sql.*;
import java.io.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

class Books{

    public static void main(String[] args) throws SQLException
    {
	

	if( !(args.length==4))
            {
	    for (int i= 0; i<=args.length;i++)
	    {
  		System.out.print(args[i]);
            }
	    System.out.println("Not enough arguments");
        
	    }//close if
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
           // System.out.println("WORKS??"); 
        try
        {
         
		
	    String[] arrOfSubjects = args[3].split("-");
            //System.out.println(arrOfSubjects[1]);  
            //Integer len = args.length;       
            System.out.println("Hello!!!!!!!!"+Integer.toString(arrOfSubjects.length)+" Hello!!!");
	    
	    boolean isNull = false;	
	    for (int i =0; i<arrOfSubjects.length; i++){

	    String testIfNull ="'"+arrOfSubjects[i]+"'"; 	
            if (testIfNull.equals("''")){
		System.out.print("IT is NULL!!!");
		i=arrOfSubjects.length;
		isNull = true;
		}
		
	    }	

	   if(isNull)	{	
	   System.out.print("Invalid subject entry");
	   }

	   else{

           //inserting books into books1
	   Statement stmt = conn.createStatement();
           String[] arrOftitle = args[1].split("@");
           String title = String.join(" ",arrOftitle);
	   String query = "INSERT into books2 VALUES (\'" +args[0]+"\', \'"+title+"\', "+args[2]+", list_of_subjects_t(" ;	    
          
	   for( int i =0; i<arrOfSubjects.length-1; i++){

	      query += "subject_t(\'"+arrOfSubjects[i]+"\'), ";
	   }
           query += "subject_t(\'"+arrOfSubjects[arrOfSubjects.length-1]+"\')))";

		
	   System.out.println(query);



	  /* boolean inTable = false;
           int num= 0;
           for (int i =0; i<args.length; i++)
	   {
	       System.out.println(args[i]);
               
	   }*/
	     
 	    //System.out.println("<h3><em>" +query+ "</em>"); 
	   stmt.executeUpdate( query);
          stmt.close();
             
               
 	    

	   //if (arrOfSubjects[0].equals(null))
	//	{System.out.print("IT is NULL!!!");}


	    //inserting into subjects1 and book_subjects1
         /*   for (int i = 0; i < arrOfSubjects.length; i++){
               
		//check whether subjects are already in subjects1
	        query = "SELECT count(*) from subjects1 where subject = '"+arrOfSubjects[i]+"'";
                //System.out.println("<h3><em>" +query+ "</em>");
                stmt = conn.createStatement();
                ResultSet rset =  stmt.executeQuery(query);
                 
		rset.next(); 
		num = rset.getInt(1);  
                //System.out.println("<h3><em>" +query+ "</em>");
                System.out.println(Integer.toString(num)); 
                rset.close();
		//insert if subject is not in subjects1
		if ( num ==0)
		{
                   query = "INSERT into subjects1 values(subject_id.nextval,'"+arrOfSubjects[i]+"')";
                   //System.out.println("<h3><em>" +query+ "</em>");
                   stmt = conn.createStatement(); 
		   //System.out.print(query);
		   stmt.executeUpdate(query);
	           stmt.close();  
               
		}//end if(num==1)

		query = "SELECT subjectid from subjects1 where subject = '"+arrOfSubjects[i]+"'";
                //System.out.println("<h3><em>" +query+ "</em>");
                stmt = conn.createStatement();
		   
                rset =  stmt.executeQuery(query);                   
                rset.next();
                 
		//inserting into book_subjects1
                query = "INSERT into book_subjects1 (isbn, subjectid) values('"+args[0]+"', '" +rset.getString(1)+"')";
                rset.close();
		stmt.close();
		stmt = conn.createStatement();
		   
                stmt.executeUpdate(query);                   
		stmt.close();

               
                /*
                 while (rset.next())
                {
                 
                   Statement stmt2 = conn.createStatement();
                   inTable = true;
                   System.out.print(rset.getString(1));
                   query = "INSERT into book_subjects1 (isbn, subjectid) values('"+args[0]+"', '" +rset.getString(1)+"')";
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
                   query = "INSERT into subjects1(subject) values('"+arrOfSubjects[i]+"')";
                   System.out.println("<h3><em>" +query+ "</em>");
                    
		    stmt3.execute(query);
                   
                  

                  //stmt1.close();
                   stmt3.close();
		   
                   query = "SELECT subjectid from subjects1 where subject = '"+arrOfSubjects[i]+"'";
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
                   
		  query = "INSERT into book_subjects1 (isbn, subjectid) values('"+args[0]+"', " +Integer.parseInt(subid)+")";
                    stmt4.execute(query); 
                 System.out.println("Select subId!!!!!!!!!!!!!!!!!!!!!!!");  
		  System.out.println("<h3><em>" +query+ "</em>"); 
                    System.out.print("HELLO!!!!");
                   rset.close();
                   stmt4.close();
                         
                }
             //rset.close(); 
            }//close for
	    	
	    System.out.println("</h3>");
	    
           	   // stmt.close();*/
            }   
         
         }//close try
         catch( SQLException ex){
             System.out.println( ex);
         }//close catch

 	conn.close();
        	
      }//close else
    }//close main
}//close class
