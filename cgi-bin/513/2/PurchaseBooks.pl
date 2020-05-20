#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;
$username = $query->url_param("customerName");
$customerId = $query->url_param("customerId");
$act     = $query->param('act');
#$author  = $query->param('author');
    
if ( $act eq "Purchase Books" ) {
	@isbn = $query->param('books');

print("Content-type: text/html\n\n");

#@isbnArray = split(' ',$isbn);
#$isbn =join("@",@isbnArray);


$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom PurchaseBooks ";



$cmd .= "'$customerId' ";

$cmd .= "'$username' ";
foreach $element(@isbn){
	$quantity = $query->param($element);
	$cmd.=$element.":".$quantity." ";	
}

print("$cmd");
system($cmd);

}
elsif ( $act eq "Back to Search" ) {
print("Content-type: text/html\n\n");
	$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom Customer ";
	$cmd .= "'$username' ";
	system($cmd);

}
elsif ( $act eq "Java Source" ) {
print ( "Content-type: text/plain\n\n" );

	system( "/bin/cat  SearchBooks.java" );
system( "/bin/cat  PurchaseBooks.java" );
}
elsif ( $act eq "Perl Source" ) {
print ( "Content-type: text/plain\n\n" );
system( "/bin/cat  PurchaseBooks.pl" );
	system( "/bin/cat  SearchBooks.pl" ); 
}	  
elsif ( $act eq "Perl source2" ) {
	
	system( "/bin/cat DeleteBooks.pl" ); 
}
	
elsif ( $act eq "Java source2" ) {
	   
	system( "/bin/cat SearchForBooks.java" ); 
}
elsif ( $act eq "Java source3" ) {  

	system( "/bin/cat DeleteBooks.java" ); 
}
