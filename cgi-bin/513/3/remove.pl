#!/usr/bin/perl

# pedro schmidt 
#pschmidt98@gmail.com or pedro.schmidt@und.edu
# csci260
#assignment 6

#!/usr/bin/perl

use strict;
use CGI qw(:standard);
use DBI;
sub remove
{
print header(),start_html(-title => "remove page"),"\n";
print scrolling_list(-name=>'todolist', -values=> ['make breakfast','do laundry','clean the dishes',
'study ',
'walk the dog',
'make the beds'],  -size=>8,-multiple=>'true',-default=>''),br;
print "remove page", textfield(-name => 'page3', -size=>20),br,br, "\n";
print submit(-name=> 'button', -value=> 'Remove Item'), "\n";
print submit(-name=> 'button', -values=> 'Main'), "\n";
if ( param('button') eq "Main")
{
print redirect("http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/ex.pl?page1=list&page3=&page2=&main=Submit+data");
 }
elsif (param('button') eq "Remove Item")
{ 
	my $filename = 'todolist.txt';
	open(my $file, '>', $filename) or die "could not open file";
	my @content = <$file>;

	foreach(@content)
    	{
      	print (-actions=> @content, br,br "\n" ); #print file 
      	@content = splice (@content,"\n", <STDIN>);      
      	print "updated list: @content\n";
      	}
	}
}
remove();
print end_form() , end_html();
