#!/usr/bin/perl
use CGI; 
$query   = new CGI;
$act     = $query->param('act');
$author  = $query->param('author');

if ( $act eq "Enter Book" ) {

    $cmd = "/usr/bin/java First";
    
  # Print HTML.
    print ( "Content-type: text/html\n\n" );
    system($cmd);
# Use "here-doc" syntax.
    print <<EndofHTML;
<!DOCTYPE html>
<html>
    <head>
      
	<title>Books</title>
    </head>

    <body>
	<h1>Books</h1>
        <br />	
        <br/>
	<form method ="post" action ="http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/books.cgi" target="view">
            <table width="90%" cellspacing ="3" cellpadding ="10" border="0" class="shadow">
                <tr>
                <td> ISBN:</td>
                <td><input type="text" name ="isbn"></td>
                </tr>
                <tr>
                <td> Title:</td>
                <td><input type="text" name ="title"></td>
                </tr>
                <tr>
                <td> Price:</td>
                <td><input type="text" name ="price"></td>
                </tr>
                <tr>
                <td>Subject(use semi-colons when inputing  multiple subjects):</td>
                <td><input type="text" name="subject"></td>
                </tr>
                <tr>
                <td> <input type ="submit" name ="act"  value = "Sumbit Book"></td>
                </tr>
            </table>
        </form>
    </body>
</html>

EndofHTML
}
elsif ( $act eq "HTML source" ) {
    print ( "Content-type: text/plain\n\n" );
    $cmd  = "/usr/bin/lynx -dump -source " . $ENV{HTTP_REFERER}; 
    $cmd .= "; echo \n\n\n\n";
    system( $cmd );
}
elsif ( $act eq "CGI source" ) {
  # Print plain text.
    print ( "Content-type: text/plain\n\n" );
    system( "/bin/cat ListTitles.cgi; echo \n\n\n\n" );
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

