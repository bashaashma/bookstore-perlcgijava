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
	print "No item removed, please select link to main page"
}
else{
  print "item $first was removed from the todo list, please go to main page";
  open(my $in, "<", "todoList.txt") or die $!;
  open(my $out, ">","outputFile.txt") or die $!; 
  while (<$in>){
       if($_!~/$first/){
         print $out  $_;
    }
 }
close $in;
close $out;
  open(my $in, "<", "outputFile.txt") or die $!;
  open(my $out, ">","todoList.txt") or die $!;
  while(<$in>){
   print $out $_;
  } 
close $in;
close $out;
}
print "<br><tr><a href= \"http://undcemcs02.und.edu/~mark.arinaitwe/513/3/inputName.html\">main page</a></tr>\n";
print "</body></html>\n";
