#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;

$act     = $query->param('act');
#$author  = $query->param('author');
    


if ( $act eq "Java source" ) {
print ( "Content-type: text/plain\n\n" );
	system( "/bin/cat  ResetSystem.java" );

}
elsif ( $act eq "Perl source" ) {
print ( "Content-type: text/plain\n\n" );
	system( "/bin/cat  ResetSystem.pl" ); 
}	  








