<%@ include file="./WEB-INF/jspf/Directives.jspf" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="./WEB-INF/jspf/HautPage.jspf" %> 

<form action="./Enregistrer" method="get">
<h2>Modification du livre</h2>
<input name="id"  type="hidden" value="${livre.id}" />

<table>

<tr>
 <td>Id </td>
 <td>${livre.id}</td>
</tr>

<tr>
 <td>Titre</td>
 <td><input name="titre" value="${livre.titre}" /></td>
</tr>

<tr>
 <td>Auteur</td>
 <td><input name="auteur" value="${livre.auteur}" /></td>
</tr>

<tr>
 <td>Prix</td>
 <td><input name="prix" value="${livre.prix}" /></td>
</tr>

</table>

<input type="submit" value="Enregistrer"/>

</form>

<br>
<a href="./">Accueil</a>

</body>
</html>