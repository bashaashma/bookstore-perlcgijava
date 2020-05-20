#!/usr/bin/perl

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
