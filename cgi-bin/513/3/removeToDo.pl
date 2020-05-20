#!/usr/bin/perl

use strict;
use warnings;
use LWP::Simple;
use CGI qw(:standard);


my $filename = "ToDo.txt";
my $toRemove = param('toRemove');
my $confirm = 0;

#no file, make new
#if (!$dbh) {
#   print header(), start_html(-title=>'Problems connecting with the database');
#   print "Unable to connect to the database", br;
#   print end_html();
#   exit;
#}


print header();
print start_html (-title=>"To Do List");

open(my $fh, "<", $filename) or die; 
    my @LINES = <$fh>; 
close($fh); 
open($fh, ">", $filename); 
    foreach my $LINE ( @LINES ) { 
	print $fh $LINE unless ($LINE =~ m/$toRemove/);
	if($LINE =~ m/$toRemove/){
		print ("$toRemove was removed from the list"); 
		$confirm = 1;
	}
    }
close($fh); 

if($confirm == 0){
	print"$toRemove was not found"
}
	print br;
	print a({-href=>"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/printList.pl"}, "To Do List");

print end_html();






