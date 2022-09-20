<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mini cart</title>
</head>
<body>

<div id="offcanvas-cart" class="offcanvas offcanvas-cart theme1">
  <div class="inner">
    <div class="head d-flex flex-wrap justify-content-between">
      <span class="title">Panier</span>
      <button class="offcanvas-close">×</button>
    </div>
    <ul class="minicart-product-list">
    <c:forEach var="fe" items="${requestScope['fe']}">
      <li>
        <a href="single-product.html" class="image"
          ><img src="${ fe.produit.img }" alt="Cart product Image"
        /></a>
        <div class="content">
          <a href="single-product.html" class="title"
            >${ fe.produit.titre }</a
          >
          <span class="quantity-price"
            >
          <a href="PanierServlet?idtominus=${ fe.produit.id }">-</a>${ fe.qte }<a href="PanierServlet?idtoup=${ fe.produit.id }">+</a></span>
          <span class="quantity-price"
            >${ fe.qte } x <span class="amount">${ fe.produit.prix }€ = ${ fe.qte * fe.produit.prix }€</span></span
          >
          <a href="PanierServlet?idtosuppr=${ fe.produit.id }" class="remove">×</a>
        </div>
      </li>
    </c:forEach>
    </ul>
    <p>${countallart} article(s)</p>
    <div class="sub-total d-flex flex-wrap justify-content-between">
      <strong>Total :</strong>
      <span class="amount">${ T }€</span>
    </div>
    <a
      href="Cart"
      class="btn btn-secondary btn--lg d-block d-sm-inline-block mr-sm-2"
      >Panier</a
    >
    <c:choose>
	<c:when test="${ !empty sessionScope.usernom }">
	<a href="PanierServlet?com=ok" class="btn btn-dark btn--lg d-block d-sm-inline-block mt-4 mt-sm-0">Payer</a>
	</c:when>
	<c:otherwise>
	<a href="Connexion" class="btn btn-dark btn--lg d-block d-sm-inline-block mt-4 mt-sm-0">Connexion/Inscription</a>
	</c:otherwise>
	</c:choose>
    
    <p class="minicart-message">Free Shipping on All Orders Over $100!</p>
  </div>
</div>

</body>
</html>