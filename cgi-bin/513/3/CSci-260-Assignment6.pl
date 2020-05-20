#!/usr/bin/perl

#Adrick Edinger
#CSci 260
#Assignment 6
#adrick.edinger@ndus.edu
#This program will display a to do list and allow the user to add and/or remove items from the list

use CGI qw(:standard);
use List::MoreUtils qw(first_index);
use strict;

my (@array, @i);

if (param('btnContinue')) {
	open(fh, '<', 'testOut.txt') or die $!;
	
	@array = <fh>;
}
else {
	open(fh, '<', "testInput.txt") or die $!;

	@array = <fh>;
}

print header(), start_html(-title=>"To-Do List");
print start_form(-action=>'/cgi-bin/addRemove.pl', -method=>'post');

print "<table border = 1>";
print Tr ( td ("To-Do List"));

foreach my $item (@array) {
	print Tr (td ($item));
}

print "</table>";

print br;
print submit (-name=>'btnAdd',  -value=>'Add Item'), "   ", submit (-name=>'btnRemove',  -value=>'Remove Item');

print end_form(), end_html();
