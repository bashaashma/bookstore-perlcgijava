#!/usr/bin/perl

use strict;
use warnings;
use CGI qw(:standard);

my $filename = "ToDo.txt";


print header();
print start_html (-title=>"To Do List");

print start_form (-action=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/addToDo.pl'), "\n";
	print "Add Item ", textfield (-name=>'toAdd', -size=>20), br, "\n";
	print br, "\n";
	print submit(-name=>'cmdRun', -value=>'Add'), "\n";
	print br br, "\n";
print end_form();

print start_form (-action=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/removeToDo.pl'), "\n";
	print "Remove Item ", textfield (-name=>'toRemove', -size=>20), br, "\n";
	print br, "\n";
	print submit(-name=>'cmdRun', -value=>'Remove'), "\n";
	print br br, "\n";
print end_form();

my $success = 1;
open(my $file, '<:encoding(UTF-8)', $filename) or die $success = 0;
	if ($success == 1)
	{
		print "Your To Do List:";
		print br;
		while (my $row = <$file>)
		{
			chomp $row;
			my $str = $row;
			print($row);
			print("<br>");
		}
	}
close $file;

print end_html();


