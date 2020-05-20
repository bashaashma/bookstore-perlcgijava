#!/usr/bin/perl

use CGI;
$query = new CGI;
$isbn = $query->param('isbn');
$title = $query->param('title');
$subjects = $query->param('subject');
$price = $query->param('price');

@subjects = split(';',$subjects);
$subjects = join("-",@subjects);
print("Content-type: text/html\n\n");
$numSubjects= scalar @subjects;
if ($isbn eq " ")
{
    print("Error no isbn<br>");   
}

$cmd="/usr/bin/java Books";
$cmd    =  "/usr/bin/java Books";
$cmd .= " $isbn"; 
$cmd .= " $title";
$cmd .= " $price";
$cmd .= " $numSubjects";
$cmd .= " $subjects";

my @subjects = split(',', $subjects);
foreach my $i (@subjects)
{
   $i=~ s/^\s+|\s+$//g;	
   print "$i<br>";
}
print("$isbn");
print("$title");
print("$subjects");
print("$price \n\n");

print("$cmd");
#$author =~ s/^\s*(\S*)\s*$/$1/;
system($cmd);
print("DONE WITH INSERT5");
