#!/usr/bin/perl

use strict;
use warnings;
use LWP::Simple;
use CGI qw(:standard);


my $filename = "ToDo.txt";
my $toAdd = param('toAdd');

#no file, make new
#if (!$dbh) {
#   print header(), start_html(-title=>'Problems connecting with the database');
#   print "Unable to connect to the database", br;
#   print end_html();
#   exit;
#}


print header();
print start_html (-title=>"To Do List");

open(my $fh, ">>", $filename) or die;
print $fh $toAdd;
print $fh "\n";
close $fh;

print ("$toAdd was added to the list");

print br;
print a({-href=>"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/printList.pl"}, "To Do List");


print end_html();






