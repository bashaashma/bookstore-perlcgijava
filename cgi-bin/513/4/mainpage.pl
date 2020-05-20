#!/usr/bin/perl
#Geoffrey Stow, student ID 1188508, geoffrey.stow@ndus.edu, CSCI 260, Assignment 6, 12/6/19
use strict;
use CGI qw(:standard);
print ( "Content-type: text/html\n\n" );

#This is the main page, simply prints the list and creates html buttons to add/remove pages
#All programs were designed to work within cgi-bin all together
print header(), start_html(-title=>"To-do list"), "\n";
print "<h1><center>To-do list<br><br></h1>\n";

open (datafile, '<', "todolist.txt");
while(my $row = <datafile>){
  print "<center>$row<br>\n";
}
close(datafile);

#Big print statement to make buttons
print"<br><form action=\"/cgi-bin/addlist.pl\" method=POST>\n",
  "<center><input type=\"submit\" value=\"Add to list\"></center></td>\n",
"</form><br>\n",
"<form action=\"/cgi-bin/removelist.pl\" method=POST>\n",
  "<center><input type=\"submit\" value=\"Remove from list\"></center></td>\n",
"</form><br>\n";
print end_form(), end_html();
