#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;
$act     = $query->param('act');
#$author  = $query->param('author');
    

if ( $act eq "UpdatePrice" ) {
print ( "Content-type: text/html\n\n" );
	$isbn = $query->param('books');
	$price = $query->param($isbn);

	#@isbnArray = split(' ',$isbn);
	#$isbn =join("@",@isbnArray);


	$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom UpdatePrice";
	$cmd .= " $isbn";
	$cmd .= " $price";

	print("Content-type: text/html\n\n");

	print("$cmd");
	system($cmd);



}
elsif ( $act eq "Java source" ) {
print ( "Content-type: text/plain\n\n" );
	system( "/bin/cat  DisplayAllBooks.java" );

}
elsif ( $act eq "Perl source" ) {
print ( "Content-type: text/plain\n\n" );
	system( "/bin/cat  updatePrice.pl" ); 
	  

	
}
elsif ( $act eq "Java source2" ) {
	 
print ( "Content-type: text/plain\n\n" );
	system( "/bin/cat  UpdatePrice.java" ); 
}



