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
elsif ( $act eq "Display All" ) {
print ( "Content-type: text/html\n\n" );
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom DisplayAll";
    system($cmd);
}
elsif ( $act eq "Log out" ) {
print ( "Content-type: text/html\n\n" );
print <<EndofHTML;

<html>
<head>
  <title>Slide 2.6: HTML interface</title>
 </head>
<center>
<br /><br />
<form method="post" action="http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/2/LogIn.cgi">
 <table width="90%" >
<tr>
   <td>LOG IN PAGE</td>
</tr>
<tr>
   <td>
User name: <input type="text" name="userName" size="20" />
     <font size="0"><br /><br /></font>
   </td>
</tr>
<tr>
   <td>
Password: <input type="text"     name="password" size="20" />
     <font size="0"><br /><br /></font>
   </td>
</tr>

<tr>
   <td>
      <input type="submit" name="act" value="LogIn"> &nbsp; <input type="submit" name="act" value="Register"> &nbsp;
   </td>
</tr>

 </table><br />

</form>
</center>

 </body>
</html>
EndofHTML

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
elsif ( $act eq "Java source" ) {
    print ( "Content-type: text/plain\n\n" );
    system( "/bin/cat  DisplayAll.java; echo \n\n\n\n" );
}
else {
    print( "Content-type: text/plain\n\n" );
    print( "No such option: <em>$act</em>" );
}

