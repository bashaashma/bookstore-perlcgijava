#!/usr/bin/perl

use CGI qw(:standard);

print header();
print start_html(-title=>'To-do list');
print "<h1> TO-DO </h1>\n";

print "<body>\n";
my $filename = "tasks.txt";
open(my $fh, '<', "tasks.txt")
or die "ERROR: Could not open file: $!";
print "<table>\n";
while (my $row = <$fh>){
  chomp($row);
  print "<tr>", td($row), "</tr>\n";
}
print "</table>\n";

print "</body>";
print start_form(-action=>"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/addTask.pl", -method=>POST, -target=>output);
print "<table>\n";
print "<tr>", td("Name of task:"), td(textfield(-name=>'task', -size=>20)), "</tr>";
print Tr(td(submit(-name=>"Add Task", -action=>"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/addTask.pl" -value=>'Add task')));
print "</table>";
print end_form();

print start_form(-action=>"http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/removeTask.pl", -method=>POST, -target=>output);
print "<table>\n";
print Tr (td("Name of task:"), td(textfield(-name=>'task', -size=>20)));
print Tr(td(submit(-name=>removeTask, -value=>'Remove task')));
print "</table>";
print end_form();


print end_form();
print end_html();
