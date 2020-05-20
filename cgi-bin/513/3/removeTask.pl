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
   chomp($input=param('task'));
}

print header();
print start_html(-title=>'Remove task');

print "<table>";
my $removed=0;

if($input ne ''){
open(my $fh, "<", "tasks.txt");
open(my $temp, ">", "temp.txt");

while (chomp(my $task = <$fh>)){
	if ($task eq $input){
	$removed+=1;
	}

	else{
		print $temp ("$task\n");
	}	
}

close($temp, $fh);
open($temp, "<", "temp.txt");
open($fh, ">", "tasks.txt");

while (my $task = <$temp>){
	print $fh $task;
}

close($temp);
close($fh);
	if ($removed < 1){
		print Tr("Error: The task \"$input\" was not found.");
	}

	else{
		print Tr("Successfully removed $removed iterations of $input");
	}
}

else{
print Tr("Error: You did not choose a task to remove.");
}

print "</table>";

print start_form(-action=>"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/hw6.pl", -method=>"POST", -target=>"output");
print "<table>\n";
print Tr(td(submit(-name=>"back", -value=>'Back')));
print "</table>";
print end_form();

print end_html();
