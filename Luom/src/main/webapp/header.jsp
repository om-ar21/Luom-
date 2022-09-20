<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="model.Coordonnees"%> 
<%@page import="model.Categorie"%> 
<%@page import="model.Favoris"%> 
<%@page import="model.FavorisDAO"%> 
<%@page import="model.Souscategorie"%>
<%@page import="model.SouscategorieDAO"%>
<%Coordonnees c =  (Coordonnees)request.getAttribute("cord"); %> 
<%ArrayList<Souscategorie> soucat = new ArrayList<Souscategorie>(); %>

<%@page import="java.util.ArrayList"%>
<%ArrayList<Categorie> cat = new ArrayList<Categorie>();%>
<%ArrayList<Favoris> fav = new ArrayList<Favoris>();%>

<!-- offcanvas-overlay start -->
<div class="offcanvas-overlay"></div>
<!-- offcanvas-overlay end -->
<!-- offcanvas-mobile-menu start -->
<div id="offcanvas-mobile-menu" class="offcanvas theme1 offcanvas-mobile-menu">
  <div class="inner">
    <div class="border-bottom mb-4 pb-4 text-right">
      <button class="offcanvas-close">×</button>
    </div>
    <div class="offcanvas-head mb-4">
      <nav class="offcanvas-top-nav">
        <ul class="d-flex flex-wrap">
          <li class="my-2 mx-2">
            <a href="Cart">
              <i class="icon-bag"></i><span>(${countallart})</span></a
            >
          </li>
          <li class="my-2 mx-2">
            
            <% if((boolean)session.getAttribute("isConnected")==false){ %>
            
            <i class="icon-heart"></i>
            
            <%}else{ %>
            
            <a href="Wishlist">
            <i class="ion-android-favorite-outline"></i>
                      <span>(${nbr_favoris})</span>
                      </a>
                      
            <%} %>
          </li>
          
          <li class="my-2 mx-2">
            <a class="search search-toggle" href="javascript:void(0)">
              <i class="icon-magnifier"></i> Search</a
            >
          </li>
        </ul>
      </nav>
    </div>
    <nav class="offcanvas-menu">
      <ul>
        <li>
          <a href="Index"><span class="">Accueil</span></a>
         
        </li>
     <% 
       		cat=(ArrayList)request.getAttribute("cat");
       		for( Categorie cats:cat){
       		%>
        <li>
          <a href="SeeCat?id=<%=cats.getId()%>&titre=<%=cats.getTitre()%>"><span class="menu-text"><%= cats.getTitre() %></span></a>
          <ul class="offcanvas-submenu">
          <% 
          SouscategorieDAO sou= new SouscategorieDAO();
          int idcat = cats.getId();
  		ArrayList<Souscategorie> souca= sou.getAllById(idcat);
   		
   		for( Souscategorie souc:souca){
       		%>
                <li><a href="SeeSscat?id=<%=souc.getId()%>&titre=<%=souc.getTitre()%>"><%= souc.getTitre() %></a></li>
                
                <%} %>
           
            
          </ul>
        </li>
    <%} %>
        <li><a href="ContactServlet">Contact</a></li>
      </ul>
    </nav>
    <div class="offcanvas-social py-30">
      <ul>
        <li>
          <a href="#"><i class="icon-social-facebook"></i></a>
        </li>
        <li>
          <a href="#"><i class="icon-social-twitter"></i></a>
        </li>
        <li>
          <a href="#"><i class="icon-social-instagram"></i></a>
        </li>
        <li>
          <a href="#"><i class="icon-social-google"></i></a>
        </li>
        <li>
          <a href="#"><i class="icon-social-instagram"></i></a>
        </li>
      </ul>
    </div>
  </div>
