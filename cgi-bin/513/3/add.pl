#!/usr/bin/perl
#Michael Steien Assignment 6 form page
use strict;
use CGI qw(:standard);

my $add = param("Add");
my $remove = param("Remove");
chomp($add);
chomp($remove);
my $text=param('inputText');

if ($add eq "Add item"){
	open(my $fh, '>>', 'text.txt');
	print $fh "$text\n";
	close $fh;
}
elsif ($remove eq "Remove item"){
	my @array;
	my $index = 0;
	my $fh;
		open(my $fh, '<', 'text.txt'); 
		while(my $line = <$fh>){
		chomp($line);
			@array[$index] = $line;
			$index++;
	}
	close $fh;
my $fh;
open(my $fh, ">", "text.txt");
close $fh;
open(my $fh, ">>", "text.txt");
my $len = @array;
for(my $x = 0; $x<$len;$x++){
	if(@array[$x] ne $text){
	print $fh "@array[$x]\n";
}
}
close $fh;
}
print redirect("http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/3/list.pl");
exit;
