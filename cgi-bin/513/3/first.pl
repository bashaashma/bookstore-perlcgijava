#!/usr/bin/perl

#use CGI; 
#$query   = new CGI;
#$act     = $query->param('act');
#$author  = $query->param('author');

#if ( $act eq "Run" ) {


print "Content-type: text/html\n\n";
print "Hello World\n";
#}
#
use CGI qw(:standard);
use List::MoreUtils qw(first_index);
use strict;

my (@array, @i);

#if (param('btnContinue')) {
#	open(fh, '<', 'testOut.txt') or die $!;
	
#	@array = <fh>;
#}
