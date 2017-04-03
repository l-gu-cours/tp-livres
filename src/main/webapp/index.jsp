<%@ include file="./WEB-INF/jspf/Directives.jspf" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TP gestion des livres</title>
</head>

<body>

<h2>TP gestion des livres</h2>

<ul>
<li><a href="./ListerCatalogue">Lister tous les livres du catalogue</a>  </li>
<li><a href="./Filtrer">Filtrer les livres en fonction du prix</a> </li>
<c:if test="${ ! empty sessionScope.liste}"  >
<li><a href="./ListerSelection" >Lister la sélection de livres </a> </li>
<li><a href="./ViderListe" >Vider la sélection de livres </a> </li>
</c:if>
</ul>

</body>
</html>