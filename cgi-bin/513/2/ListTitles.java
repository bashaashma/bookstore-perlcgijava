/*********************************************************************

  This program shows how to list the book titles in the
    inventory table.

  To use this program, you need to create a table
    inventory by using the following commands:

  SQL> create type  author_t  as object ( name  varchar(64) );
    2  /
  Type created.

  SQL> create type  authors_t  as varray(10) of  author_t;
    2  /
  Type created.

  SQL> create table  inventory (
    2    title     varchar(64)  not null,
    3    ISBN      char(12)     primary key,
    4    authors   authors_t    not null,
    5    price     number(5,2)  not null  check( price    >= 0.0 ),
    6    quantity  integer      not null  check( quantity >= 0 ) );
  Table created.

*******************************************************************/

// Import the following packages to use JDBC.
import  java.sql.*;
import  java.io.*;
import  oracle.jdbc.*;
import  oracle.jdbc.pool.OracleDataSource;

class  ListTitles {
    public static void  main( String args[ ] ) throws SQLException {
	String user     = "C##mark.arinaitwe";
	String password = "arinaitwe9120";
	String database = "65.52.222.73:1521/cdb1";
         
	// Open an OracleDataSource and get a connection.
	OracleDataSource ods = new OracleDataSource( );
	ods.setURL     ( "jdbc:oracle:thin:@" + database );
	ods.setUser    ( user );
	ods.setPassword( password );
	Connection conn = ods.getConnection( );

	try {
	    // Create, compose, and execute a statement.
	    Statement stmt = conn.createStatement( );
            String query = "select title, ISBN, price from books";
	   // String query = "select unique title from inventory i, table(i.authors) j where ";
	    //for ( int i=0;  i<args.length;  i++ ) {
	//	if ( i != 0 )  query += " or ";
	//	query += "j.name like '%" + args[i].trim( ) + "%'";
	  //  }
	   // System.out.println( "<h3><em>" + query + "</em>" );
	    ResultSet rset = stmt.executeQuery( query );

	    // Iterate through the result and print the data.
	    while ( rset.next( ) )
                System.out.print( "<font color='#3366CC'>" + rset.getString(1) + "</font>" );
            System.out.println("HI:II");  
	  //  System.out.println( "</h3>" );

	    // Close the ResultSet and Statement.
	    rset.close( );
	    stmt.close( );
	}
	catch ( SQLException ex ) {
	    System.out.println( ex );
	}
	// Close the Connection.
	conn.close( );
    }
}
