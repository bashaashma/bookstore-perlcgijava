#!/usr/bin/perl

#use CGI; 
#$query   = new CGI;
#$act     = $query->param('act');
#$author  = $query->param('author');

#if ( $act eq "Run" ) {


use CGI qw(:standard);
use Data::Dumper qw(Dumper);

print "Content-type: text/html\n\n";
print "Hello World\n";


$firstRun = param() ? 0 : 1;
$one = param('todoGroup');

if ($one ne '') {
   
   #print redirect ("./index.cgi");
   #print "Content-type: text/html\n\n";
   #print $one;
   my $filename = 'data.txt';
	open(my $fh, '<:encoding(UTF-8)', $filename)
	or die "Could not open file '$filename' $!";
   my $i = 1;
   my @todos = ();
   while (my $row = <$fh>) {
	  chomp $row;
	  if ($i != $one){
		push (@todos, $row);
	  }
	  $i++;
	}
	close $fh;
	
	#print Dumper \@todos;
	#print "debug1\n";
	
	#open file repeat to overwrite
	open(my $fh, '>', $filename) or die "Could not open file '$filename' $!";
	#print "debug2\n";
	#write the new file disregarding the removed item
	foreach (@todos)
	{
		print $fh "$_\n"; # Print each entry in our array to the file
	}
	#print "debug3\n";
	close $fh;
	#print "debug4\n";
	print redirect ("http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/index.cgi");
	#print "debug5\n";
   exit;
}

print "Content-type: text/html\n\n";

print a({-href=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/index.cgi'}, 'Home');
print br();
print a({-href=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/add2.cgi'}, 'Add');
print br();
print a({-href=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/first.cgi'}, 'Remove');
print br();
print br();

my $filename = 'data.txt';
open(my $fh, '<:encoding(UTF-8)', $filename)
  or die "Could not open file '$filename' $!";
 
print start_form (-action=>'http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/first.cgi'), "\n"; 

my @todos = ();
my %labels;
my $i = 1;
 
while (my $row = <$fh>) {
  chomp $row;
  push (@todos, $i);
  $labels{$i} = $row;
  $i++;
  #push (@todos, $row);
  #$labels{$row} = 'red';
  # <input type="radio" name="gender" value="male" checked> Male<br>
  #print input({-type=>'radio', -name=>'todos', -value=>$row}, $row);
  #print "$row\n";
  #print br();
}

#$arrRef = \@todos;
print radio_group (-name=>'todoGroup', -values=>\@todos, -labels=>\%labels, -linebreak=>'true'), br, "\n";
#print Dumper \@todos;

print br();
print submit (-name=>'cmdRun', -value=>'Remove Item');
print end_form(), end_html();



#}
