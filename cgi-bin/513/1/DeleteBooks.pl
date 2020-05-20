#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;
@isbn = $query->param('books');

print("Content-type: text/html\n\n");

#@isbnArray = split(' ',$isbn);
#$isbn =join("@",@isbnArray);


$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom DeleteBooks ";


foreach $element(@isbn){
	$cmd.=$element." ";	
}
#$cmd .= " $subjectid";
#$cmd .= " $price";



print("$cmd");
system($cmd);


