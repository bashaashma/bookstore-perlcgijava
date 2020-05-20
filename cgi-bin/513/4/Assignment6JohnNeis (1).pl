#!/usr/bin/perl

# John Neis, ID: 8003486
# j.neis@und.edu
# Program 6: This program uses CGI in order to create a webpage which handles the display
# of a to-do list. All functionality is handled in a single script.
use CGI qw(:standard);
use strict;

sub regularPage {
    my $flag = shift;
    # All this does is create the textfile if it doesn't exist.
    # This way the associated textfile is always attached to 
    # the script.
    if(!open(TODO, ">>todolist.txt")) {
        system("chmod 644 todolist.txt");
        open(TODO, ">>todolist.txt");
        close(TODO);
    } else {
        close(TODO);
    }

    print header();
    print start_html(-title=>"To-do List", -BGCOLOR=>"#DDDDDD");
    open(TODO, "todolist.txt") or die("Unable to open file.\n");

    print "Current to-do list:", br, "\n";
    print "<table border=1>\n";
    while(chomp(my $input = <TODO>)) {
        print "<tr><td width=300><center>$input</center></td></tr>\n";
    }
    print "</table>", br, br, "\n";
    close(TODO);

    print "<form action=/cgi-bin/Assignment6JohnNeis.pl method=POST>", "\n";
    print "<table>", "\n";
    print "<tr><td colspan=2>Please enter to-do list item</td></tr>", "\n";
    print "<tr><td colspan=2><input type=text name=txtItem></td></tr>", "\n";
    print "<tr><td><input type=submit value=Add name=btnAdd></td>", "\n",
          "<td align=right><input type=submit value=Remove name=btnRem></td></tr>", "\n",
          "</table>", "\n";
    print "</form>", br, "\n";
    if($flag) {
        if($flag eq "f") {
            print "<font color=red>You must enter text to add or remove</font>", "\n";
        } elsif($flag eq "a") {
            print "Item added successfully", "\n";
        } elsif($flag eq "r") {
            print "Item removed successfully", "\n";
        }
    }

    print end_html();
}

if(param()) {
    if(param("btnAdd")) {
        
        my $todoItem = param("txtItem");
        if($todoItem eq "") {
            print redirect("http:/cgi-bin/Assignment6JohnNeis.pl?flState=1");
            exit;
        }
        open(TODO, ">>todolist.txt") or die("Unable to open file.\n");
        print TODO $todoItem, "\n";
        close(TODO);
        print redirect("http:/cgi-bin/Assignment6JohnNeis.pl?addState=1");

    } elsif(param("btnRem")) {

        my $todoItem = param("txtItem");
        if($todoItem eq "") {
            print redirect("http:/cgi-bin/Assignment6JohnNeis.pl?flState=1");
            exit;
        }
        open(TODO, "todolist.txt") or die("Unable to open file.\n");
        my @listItems = <TODO>;
        close(TODO);

        open(TODO, ">todolist.txt") or die("Unable to open file.\n");
        foreach my $item (@listItems) {
            if($item ne $todoItem . "\n") {
                print TODO $item;
            } else {
                next;
            }
        }
        close(TODO);
        print redirect("http:/cgi-bin/Assignment6JohnNeis.pl?remState=1");
    } elsif(param("flState")) {
        regularPage("f");
    } elsif(param("addState")) {
        regularPage("a");
    } elsif(param("remState")) {
        regularPage("r");
    }
} else {
    regularPage();
}

