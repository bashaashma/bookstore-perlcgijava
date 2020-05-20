#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;
$subjectName = $query->url_param('subjectName');
$customerId = $query->url_param('customerId');
$customerName = $query->url_param('customerName');
print("Content-type: text/html\n\n");

#@isbnArray = split(' ',$isbn);
#$isbn =join("@",@isbnArray);


$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom SubjectDetails ";


$cmd .= "'". $subjectName."' ";
$cmd .= "'". $customerId."' ";
$cmd .= "'". $customerName."' ";



#$cmd .= " $price";

#print("IBN is!!!".$isbn);

print("$cmd");
system($cmd);


