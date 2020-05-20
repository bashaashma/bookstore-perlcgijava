#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);
$query = new CGI;
$act     = $query->param('act');
#$author  = $query->param('author');
    

if ( $act eq "Submit Book" ) {
	print ( "Content-type: text/html\n\n" );
	$isbn = $query->param('isbn');
	$title = $query->param('title');
	$subjects = $query->param('subject');
	$price = $query->param('price');
	#@titleArray = split(' ',$title);
	#$title =join("@",@titleArray);

	@subjectList = $query->param('subjectList');

	@subjectsDup = split(';',$subjects);
	foreach my $element (@subjectsDup){
		$element =~ s/^\s+|\s+$//g;
		#@elementArray = split(' ',$element);
		#$element = join("@",@elementArray); 
	}

	my @subjectsDup2 = grep(s/\s*$//g, @subjectsDup);

	push(@subjectsDup,@subjectList);
	print("Content-type: text/html\n\n");
	#print("@subjectsDup2");
	my %seen = ();

	my @subjects = grep { ! $seen{ $_}++ } @subjectsDup;

	$subjects = join("-",@subjects);

	print("@subjects");

	$numSubjects= scalar @subjects;
	if ($isbn eq " ")
	{
    	print("Error no isbn<br>");   
	}


	$cmd    =  "/usr/bin/java -Djava.security.egd=file:/dev/./urandom Books ";
	$cmd .= "'".$isbn."' "; 
	$cmd .= "'".$title."' ";
	$cmd .= " $price ";
	#$cmd .= " $numSubjects";
	$cmd .= "'".$subjects."' ";

	#my @subjects = split(',', $subjects);
	#foreach my $i (@subjects)
	#{
  	# $i=~ s/^\s+|\s+$//g;	
 	#  print "$i<br>";
	#}
	#print("$isbn");
	#print("$title");
	#print("$subjects");
	#print("$price \n\n");

	print("<br>$cmd");
	#$author =~ s/^\s*(\S*)\s*$/$1/;
	system($cmd);
	print("<br>DONE  WITH INSERT");
    

}
elsif ( $act eq "Java source" ) {
   # print ( "Content-type: text/html\n\n" );
 	print ( "Content-type: text/plain\n\n" );   
system( "/bin/cat  books.java" );


    
}
elsif ( $act eq "Perl source" ) {
   # print ( "Content-type: text/html\n\n" );
 	print ( "Content-type: text/plain\n\n" );
   system( "/bin/cat  books.pl" );


    
}














