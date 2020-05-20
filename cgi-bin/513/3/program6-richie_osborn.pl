#!/usr/bin/perl

#Richie Osborn
#richard.osborn@und.edu
#12-6-19
#This program will show a to-do list to the user on a webpage. It will allow the user to add and remove items 
#from the to-do list. Trying to enter an empty item will return the user to the main page.
use strict;
use CGI ":standard";

my $result = open(FILE, "<todolist.txt");
if(!$result)
{
    open(FILE, ">todolist.txt");
}

my @todo = <FILE>;
chomp @todo;

close(FILE);

print header(), start_html(-title=>"To-Do List"), "\n";
print start_form (-action=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/program6-richie_osborn.pl'), "\n";
print "To-Do List: ", br, "\n";
foreach my $item(@todo)
{
    print $item, br, "\n";
}

print br, br, "\n";

if(param('btnAdd'))
{
    print "Add item: ", textfield(-name=>'txtAdd', -size=>20),"(leave blank to return to main page)", br, br, "\n";

    print submit(-name=>'btnBack', -value=>'Back'), "\n";
    print submit(-name=>'btnSubmit', -value=>'Submit'), "\n";
}
elsif(param('txtAdd'))
{
    my $add = param('txtAdd');
    print br, $add, " has been added to the list.", br, br, "\n";
    push(@todo, $add);
    open(FILE, ">todolist.txt");
    foreach my $item(@todo)
    {
        print FILE $item, "\n";
    }

    close(FILE);

    print submit(-name=>'btnBack', -value=>'Back'), "\n";
    print submit(-name=>'btnAdd', -value=>'Add More'), "\n";
}
elsif(param('btnRemove'))
{    
    print "Remove item: ", textfield(-name=>'txtRemove', -size=>20),"(leave blank to return to main page)", br, br, "\n";

    print submit(-name=>'btnBack', -value=>'Back'), "\n";
    print submit(-name=>'btnSubmit', -value=>'Submit'), "\n"
}
elsif(param('txtRemove'))
{
    my $remove = param('txtRemove');
    my $found = 0;

    open(FILE, ">todolist.txt");
    foreach my $item(@todo)
    {
        if($remove eq $item)
        {
            print br, $remove, " has been removed from the list.", br, br, "\n";
            $found = 1;
        }
        else
        {
            print FILE $item, "\n";
        }
    }
    close(FILE);

    if($found==0)
    {
        print br, $remove, " not found in to-do list.", br, br, "\n";
    }

    print submit(-name=>'btnBack', -value=>'Back'), "\n";
    print submit(-name=>'btnRemove', -value=>'Remove More'), "\n";
}
else
{
    print submit(-name=>'btnAdd', -value=>'Add Item'), "\n";

    print submit(-name=>'btnRemove', -value=>'Remove Item'), "\n";
}
close(FILE);
print end_form(), end_html();
