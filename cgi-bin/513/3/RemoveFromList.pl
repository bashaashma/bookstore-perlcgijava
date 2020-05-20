#!/usr/bin/perl

#Peter Simonson | CSCI 260 | HW6 |peter.t.simonson@und.edu
#Add to list Page of to do list program

use CGI qw(:standard);
use strict;

my $query = new CGI;

if($query->param('button')){
	print $query->redirect("http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/MainPage.pl/");
}

print $query->header();
print $query->start_html(-title=>"Remove from List");

print ("Remove From List",br,br,"\n");

my @ToDoList;

my $query = new CGI;

print $query->start_form();
print $query->textfield(-name=>'TEXT_FIELD',
	-default=>'',
	-size=>25,
	-maxlength=>40);
print $query->br;
print $query->submit(-name=>"button",-value=>'Remove Item From List');
print $query->end_form;

my $itemToRemove = $query->param('TEXT_FIELD');

#open file to read from
if(open(my $fileHandle, '<', "ToDo.txt")){
	my $item;
	my $lengthOfList;
	#put all list items into array
	while($item = <$fileHandle>){
		chomp($item);
		$lengthOfList = push(@ToDoList, $item);
	}
	
	close($fileHandle);
	
	if($itemToRemove){
	
		#see if the item to remove was in the list
		for(my $i = 0; $i < $lengthOfList; $i++){
			if($itemToRemove eq $ToDoList[$i]){
				print("Removed From List");
				#if found remove it
				splice(@ToDoList, $i, 1);
			}
		}
	
		#open the file to write to it. This will delete everything
		if(open(my $writeHandle, '>', "ToDo.txt")){
	
			#write everything to  the txt file
			foreach my $word (@ToDoList){
				print $writeHandle "$word\n";
			}	
			close($writeHandle);
		}
	}
	
}

else{
	print("Could not open ToDo.txt. Possibly need to chmod 777 ToDo.txt");
}



print end_html();
