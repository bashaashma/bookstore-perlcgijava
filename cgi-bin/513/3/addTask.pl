#!/usr/bin/perl

use strict;
use CGI qw(:standard);

my $input;

if (-t)
{
   $input="TESTING";
}

else
{
   $input=param('task');
}

print header();
print start_html(-title=>'Add task');
if($input ne ''){
open(my $fh, ">>", "tasks.txt");
print $fh "$input\n";
print "The task $input has been added!";
}
else{
print "Error: You did not choose a task to add.";
}

print start_form(-action=>"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/hw6.pl", -method=>"POST", -target=>"output");
print "<table>\n";
print Tr(td(submit(-name=>"back", -value=>'Back')));
print "</table>";
print end_form();
print end_html();
