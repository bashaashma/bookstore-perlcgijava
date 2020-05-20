#!/usr/bin/perl

use CGI;
#use List::MoreUtils qw(uniq);

$query = new CGI;

$act     = $query->param('act');
#$author  = $query->param('author');
    print ( "Content-type: text/html\n\n" );


if ( $act eq "Java source" ) {
	system( "/bin/cat  ResetSystem.java" );

}
elsif ( $act eq "Perl source" ) {
	system( "/bin/cat  ResetSystem.pl" ); 
}	  








