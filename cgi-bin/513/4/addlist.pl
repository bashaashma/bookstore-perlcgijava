#!/usr/bin/perl
#Geoffrey Stow, student ID 1188508, geoffrey.stow@ndus.edu, CSCI 260, Assignment 6, 12/6/19
use strict;
use CGI qw(:standard);

#this program displays a simple page as well and allows user to add items to the list, and then link back to main page
print header(), start_html(-title=>"Add to list"), "\n";
print "<h1><center>Add to list<br><br></h1>\n";
print start_form(), "\n";
my $add = param('txtAdd');
print "<center>Item to add: ", textfield(-name=>'txtAdd', -size=>20), br, br, "\n";

if($add eq ''){print "<center>You must enter an item to continue", br;}
else{
  print "<center>You added $add\n", br;
  open (fh, ">>", "todolist.txt");
  print fh $add, "\n";
  close fh;
  print end_form(), "\n";
  print"<br><form action=\"/cgi-bin/mainpage.pl\" method=POST>\n",
    "<center><input type=\"submit\" value=\"Return to list\"></center></td>\n",
  "</form><br>\n"
}

print end_html();
