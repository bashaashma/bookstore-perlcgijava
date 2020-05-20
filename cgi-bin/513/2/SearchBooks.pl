#!/usr/bin/perl
use CGI; 
$query   = new CGI;
$act     = $query->param('act');
$keywords  = $query->param('keyWords');
$username = $query->url_param("customerName");
$customerId = $query->url_param("customerId");
    
if ( $act eq "Search" ) {
	print ( "Content-type: text/html\n\n" );

    @keywords = split(' ',$keywords);
    $cmd = "/usr/bin/java -Djava.security.egd=file:/dev/./urandom SearchBooks ";
   

    foreach my $element (@keywords){
		$element =~ s/^\s+|\s+$//g;
		#@elementArray = split(' ',$element);
		#$element = join("@",@elementArray); 
	}

	my @keywords2 = grep(s/\s*$//g, @keywords);

	push(@keywords,@keywordList);
	print("Content-type: text/html\n\n");
	#print("@subjectsDup2");
	my %seen = ();

	my @keywordsDup = grep { ! $seen{ $_}++ } @keywords;

	$keywordDup = join(".",@keywordsDup);



 
  # Print HTML.
  # print($customerId);
  # print($username);
$cmd.= "'$username'"." ";
$cmd.= "'$customerId'"." ";
$cmd.= $keywordDup;
print($cmd);

system($cmd);

}

elsif ( $act eq "Perl Source" ) {
    print ( "Content-type: text/plain\n\n" );
    system( "/bin/cat LogIn.pl; echo \n\n\n\n" );
}
elsif ( $act eq "Java Source" ) {
    print ( "Content-type: text/plain\n\n" );
    system( "/bin/cat Customer.java; echo \n\n\n\n" );

    
}    
elsif ( $act eq "Log Out" ) {
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