</div>
<!-- offcanvas-mobile-menu end -->
<!-- OffCanvas Wishlist Start -->
<div id="offcanvas-wishlist" class="offcanvas offcanvas-wishlist theme1">
  <div class="inner">
    <div class="head d-flex flex-wrap justify-content-between">
      <span class="title">Wishlist</span>
      <button class="offcanvas-close">×</button>
    </div>
    <% if((boolean)session.getAttribute("isConnected")==false){ %> 
              <p class=" mt-5 text-center"> 
                <a href="Connexion" class="font-weight-bold"> Connectez-vous &thinsp; </a>  pour pouvoir accéder à votre wishlist
         
              </P>
               <% }else{ %>
    
    
    <ul class="minicart-product-list">
    	<% 
            	
    	fav=(ArrayList<Favoris>)request.getAttribute("fav");
       		for( Favoris favs:fav){
       		%>
      <li>
        <a href="single-product.html" class="image"
          ><img src="<%= favs.getProduit(favs.getId_produit()).getImg() %>" alt="Cart product Image"
        /></a>
        <div class="content">
        <%if (favs.getProduit(favs.getId_produit()).getTitre().length()>20){ %>
          <a href="single-product.html" class="title"
            ><%= favs.getProduit(favs.getId_produit()).getTitre().substring(0,20) %>....</a
          >
          <%}else{ %>
           <a href="single-product.html" class="title"
            ><%= favs.getProduit(favs.getId_produit()).getTitre() %></a
          >
          <%} %>
          <br>
         
            <span class="amount"><%= favs.getProduit(favs.getId_produit()).getPrix() %> €</span>
          <a href="Header?delete=<%=favs.getId()%>" class="remove">×</a>
        </div>
      </li>
   <%} %>
    </ul>
      <a
      href="Wishlist"
      class="btn btn-primary btn--lg d-block d-sm-inline-block mt-30"
      >view wishlist</a
    >
    <%} %>
  </div>
</div>
<!-- OffCanvas Wishlist End -->

<!-- OffCanvas Cart Start -->

<!-- OffCanvas Cart End -->

