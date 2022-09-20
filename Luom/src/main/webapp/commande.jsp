<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import= "model.User" %>
      <%@ page import= "model.Adresse" %>
      <%@ page import= "model.AdresseDAO" %>
      <%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="description" content="" />
    <title>Luom</title>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico" />

    <!--********************************** 
        all css files 
    *************************************-->

    <!--*************************************************** 
       fontawesome,bootstrap,plugins and main style css
     ***************************************************-->
    <!-- cdn links -->

    <link rel="stylesheet" href="assets/css/fontawesome.min.css" />
    <link rel="stylesheet" href="assets/css/ionicons.min.css" />
    <link rel="stylesheet" href="assets/css/simple-line-icons.css" />
    <link rel="stylesheet" href="assets/css/plugins/jquery-ui.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/plugins/plugins.css" />
    <!-- <link rel="stylesheet" href="assets/css/plugins/aos.css" /> -->
    <link rel="stylesheet" href="assets/css/style.min.css" />

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->

    <!--**************************** 
         Minified  css 
    ****************************-->

    <!--*********************************************** 
       vendor min css,plugins min css,style min css
     ***********************************************-->
    <!-- <link rel="stylesheet" href="assets/css/vendor/vendor.min.css" />
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css" />
    <link rel="stylesheet" href="assets/css/style.min.css" /> -->
</head>
<body>
<jsp:include page="/Header" />
<jsp:include page="/MiniCart"/>

<div class="check-out-section pt-80 pb-80">
  <div class="container">
    <div class="row">
      <div class="col-lg-7">


        <div class="billing-info-wrap">
          <h3 class="title">Informations de livraison</h3>
          <form class="personal-information" method="post">
            <div class="row">
              <div class="col-lg-6 col-md-6">
                <div class="billing-info mb-20px">
                  <label class="font-weight-bold mt-5">Nom</label>
                  <input style="border-top-style:none; border-right-style:none;"  value="${us.nom }" type="text" disabled />
                </div>
              </div>
              <div class="col-lg-6 col-md-6">
                <div class="billing-info mb-20px">
                  <label class="font-weight-bold mt-5" >Prénom</label>
                  <input style="border-top-style:none; border-right-style:none;" type="text"   value="${us.prenom }" disabled/>
                </div>
              </div>
              <div class="col-lg-12">
                <div class="billing-info mb-20px">
                  <label class="font-weight-bold mt-5">Email</label>
                  <input style="border-top-style:none; border-right-style:none;"  value="${us.email }" type="text" disabled/>
                </div>
              </div>
              <div class="col-lg-12">
                <div class="billing-select mb-20px">
                  <label for="inputState" class="form-label font-weight-bold mt-5">Adresse</label>
                  <select id="inputState" name="adresse" class="form-select mb-3">
                   <option value="0">Choisissez votre adresse</option>
                    <%ArrayList<Adresse> adr=new ArrayList<Adresse>();
                      adr=(ArrayList)request.getAttribute("adresse");
                      for(Adresse adrs:adr){
                    	  
                      %>
                    <option  value="<%= adrs.getId()%>"><%= adrs.getAdresse() %>, <%= adrs.getCp() %>, <%= adrs.getPays().substring(0,2) %> </option>
                    
                    <%} %>
                  </select>
                  <a href="Moncompte" class="btn btn-dark btn--md">Entrer une adresse</a>
                  <%if((boolean)request.getAttribute("ajouteradresse")==true){ %>
                  
                  <div class="alert alert-warning  mt-5" role="alert">Veuillez choisir une Adresse</div>
                  <%} %>
                </div>
              </div>
          
             
           
            </div>
              <div class="Place-order mt-25">
           <c:if test="${nope!=true }">
            <button  name="btnvcommande" class="d-flex justify-content-start btn btn-dark btn--md">Valider commande</button>
           </c:if>
          
           <c:if test="${nope==true }">
           <div class="alert alert-danger mt-5 mb-5" role="alert">Impossible d'effectuer la commande car elle est invalide</div>
           <a  href="Index" class="btn btn-dark btn--md">Retour à l'index</a>
           </c:if>
          </div>
          </form>

        </div>
      </div>
      <div class="col-lg-5 mt-4 mt-lg-0">
        <div class="your-order-area">
          <h3 class="title">Votre Commande</h3>
          <div class="your-order-wrap gray-bg-4">
            <div class="your-order-product-info">
            <div>
            <c:if test="${a1==true }">
															<div class="alert alert-warning">Le stock demandé est supérieurs à la quantité en stock pour (un) certain(s) article(s), nous vous enverrons la quantité restante.</div>
															</c:if>
															<c:if test="${a2==true }">
															<div class="alert alert-danger">(Un) certain(s) produit(s) sont en rupture, veuillez les recommander plus tard.</div>
															</c:if>
            </div>
              <div class="your-order-top">
                <ul>
                  <li>Produits</li>
                  <li>Total</li>
                </ul>
              </div>
              <div class="your-order-middle">
                <ul>
                <c:forEach var="fe" items="${requestScope['fe']}">
                  <li>
                    <span class="order-middle-left">${ fe.produit.titre } X ${fe.qte}</span>
                    <span class="order-price">${ fe.qte * fe.produit.prix }€</span>
                  </li>
                </c:forEach>
                </ul>
              </div>
              
              <div class="your-order-total">
                <ul>
                  <li class="order-total">Total</li>
                  <li>${ T }€</li>
                </ul>
              </div>
            </div>
            
          </div>
        
        </div>
      </div>
    </div>
  </div>
</div>


<jsp:include page="/Footer"/>
<!-- footer end -->

<!-- modals start -->
<!-- first modal -->

<!-- second modal -->

<!-- second modal -->

<!-- modals end -->

<!-- search-box and overlay start -->

<!-- search-box and overlay end -->



    <!--*********************** 
        all js files
     ***********************-->

    <!--****************************************************** 
        jquery,modernizr ,poppe,bootstrap,plugins and main js
     ******************************************************-->

    <script src="assets/js/vendor/jquery-3.5.1.min.js"></script>
    <script src="assets/js/vendor/modernizr-3.7.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins/jquery-ui.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/plugins/plugins.js"></script>
    <script src="assets/js/plugins/ajax-contact.js"></script>
    <!-- <script src="assets/js/plugins/aos.js"></script> -->
    <script src="assets/js/main.js"></script>


</body>
</html>