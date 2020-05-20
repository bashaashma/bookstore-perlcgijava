#!/usr/bin/perl
use CGI; 
$query   = new CGI;
$act     = $query->param('act');
$username  = $query->param('userName');

print ( "Content-type: text/html\n\n" );
if ( $act eq "CreateAccount" ) {

    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom CreateAccount ";
    $cmd.="'$username'";
    print($cmd);
    system($cmd);
    
}


