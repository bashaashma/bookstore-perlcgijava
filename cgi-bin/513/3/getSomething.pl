#!/usr/bin/perl

#David Hettich
#CSCI 260
#Assignment 6

use strict;
use warnings;
use CGI qw(:standard);

print "Content-type: text/html\n\n";
print "<html><head><form action=\"/cgi-bin/toDo.pl\" method=POST>\n";
print "<title>Add To List</title>\n";
print "</head>\n";
print "<body>\n";
print "Please type something to add to the list.<br><br>";
print "<input type=text size=20 name=txtFirst maxlength = 25>";
print"<input type=submit>";
print "</body></html>\n";
