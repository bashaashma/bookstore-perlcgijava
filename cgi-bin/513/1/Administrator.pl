#!/usr/bin/perl

    print <<EndofHTML;
<html>
<head>
  <meta name="robots" content="noindex,nofollow">
  <link rel="stylesheet" type="text/css"
    href="http://undcemcs01.und.edu/~wen.chen.hu/css/1.css" />
  <title>Slide 2.6: HTML interface</title>
 </head>
 <body text="#000000" vLink="#3366CC" link="#3366CC" bgColor="#ffffff" alink="#3366CC">

<center>
<br /><br />
<form method="post" action="http://undcemcs02.und.edu/~mark.arinaitwe/cgi-bin/513/1/ListTitles.cgi" target="view">
 <table width="90%" bgcolor="navy" cellspacing="3" cellpadding="10" border="0" class="shadow">
  <tr bgcolor="#EDF3FE">
   <td><font size="+1"><center><br />
    <font face="Verdana, Arial, Helvetica" size="-1">
    <strong> Exercise I</strong></font> &nbsp;
          <font size="0"><br /><br /></font>
    <input type="submit" name="act" value="Enter Book"> &nbsp;
    <input type="submit" name="act" value="Display All Books"> &nbsp;
    <input type="submit" name="act" value="Display All Subjects"> &nbsp;
    <input type="submit" name="act" value="Perl source"> &nbsp;
    <input type="submit" name="act" value="Reset System"> &nbsp;
        
   </center></font>
   </td>
  </tr>
  <tr bgcolor="#EDF3FE">
   <td>
    <iframe frameborder="0" width="100%" height="300"  name="view">
    </iframe>
   </td>
  </tr>
 </table><br />

</form>
</center>

 </body>
</html>
 
EndofHTML


