#!/usr/bin/perl
#Zak Hernandez
#zakari.hernandez@ndus.edu
#program number 6
#this is a few webpages and scripts syncing together to be able to remove and add items to a #todolist

use CGI qw(:standard);
use strict;

my $first = param('txtFirstVal');

print "Content-type: text/html\n\n";
print "<html><head>\n";
print "<title>Test Title</title>\n";
print "</head>\n";
print "<body>\n";
if(!$first){
	print "No item added, please select a link";
}
else{
  print "item $first added to the todo list";
  open (my $fh,'>>',"todoList.txt");
  print $fh "$first\n";
  close $fh; 
}
print "<br><tr><a href= \"http://undcemcs02.und.edu/~mark.arinaitwe/513/3/inputName.html\">main page</a></tr>\n";
print "<br><tr><a href= \"http://undcemcs02.und.edu/~mark.arinaitwe/513/3/addItemPage.html\">add item</a></tr>\n";
print "</body></html>\n";

