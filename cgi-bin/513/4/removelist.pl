#!/usr/bin/perl
#Geoffrey Stow, student ID 1188508, geoffrey.stow@ndus.edu, CSCI 260, Assignment 6, 12/6/19
use strict;
use CGI qw(:standard);
#This program removes a single entry from the list and then automatically redirects back to main page
#counter for a "did not remove" message
my $count=0;
print header(), start_html(-title=>"Remove from list"), "\n";
print "<h1><center>Remove from list<br><br></h1>\n";
print start_form(), "\n";
my $rem = param('txtRem');
print "<center>Item to remove: ", textfield(-name=>'txtRem', -size=>20), br, br, "\n";
#Make sure something was actually entered
if($rem eq ''){print "<center>You must enter an item to continue", br;}
else{
  #creates an array of every line from file, then deletes file and recreates sans removed line
  open (my $fh, "<", "todolist.txt");
  my @lines=<$fh>;
  unlink $fh;
  close $fh;
  open (my $fh2, ">", "todolist.txt");
  foreach my $line(@lines){
    print $fh2 $line unless ($line =~ $rem);
    if($line =~ $rem){
      print "<center>$rem was successfully removed\n", br;
      $count=1;
    }
  }
  close $fh2;
  if($count==0){
    print "<center>$rem could not be removed\n", br;
    print end_form(), "\n";
    print"<br><form action=\"/cgi-bin/mainpage.pl\" method=POST>\n",
      "<center><input type=\"submit\" value=\"Return to list\"></center></td>\n",
    "</form><br>\n"
  }
  else{
    print "<center>Returning to list...\n";
    print end_form(), "\n";
    print "<META HTTP-EQUIV=refresh CONTENT=\"1;URL=http://localhost/cgi-bin/mainpage.pl\">\n";
  }

}

print end_html();
