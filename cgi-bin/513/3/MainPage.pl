#!/usr/bin/perl

#Peter Simonson | CSCI 260 | HW6 |peter.t.simonson@und.edu
#Main Page of to do list program

use CGI qw(:standard);
use strict;

my $toDoItem;
my $query = new CGI;

if ( $query->param('button') && $query->param('button') eq "Add" ){
	print $query->redirect("http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/AddToList.pl/");
}
elsif($query->param('button') && $query->param('button') eq "Remove"){
	print $query->redirect("http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/RemoveFromList.pl/");
}

print $query->header();
print $query->start_html(-title=>"To Do List");

print("To Do List",br,br,"\n");

if(open(my $fileHandle, '<', "ToDo.txt")){
	
	my $numberOfTasks = 0;
	while($toDoItem = <$fileHandle>){
		$numberOfTasks++;
		
		chomp($toDoItem);
		print($numberOfTasks,": ",$toDoItem, br, "\n");
	}
	
	close($fileHandle);
}

else{
	print ("Could not open to do list text file", br, "\n");
}

print(br);

print $query->start_form;
print $query->submit(-name=>'button', -value=>'Add');
print $query->submit(-name=>'button', -value=>'Remove');
print $query->end_form;

print end_html();
