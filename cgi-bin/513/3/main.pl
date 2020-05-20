#!/usr/bin/perl

#Daniel Baurceanu
#daniel.baurceanu@und.edu
#program number 6
#Program number 6 displays a todo list and allows the user to add/remove items from it
#the list is stored in the form of a text file and the program is used in a web browser
#through the common gateway interface


use CGI qw(:standard);
use strict;
use warnings;

print "Content-type: text/html\n\n";
print "<html>\n";
    print "<head>\n";
        print "<title>\n";
            print "To-do list\n";
        print "</title>\n";
    print "</head>\n";
    print "<body>\n";
print "<form action=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/addorremove.pl\" method=POST>\n";
print "<br><br>\n";

print "<p>\n";
  open(FH, "todo.txt") or  print "error couldn't open the list"; 

while(my $row=<FH>){
    chomp $row;
    print "$row";
    print "<br>\n";
}
print "</p>";
print "<tr>\n";

   print "<td>remove an item:</td>\n";
   print "<td><input type=text size=20 name=txtRemove maxlength = 100 value=\"\" ></td>\n";
print "</tr>\n";
print "<td><center><input name=removething  type=\"submit\" value=\"remove\"></center></td>\n";
print "<tr>\n";
   print "<td>add another item:</td>\n";
   print "<td><input type=text size=20 name=txtAdd maxlength = 100 value=\"\" ></td>\n";
print "</tr>\n";
print "<td><center><input name=addthing  type=\"submit\" value=\"add\"></center></td>\n";
    print "</body>\n";
print "</html>\n";
