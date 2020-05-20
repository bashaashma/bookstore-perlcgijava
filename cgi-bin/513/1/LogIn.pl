#!/usr/bin/perl
use CGI; 
$query   = new CGI;
$act     = $query->param('act');
$username  = $query->param('userName');

print ( "Content-type: text/html\n\n" );
if ( $act eq "LogIn" ) {

   if ($username eq "Administrator"){

	  # Print HTML.
	 
	#end html
   $cmd = " /usr/bin/perl Administrator.pl";
   system($cmd);    
   # print("Welcome Administrator");
	
    }
    else{
    
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom Customer ";
    $cmd.="'$username'";
    print($cmd);
    system($cmd);
    }
}
elsif ( $act eq "Register" ) {

    $cmd = " /usr/bin/perl Register.pl";
    print($cmd);
    system($cmd);
    
    
}
elsif ( $act eq "Return to Login" ) {
  # Print plain text.
  
    $cmd = " /usr/bin/perl LogInPage.pl";
    print($cmd);
    system($cmd);
    
}
elsif ( $act eq "Perl source" ) {
    print ( "Content-type: text/plain\n\n" );
    system( "/bin/cat ListTitles.pl; echo \n\n\n\n" );
}
elsif ( $act eq "Java source" ) {
    print ( "Content-type: text/plain\n\n" );
    system( "/bin/cat ListTitles.txt; echo \n\n\n\n" );
}
elsif ( $act eq "Help" ) {
    print ( "Content-type: text/html\n\n" );
    system( "/bin/cat  Help.html" );
}
else {
    print( "Content-type: text/html\n\n" );
    print( "No such option: <em>$act</em>" );
}
