#!/usr/bin/perl
use CGI; 
$query   = new CGI;
$act     = $query->param('act');
$author  = $query->param('author');

if ( $act eq "List titles" ) {
  # Print HTML.
    print ( "Content-type: text/html\n\n" );

# Use "here-doc" syntax.
    print <<EndofHTML;
  <html>
   <body>
    <table width="100%" height="80%">
     <tr>
      <td align="center">
       <font size="+0"><b>
EndofHTML

  # Remove leading and trailing spacing.
  $author =~ s/^\s*(\S*)\s*$/$1/;
  # For security, remove some Unix metacharacters.
  $author =~ s/;|>|>>|<|\*|\?|\&|\|//g;
  # Compose a Java command.
  $cmd    =  "/usr/bin/java  ListTitles ";
  if ( $query->param('all') )      { $cmd .= "''"; }
  else {
    if ( $query->param('Scott') )  { $cmd .= "Scott "; }
    if ( $query->param('Jacobs') ) { $cmd .= "Jacobs "; }
    if ( !($author eq "") )        { $cmd .= "'$author'"; }
  }
  print( $cmd );    system( $cmd );

print <<EndofHTML;
        <form>
         <input type="button" value=" Back " onclick="history.go(-1);return false;" />
        </form>
       </b></font>
      </td>
     </tr>
    </table>
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
