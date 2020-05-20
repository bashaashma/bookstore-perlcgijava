#!/usr/bin/perl
# Travis Dean - 1077179
# tdean4839@gmail.com
# Assignment 6
# This program will build a webpage using the to-do list stored in the same folder.
# It adds buttons and a textbox that will be used to direct the user to another page.

use strict;
use CGI qw(:standard);

my @listItems;
my $line;
my $count;
my $item;
my $message;

open (INFILE, "list.txt");
while (chomp($line = <INFILE>)) {
	unshift(@listItems, $line); # Getting all of the items.
}
close INFILE;

print header(), start_html(-title=>'To-Do List'); # Starting our webpage.

print "<h1><font face='arial'>Your To-Do List</h1>\n";

if ($message = param('badMessage')) { # if there's a bad message, it'll show here in red.
print "<font color='red'>$message</font><br />\n";
}

if ($message = param('goodMessage')) { # if there's a good message, it'll show here in green.
print "<font color='green'>$message</font><br />\n";
}

print "<table border=1>\n"; # holding our items in a table.

if (scalar(@listItems) == 0) { # if our list is empty, tell the user.
   print "<tr><td colspan=2>Your list is empty. Add an item to start.</td></tr>";
}

while ($item = shift @listItems) { # Do this for every item in the array.
	print "<form action='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/changeItem.pl' method=post>"; # Using a different form for each button. Makes the next page's job easier.
	print "<tr><td>$item</td><td align='center'><input type='submit' name='btnRemove' value='Remove' /></td></tr>\n";
	print "<input type='hidden' name='itemToRemove' value='$item' />\n"; # Using a hidden item as a flag to the next page.
	print "</form>";
}

print "<form action='http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/changeItem.pl' method=post>"; # New form for the textbox at the bottom of the table.
print "<tr><td><input type='text' name='itemToAdd' autofocus/></td>"; # This is where items are added. autofocus to make testing/adding a lot of items easier.
print "<td><input type='submit' name='btnAdd' value='Add Item' /></td></tr>"; # activates the next page.
print "</form>";
print "</table></font>";
print end_html();
