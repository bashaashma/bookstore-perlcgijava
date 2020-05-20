#!/usr/bin/perl

#Peter Simonson | CSCI 260 | HW6 |peter.t.simonson@und.edu
#Add to list Page of to do list program

use CGI qw(:standard);
use strict;

my $query = new CGI;

if($query->param('button') && $query->param('TEXT_FIELD')){
	print $query->redirect("http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/MainPage.pl/");
}

print $query->header();
print $query->start_html(-title=>"Add To List");

print ("Add To List",br,br,"\n");

print $query->start_form();
print $query->textfield(-name=>'TEXT_FIELD',
	-default=>'',
	-size=>25,
	-maxlength=>40);
print $query->br;
print $query->submit(-name=>"button",-value=>'Submit Item To List');
print $query->end_form;


my $toDoItem = $query->param('TEXT_FIELD');
if($toDoItem){

	if($query->param){
		print(br,"Sent item to the list\n", br, br);
	}

	#I did a chmod 777 ToDo.txt. Seemed to make this work. 
	#Not sure if  chmod causes this to break on your machine
	if(open(my $fileHandle, '>>', "ToDo.txt")){	
		print $fileHandle "$toDoItem\n";
		close($fileHandle);
	}

	else{
		print("Could not open ToDo.txt. Possibly need to chmod 777 ToDo.txt");
	}
}

else{
	print(br, "You Cannot submit a blank item\n", br);
}
print end_html();
