<%@ include file="./WEB-INF/jspf/Directives.jspf" %>     
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="./WEB-INF/jspf/HautPage.jspf" %> 

<c:if test="${ ! empty requestScope.liste}"  >
<h2>Liste de tous les livres du catalogue </h2>
</c:if>

<c:if test="${ empty requestScope.liste}"  >
<c:if test="${ ! empty sessionScope.liste}"  >
<h2>Sélection de livres dont le prix est compris entre ${mini} et ${maxi} </h2>
</c:if>
</c:if>

<table border="1">
<tr><td>Id</td><td>Titre</td><td>Auteur</td><td>Prix</td><td>&nbsp;</td></tr>		

<c:forEach var="v" items="${liste}" >
 <tr>
 <td>${v.id}</td>
 <td>${v.titre}</td>
 <td>${v.auteur}</td>
 <td>${v.prix}</td>
 <td><a href="./Modifier?id=${v.id}">Modifier</a></td>
 </tr>
</c:forEach>

</table>

<br>
<a href="./">Accueil</a>

</body>
</html>