<!-- header start -->
<header>
  <!-- header top start -->
  <div class="header-top theme1 theme-bg py-15">
    <div class="container-fluid">
      <div class="row align-items-center">
        <div class="col-lg-8 col-sm-12 order-last order-sm-first">
          <div
            class="d-flex justify-content-center justify-content-sm-start align-items-center"
          >
            <div class="social-network2 modify ">
              <ul class="d-flex">
                 
                <li class=" ">
                  <h4 class="text-light"><a href="Index"><%= c.getNom() %></a></h4>
                </li>
                
                <li class="ml-5 d-none d-md-block">
                  <span class="icon-map" style="color: white;"></span
                  >
                </li>
                <li class="d-none d-md-block">
                  <span class="text-light mr-2"><%= c.getAdresse() %></span
                  >
                </li >
                 <li  class="d-none d-md-block">
                  <span class="icon-phone" style="color: white;"></span
                  >
                </li >
                <li class="d-none d-md-block">
                  <span class="text-light mr-2"><%= c.getTel() %></span
                  >
                </li>
                   <li class="d-none d-md-block">
                  <span class="icon-social-google" style="color: white;"></span
                  >
                </li>
                <li class="d-none d-md-block">
                  <span class="text-light"><%= c.getEmail() %></span
                  >
                </li>
              
              </ul>
            </div>
          
          </div>
        </div>
        <div class="col-lg-4 col-sm-12">
          <nav class="navbar-top modify pb-2 pb-sm-0 position-relative">
            <ul
              class="d-flex justify-content-center justify-content-md-end align-items-center"
            >
            <% if((boolean)session.getAttribute("isConnected")==false){ %> 
              <li>
                <a
                  href="Connexion"
                  
                  >Connexion/Inscription</a>
         
              </li>
               <% }else{ %>
              
              
               <li>
                <a href="#"> Bonjour ${usernom }</a>
                </li>
                <li>
                <a href="Moncompte">Mon compte</a>
                </li>
                <li>
                <a href="Deconnexion">D&eacute;connexion</a>
                </li>
                <% } %>
           
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
  <!-- header top end -->
  <!-- header-middle satrt -->
  <div id="sticky" class="header-middle theme1 py-15 py-lg-0">
    <div class="container-fluid  position-relative  ">
      <div class="row mr-3  align-items-center">
        <div class="col-6 col-lg-3">
          <div class="logo">
            <a href="Index"
              ><img src="<%= c.getLogo() %>" alt="logo"
            /></a>
          </div>
        </div>
        <div class="col-lg-6 d-none d-lg-block">
          <ul class="main-menu d-flex justify-content-center">
            <li class="active ml-0">
              <a href="Index" class="pl-0"
                >Accueil </a>
             
            </li>
            	<% 
            	
       		cat=(ArrayList)request.getAttribute("cat");
       		for( Categorie cats:cat){
       		%>
            <li>
              <a href="SeeCat?id=<%=cats.getId()%>&titre=<%=cats.getTitre()%>"><%= cats.getTitre() %> <i class="ion-ios-arrow-down"></i></a>
              <ul class="sub-menu">
              <% 
              SouscategorieDAO sou= new SouscategorieDAO();
              int idcat = cats.getId();
      		ArrayList<Souscategorie> souca= sou.getAllById(idcat);
       		
       		for( Souscategorie souc:souca){
       			
       		%>
                <li><a href="SeeSscat?id=<%=souc.getId()%>&titre=<%=souc.getTitre()%>"><%= souc.getTitre() %></a></li>
                
                <%} %>
              </ul>
            </li>
          <%} %>
          
            <li class="ml-5"><a href="ContactServlet">Contactez-nous</a></li>
          </ul>
        </div>
        <div class="col-6 col-lg-3">
          <!-- search-form end -->
          <div class="d-flex align-items-center justify-content-end">
            <!-- static-media end -->
            <div class="cart-block-links theme1 d-none d-sm-block">
              <ul class="d-flex">
                <li>
                  <a href="javascript:void(0)" class="search search-toggle">
                    <i class="icon-magnifier"></i>
                  </a>
                </li>
                
                <li>
                  <a class="offcanvas-toggle" href="#offcanvas-wishlist">
                  
           <%--        <c:choose>
            <c:when test="${ userid!=0 }">
            <span class="position-relative">
            <i class="icon-heart"></i>
            </span>
            </c:when>
            <c:otherwise> --%>
            <% if((boolean)session.getAttribute("isConnected")==false){ %>
            <span class="position-relative">
            <i class="icon-heart"></i>
                      </span>
            <%}else{ %>
            <span class="position-relative">
            <i class="icon-heart"></i>
                      <span class="badge cbdg1">${nbr_favoris}</span>
                      </span>
           <%} %>
           	<%-- </c:otherwise>
            </c:choose> --%>
                    
                  </a>
                </li>
                <li class="mr-xl-0 cart-block position-relative">
                  <a class="offcanvas-toggle" href="#offcanvas-cart">
                    <span class="position-relative">
                      <i class="icon-bag"></i>
                      <span class="badge cbdg1">${countallart}</span>
                    </span>
                  </a>
                </li>
                <!-- cart block end -->
              </ul>
            </div>
            <div class="mobile-menu-toggle theme1 d-lg-none">
              <a href="#offcanvas-mobile-menu" class="offcanvas-toggle">
                <svg viewbox="0 0 700 550">
                  <path
                    d="M300,220 C300,220 520,220 540,220 C740,220 640,540 520,420 C440,340 300,200 300,200"
                    id="top"
                  ></path>
                  <path d="M300,320 L540,320" id="middle"></path>
                  <path
                    d="M300,210 C300,210 520,210 540,210 C740,210 640,530 520,410 C440,330 300,190 300,190"
                    id="bottom"
                    transform="translate(480, 320) scale(1, -1) translate(-480, -318)"
                  ></path>
                </svg>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- header-middle end -->
</header>

<div class="overlay">
  <div class="scale"></div>
  <form class="search-box" action="Recherch"  method="POST">
    <input type="text" name="mot" placeholder="Cherchez un produit par titre ou description..." />
    <button id="close" name="bcherche" type="submit">
      <i class="ion-ios-search-strong"></i>
    </button>
  </form>
  <button class="close"><i class="ion-android-close"></i></button>
</div>
