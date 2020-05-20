#!/usr/bin/perl

#David Hettich
#CSCI 260
#Assignment 6
#Run program by putting these two files in cgi-bin
#Make sure they have chmod 755
#Run localhost/cgi-bin/toDo.pl

use CGI qw(:standard);
use strict;
use warnings;

my $first = param('txtFirst');

print "Content-type: text/html\n\n";
print "<html><head>\n";
print "<title>To-Do List</title>\n";
print "</head>\n";
print "<body<form action=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/getSomething.pl\" method=GET>\n";
print "To-Do List:<br><br>";

if (defined($first))
{
	#need to chmod 755 whatever file apache is supposed to edit
	my $fname = 'data.txt';
	open (my $fd, '>>', $fname) or print "Couldn't open file: $!"; 
	
	print $fd "$first\n";
	
	close $fd || print "Close failed: $!";
}

my $filename = 'data.txt';
open(my $fh, '<', $filename)
  or print "Could not open file '$filename' $!";



while (my $row = <$fh>) 
{
  chomp $row;
  print "$row<br>";
}
close $fh;

print "<br><a href=\"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/getSomething.pl\" target=\"output\">Add To List</a><br>";
print "</form></body></html>\n";
