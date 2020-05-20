#!/usr/bin/perl
use CGI; 
$query   = new CGI;
$act     = $query->param('act');
#$author  = $query->param('author');
    
if ( $act eq "Enter Book" ) {
print ( "Content-type: text/html\n\n" );

    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom First";
    
  # Print HTML.
    #print("Here");
    system($cmd);

}
elsif ( $act eq "Display All Books" ) {
	print ( "Content-type: text/html\n\n" );
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom DisplayAllBooks";
    system($cmd);
}
elsif ( $act eq "Display All Subjects" ) {
print ( "Content-type: text/html\n\n" );
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom DisplayAllSubjects";
    print($cmd);
    system($cmd);


}
elsif ( $act eq "Perl source" ) {
    print ( "Content-type: text/plain\n\n" );
    system( "/bin/cat ListTitles.pl; echo \n\n\n\n" );
}
elsif ( $act eq "Reset System" ) {
print ( "Content-type: text/html\n\n" );

    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom ResetSystem";
    print($cmd);
    system($cmd);
    
}
else {
    print( "Content-type: text/html\n\n" );
    print( "No such option: <em>$act</em>" );
}

