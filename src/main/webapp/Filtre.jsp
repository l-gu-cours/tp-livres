<%@ include file="./WEB-INF/jspf/Directives.jspf" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> 
</head>
<body>

<%@include file="./WEB-INF/jspf/HautPage.jspf" %> 

<form action="./Filtrer" method="get">
<h2>Filtrer les livres </h2>
<table>
<tr>
 <td colspan="2" ><b>Prix</b></td>  
</tr>
<tr>
 <td>Mini</td>
 <td><input name="p1" value="" /></td>
</tr>
<tr>
 <td>Maxi</td>
 <td><input name="p2" value="" /></td></tr>
</table>

<input type="submit" value="Filtrer"/>

</form>

<br>
<a href="./">Accueil</a>

</body>
</html>