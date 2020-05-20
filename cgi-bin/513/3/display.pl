#!/usr/bin/perl
#Zak Hernandez
#zakari.hernandez@ndus.edu
#program number 6
#this is a few webpages and scripts syncing together to be able to remove and add items to a #todolist

use CGI qw(:standard);
use strict;

print "Content-type: text/html\n\n";
print "<html><head>\n";
print "<title>Test Title</title>\n";
print "</head>\n";
print "<body>\n";
open(my $in, "<", "todoList.txt") or die $!; 
while (<$in>){
     print $_;
     print "<br>";
}
close $in;
print "<br><tr><a href= \"http://undcemcs02.und.edu/~mark.arinaitwe/513/3/inputName.html\">main page</a></tr>\n";
print "</body></html>\n";
