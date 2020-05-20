#!/usr/bin/perl
#Michael Steien Assignment 6
use strict;
use CGI qw(:standard);

open(my $fh, "<", "text.txt");

print header(), start_html(-title=>'List');

print start_form(-action=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/add.pl',
		 -method=>'POST',
 		 -target=>'output');

print "<table border = 1>";

print "To do List:";

while (my $line = <$fh>){
	chomp $line;
	print Tr(td($line));
}
close $fh;

print "<tr>", td(textfield(-name=>"inputText", -size=>20)),"</tr>";

print Tr (td(submit(-name=>"Add", -value=>"Add item")),
	td(submit(-name=>"Remove", -value=>"Remove item")));

print "</table>\n";
print end_form(), end_html();
