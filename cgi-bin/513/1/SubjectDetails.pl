#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;
$subjectid = $query->url_param('subjectid');

print("Content-type: text/html\n\n");

#@isbnArray = split(' ',$isbn);
#$isbn =join("@",@isbnArray);


$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom SubjectDetails ";


$cmd .= " $subjectid";
#$cmd .= " $price";

#print("IBN is!!!".$isbn);

print("$cmd");
system($cmd);


