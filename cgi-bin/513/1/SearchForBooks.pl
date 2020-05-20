#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;

$act     = $query->param('act');
#$author  = $query->param('author');

if ( $act eq "SearchForBooks" ) {
	@subjectid = $query->param('subjects');

print("Content-type: text/html\n\n");

#@isbnArray = split(' ',$isbn);
#$isbn =join("@",@isbnArray);


$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom SearchForBooks ";


foreach $element(@subjectid){
	$cmd.=$element." ";	
}
#$cmd .= " $subjectid";
#$cmd .= " $price";



print("$cmd");
system($cmd);

}
elsif ( $act eq "Java source" ) {
    print ( "Content-type: text/plain\n\n" );
	system( "/bin/cat  DisplayAllSubjects.java" );

}
elsif ( $act eq "Perl source" ) {
    print ( "Content-type: text/plain\n\n" );

	system( "/bin/cat  SearchForBooks.pl" ); 
}	  
elsif ( $act eq "Perl source2" ) {
	print ( "Content-type: text/plain\n\n" );

	system( "/bin/cat DeleteBooks.pl" ); 
}
	
elsif ( $act eq "Java source2" ) {
	 print ( "Content-type: text/plain\n\n" );
  
	system( "/bin/cat SearchForBooks.java" ); 
}
elsif ( $act eq "Java source3" ) {  
print ( "Content-type: text/plain\n\n" );

	system( "/bin/cat DeleteBooks.java" ); 
}







