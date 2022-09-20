<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.ArrayList"%>

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
    <link rel="stylesheet" href="assets/css/custom.css" />
    <link rel="stylesheet" href="assets/sass/pages/shopPages/_shop.scss"/>

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

<!-- offcanvas-overlay end -->

<!--header a mettre ici -->
<jsp:include page="/Header"/>
<jsp:include page="/MiniCart"/>

<nav class="breadcrumb-section theme1 bg-lighten2 pt-30 pb-30" style="background-color: aliceblue;">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="section-title text-center">
          <h2 class="title pb-4 text-dark text-capitalize">
            ${titre}
          </h2>
        </div>
      </div>
      <div class="col-12">
        <ol
          class="breadcrumb bg-transparent m-0 p-0 align-items-center justify-content-center"
        >
          <li class="breadcrumb-item"><a href="Index">Home</a></li>
          <li class="breadcrumb-item"><a href="SeeCat?id=${cate.id}&titre=${cate.titre}">${ cate.titre }</a></li>
          <li class="breadcrumb-item active" aria-current="page"><a>${titre}</a></li>
          
        </ol>
      </div>
    </div>
  </div>
</nav>

<div class="grid-nav-wraper bg-white pt-3">
      <div class="row align-items-center">
        <div class="col-12 col-md-6">
          <nav class="shop-grid-nav">
            <ul
              class="nav nav-pills align-items-center"
              id="pills-tab"
              role="tablist"
            >
              <li class="nav-item">
                <a
                  class="nav-link active"
                  id="pills-home-tab"
                  data-toggle="pill"
                  href="#pills-home"
                  role="tab"
                  aria-controls="pills-home"
                  aria-selected="true"
                >
                  <i class="fa fa-th"></i>
                </a>
              </li>
              <li class="nav-item mr-0">
                <a
                  class="nav-link"
                  id="pills-profile-tab"
                  data-toggle="pill"
                  href="#pills-profile"
                  role="tab"
                  aria-controls="pills-profile"
                  aria-selected="false"
                  ><i class="fa fa-list"></i
                ></a>
              </li>
              <!--<li>
                <span class="total-products text-capitalize"
                  >There are 13 products.</span
                >
              </li>-->
            </ul>
          </nav>
        </div>
        <!-- <div class="col-12 col-md-6 position-relative">
          <div class="shop-grid-button d-flex align-items-center">
            <span class="sort-by">Sort by:</span>
            <select
              class="form-select custom-select"
              aria-label="Default select example"
            >
              <option selected>Open this select menu</option>
              <option value="1">One</option>
              <option value="2">Two</option>
              <option value="3">Three</option>
            </select>
          </div>
        </div> -->
      </div>
    </div>

<div class="product-tab bg-white pb-80">
  <div class="container">
    
    <!-- product-tab-nav end -->
    <div class="tab-content" id="pills-tabContent">
      <!-- first tab-pane -->
      <div
        class="tab-pane fade show active"
        id="pills-home"
        role="tabpanel"
        aria-labelledby="pills-home-tab"
      >
        <div class="row grid-view theme1">
        <c:forEach var="prod" items="${requestScope['prods']}" >
          <div class="col-sm-6 col-lg-4 col-xl-3 mb-30">
            <div class="card product-card">
              <div class="card-body">
                <div class="product-thumbnail position-relative">
                  <span class="badge badge-danger top-right">New</span>
                  <a href="SeeProduit?id=${prod.id}">
                    <img
                      class="first-img"
                      src="${prod.img}"
                      alt="thumbnail"
                    />
                  </a>
                  <!-- product links -->
                  <ul class="actions d-flex justify-content-center">
                    <c:if test="${ sessionScope.isConnected==true }">
													<c:set var="idprod" value="${ prod.id }" scope="page"></c:set>
													<c:set var="f" value="${ prod.getFavoris(idprod) }" scope="page"></c:set>
                     <c:choose>
                     <c:when test="${ f.fav==1 && f.id_user==sessionScope.userid && f.id_produit==prod.id}">
                      <form method="POST">
                      <li>
                      <a   class="action" href="#">
                      <button type="submit" data-toggle="tooltip"
                              data-placement="bottom"
                              name="btnrmv"
                               title="remove from wishlist" 
                               style="color: rgb(234, 115, 23);">&#10084;</button>
                               <input type="hidden" name="idp" value="${prod.id}" />
                      </a>
                      </li>
                      </form>
                      </c:when>
                      <c:otherwise>
                      <form method="POST">
                      <li >
                          <a  class="action " href="#" >
                            <button type="submit"
                            name="btnadd"
                            
                              data-toggle="tooltip"
                              data-placement="bottom"
                              title="add to wishlist"
                              class="icon-heart"
                            >
                            </button>
                            <input type="hidden" name="idp" value="${prod.id}" />
                          </a>
                        </li> 
                       </form>
                      
                      </c:otherwise>
                      </c:choose>
                      </c:if>
                    
                    <li><a class="action" href="#" data-toggle="modal"
															data-target="#quick-view${prod.id}">

																<span data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>

                  </ul>
                  <!-- product links end-->
                </div>
                <div class="product-desc py-0 px-0">
                  <h3 class="title" style="height:48px">
                    <a href="SeeProduit?id=${prod.id}"
                      >${prod.titre}</a
                    >
                  </h3>
                  
                  <div
                    class="d-flex align-items-center justify-content-between"
                  >
                    <span class="product-price">${prod.prix}€</span>
                    <form method="POST"><button
                          type="submit"
                          name="padd" 
                          value="${prod.id}"
                          class="pro-btn"
                          data-toggle="modal"
                          data-target="#add-to-cart"
                        >
                          <i class="icon-basket"></i>
                        </button></form>
                  </div>
                </div>
              </div>
            </div>
            <!-- product-list End -->
          </div>
          
          <div class="modal fade theme1 style1" id="quick-view${prod.id}"
										tabindex="-1" role="dialog">
										<div class="modal-dialog modal-dialog-centered"
											role="document">
											<div class="modal-content">

												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<div class="row">
														<div class="col-md-8 mx-auto col-lg-5 mb-5 mb-lg-0">
															<div class="product-sync-init mb-20">
																<div class="single-product">
																	<div class="product-thumb">
																		<img src="${prod.img}"
																			alt="product-thumb" />
																	</div>
																</div>
																<!-- single-product end -->
																<!-- <div class="single-product">
																	<div class="product-thumb">
																		<img src="assets/img/slider/thumb/2.jpg"
																			alt="product-thumb" />
																	</div>
																</div> -->
																<!-- single-product end -->

															</div>

															<div class="product-sync-nav">
																<div class="single-product">
																	<div class="product-thumb">
																		<a href="javascript:void(0)"> <img
																			src="${prod.img}"
																			alt="product-thumb" /></a>
																	</div>
																</div>
																<!-- single-product end -->
																<!-- <div class="single-product">
																	<div class="product-thumb">
																		<a href="javascript:void(0)"> <img
																			src="assets/img/slider/thumb/2.1.jpg"
																			alt="product-thumb" /></a>
																	</div>
																</div> -->
																<!-- single-product end -->

															</div>
														</div>
														<div class="col-lg-7">
															<div class="modal-product-info">
																<div class="product-head">
																<a href="SeeProduit?id=${prod.id}">
																	<h2 class="title">${prod.titre}</h2></a>
																	<h4 class="sub-title">Disponible: ${prod.stock}</h4>
																	
																</div>
																<div class="product-body">
																	<span class="product-price text-center"> <span
																		class="new-price">${prod.prix}€</span>
																	</span>
																	<p>${prod.presentation}</p>

																</div>
																<div class="d-flex mt-30"></div>
																<div class="product-footer">
																<form method="POST">
																	<div
																		class="product-count style d-flex flex-column flex-sm-row my-4">
																		<div class="count d-flex">
																			<input type="number" min="1" max="${prod.stock}" step="1"
																				value="1" name="newqte"/>
																			<div class="button-group">
																				<a class="count-btn increment">
																					<i class="fas fa-chevron-up"></i>
																				</a>
																				<a class="count-btn decrement">
																					<i class="fas fa-chevron-down"></i>
																				</a>
																			</div>
																		</div>
																		<div>
																			<button type="submit" name="paddqte" value="${prod.id}" class="btn btn-dark btn--xl mt-5 mt-sm-0">
																				<span class="mr-2"><i class="ion-android-add"></i></span>
																				Ajouter
																			</button>
																			<a href="SeeProduit?id=${prod.id}" class="btn btn-dark btn--xl mt-5 mt-sm-0">
																			
																				<span class="mr-2"><i class="ion-android-add"></i></span>
																				Voir 
																			</a>
																		</div>
																	</div>
																	<ul class="actions d-flex justify-content-center">
                    
                    
                    <li><a class="action" href="#" data-toggle="modal"
															data-target="#quick-view${prod.id}">

																<span data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>

                  </ul>
																	<div class="addto-whish-list">
																	<c:if test="${ sessionScope.isConnected==true }">
																	<c:set var="idprod" value="${ prod.id }" scope="page"></c:set>
													<c:set var="f" value="${ prod.getFavoris(idprod) }" scope="page"></c:set>
                     <c:choose>
                     <c:when test="${ f.fav==1 && f.id_user==sessionScope.userid && f.id_produit==prod.id}">
                      <form method="POST">
                      <li>
                      <a   class="action" href="#">
                      <button type="submit" data-toggle="tooltip"
                              data-placement="bottom"
                              name="btnrmv"
                               title="remove from wishlist" 
                               style="color: rgb(234, 115, 23);">&#10084;</button>
                               <input type="hidden" name="idp" value="${prod.id}" />
                      </a>
                      </li>
                      </form>
                      </c:when>
                      <c:otherwise>
                      <form method="POST">
                      <li >
                          <a  class="action " href="#" >
                            <button type="submit"
                            name="btnadd"
                            
                              data-toggle="tooltip"
                              data-placement="bottom"
                              title="add to wishlist"
                              class="icon-heart"
                            >
                            </button>
                            <input type="hidden" name="idp" value="${prod.id}" />
                          </a>
                        </li> 
                       </form>
                      
                      </c:otherwise>
                      </c:choose>
					
                      </c:if>
																		
																	</div>
																	<div class="pro-social-links mt-10">
																		<ul class="d-flex align-items-center">
																			<li class="share">Share</li>
																			<li><a href="#"><i
																					class="ion-social-facebook"></i></a></li>
																			<li><a href="#"><i
																					class="ion-social-twitter"></i></a></li>
																			<li><a href="#"><i class="ion-social-google"></i></a>
																			</li>
																			<li><a href="#"><i
																					class="ion-social-pinterest"></i></a></li>
																		</ul>
																	</div>
																	</form>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
									</div>
        </c:forEach>
        </div>
      </div>
      <!-- second tab-pane -->
      <div
        class="tab-pane fade"
        id="pills-profile"
        role="tabpanel"
        aria-labelledby="pills-profile-tab"
      >
        <div class="row grid-view-list theme1">
        <c:forEach var="prod" items="${requestScope['prods']}" >
        
        
        
          <div class="col-12 mb-30">
            <div class="card product-card">
              <div class="card-body">
                <div class="media flex-column flex-md-row">
                  <div class="product-thumbnail position-relative">
                    <span class="badge badge-danger top-right">sale</span>
                    <a href="SeeProduit?id=${prod.id}">
                      <img
                        class="first-img"
                        src="${prod.img}"
                        alt="thumbnail"
                        style="width:272px; height:272px"
                      />
                    </a>
                    <!-- product links -->
                    <ul class="actions d-flex justify-content-center">
                      <c:if test="${ sessionScope.isConnected==true }">
													<c:set var="idprod" value="${ prod.id }" scope="page"></c:set>
													<c:set var="f" value="${ prod.getFavoris(idprod) }" scope="page"></c:set>
                     <c:choose>
                     <c:when test="${ f.fav==1 && f.id_user==sessionScope.userid && f.id_produit==prod.id}">
                      <form method="POST">
                      <li>
                      <a   class="action" href="#">
                      <button type="submit" data-toggle="tooltip"
                              data-placement="bottom"
                              name="btnrmv"
                               title="remove from wishlist" 
                               style="color: rgb(234, 115, 23);">&#10084;</button>
                               <input type="hidden" name="idp" value="${prod.id}" />
                      </a>
                      </li>
                      </form>
                      </c:when>
                      <c:otherwise>
                      <form method="POST">
                      <li >
                          <a  class="action " href="#" >
                            <button type="submit"
                            name="btnadd"
                            
                              data-toggle="tooltip"
                              data-placement="bottom"
                              title="add to wishlist"
                              class="icon-heart"
                            >
                            </button>
                            <input type="hidden" name="idp" value="${prod.id}" />
                          </a>
                        </li> 
                       </form>
                      
                      </c:otherwise>
                      </c:choose>
                      </c:if>
                      
                      <li><a class="action" href="#" data-toggle="modal"
															data-target="#quick-view${prod.id}bis">

																<span data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>
                      
                    </ul>
                    <!-- product links end-->
                  </div>
                  <div class="media-body pl-md-4">
                    <div class="product-desc py-0 px-0">
                      <h3 class="title">
                        <a href="SeeProduit?id=${prod.id}"
                          >${prod.titre}</a
                        >
                      </h3>
                      
                      <span class="product-price">${prod.prix}€</span>
                    </div>
                    <ul class="product-list-des">
                      <li>
                        ${prod.presentation}
                      </li>
                    </ul>
                    <div class="availability-list mb-20">
                      <p>Disponible: <span>${prod.stock}</span></p>
                    </div>
                    <form method="POST"><button
                    	  class="btn btn-dark btn--xl"
                          type="submit"
                          name="padd" 
                          value="${prod.id}"
                          class="pro-btn"
                          data-toggle="modal"
                          data-target="#add-to-cart"
                        >
                        Ajouter au panier
                        </button></form>
                  </div>
                </div>
              </div>
            </div>
            <!-- product-list End -->
          </div>
          
          <div class="modal fade theme1 style1" id="quick-view${prod.id}bis"
										tabindex="-1" role="dialog">
										<div class="modal-dialog modal-dialog-centered"
											role="document">
											<div class="modal-content">

												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<div class="row">
														<div class="col-md-8 mx-auto col-lg-5 mb-5 mb-lg-0">
															<div class="product-sync-init mb-20">
																<div class="single-product">
																	<div class="product-thumb">
																		<img src="${prod.img}"
																			alt="product-thumb" />
																	</div>
																</div>
																<!-- single-product end -->
																<!-- <div class="single-product">
																	<div class="product-thumb">
																		<img src="assets/img/slider/thumb/2.jpg"
																			alt="product-thumb" />
																	</div>
																</div> -->
																<!-- single-product end -->

															</div>

															<div class="product-sync-nav">
																<div class="single-product">
																	<div class="product-thumb">
																		<a href="javascript:void(0)"> <img
																			src="${prod.img}"
																			alt="product-thumb" /></a>
																	</div>
																</div>
																<!-- single-product end -->
																<!-- <div class="single-product">
																	<div class="product-thumb">
																		<a href="javascript:void(0)"> <img
																			src="assets/img/slider/thumb/2.1.jpg"
																			alt="product-thumb" /></a>
																	</div>
																</div> -->
																<!-- single-product end -->

															</div>
														</div>
														<div class="col-lg-7">
															<div class="modal-product-info">
																<div class="product-head">
																<a href="SeeProduit?id=${prod.id}">
																	<h2 class="title">${prod.titre}</h2></a>
																	<h4 class="sub-title">Disponible: ${prod.stock}</h4>
																	
																</div>
																<div class="product-body">
																	<span class="product-price text-center"> <span
																		class="new-price">${prod.prix}€</span>
																	</span>
																	<p>${prod.presentation}</p>

																</div>
																<div class="d-flex mt-30"></div>
																<div class="product-footer">
																<form method="POST">
																	<div
																		class="product-count style d-flex flex-column flex-sm-row my-4">
																		<div class="count d-flex">
																			<input type="number" min="1" max="${prod.stock}" step="1"
																				value="1" name="newqte"/>
																			<div class="button-group">
																				<a class="count-btn increment">
																					<i class="fas fa-chevron-up"></i>
																				</a>
																				<a class="count-btn decrement">
																					<i class="fas fa-chevron-down"></i>
																				</a>
																			</div>
																		</div>
																		<div>
																			<button type="submit" name="paddqte" value="${prod.id}" class="btn btn-dark btn--xl mt-5 mt-sm-0">
																				<span class="mr-2"><i class="ion-android-add"></i></span>
																				Ajouter
																			</button>
																			<a href="SeeProduit?id=${prod.id}" class="btn btn-dark btn--xl mt-5 mt-sm-0">
																			
																				<span class="mr-2"><i class="ion-android-add"></i></span>
																				Voir 
																			</a>
																		</div>
																	</div>
																	<div class="addto-whish-list">
																	<c:if test="${ sessionScope.isConnected==true }">
																	<c:set var="idprod" value="${ prod.id }" scope="page"></c:set>
													<c:set var="f" value="${ prod.getFavoris(idprod) }" scope="page"></c:set>
                     <c:choose>
                     <c:when test="${ f.fav==1 && f.id_user==sessionScope.userid && f.id_produit==prod.id}">
                      <form method="POST">
                      <li>
                      <a   class="action" href="#">
                      <button type="submit" data-toggle="tooltip"
                              data-placement="bottom"
                              name="btnrmv"
                               title="remove from wishlist" 
                               style="color: rgb(234, 115, 23);">&#10084;</button>
                               <input type="hidden" name="idp" value="${prod.id}" />
                      </a>
                      </li>
                      </form>
                      </c:when>
                      <c:otherwise>
                      <form method="POST">
                      <li >
                          <a  class="action " href="#" >
                            <button type="submit"
                            name="btnadd"
                            
                              data-toggle="tooltip"
                              data-placement="bottom"
                              title="add to wishlist"
                              class="icon-heart"
                            >
                            </button>
                            <input type="hidden" name="idp" value="${prod.id}" />
                          </a>
                        </li> 
                       </form>
                      
                      </c:otherwise>
                      </c:choose>
					
                      </c:if>
																		
																	</div>
																	<div class="pro-social-links mt-10">
																		<ul class="d-flex align-items-center">
																			<li class="share">Share</li>
																			<li><a href="#"><i
																					class="ion-social-facebook"></i></a></li>
																			<li><a href="#"><i
																					class="ion-social-twitter"></i></a></li>
																			<li><a href="#"><i class="ion-social-google"></i></a>
																			</li>
																			<li><a href="#"><i
																					class="ion-social-pinterest"></i></a></li>
																		</ul>
																	</div>
																	</form>
																</div>
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
									</div>
          
          
          </c:forEach>
        </div>
      </div>
    </div>
    <!-- <div class="row">
      <div class="col-12">
        <nav class="pagination-section mt-30">
          <ul class="pagination justify-content-center">
            <li class="page-item">
              <a class="page-link" href="#"><i class="ion-chevron-left"></i></a>
            </li>
            <li class="page-item active">
              <a class="page-link" href="#">1</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item">
              <a class="page-link" href="#"
                ><i class="ion-chevron-right"></i
              ></a>
            </li>
          </ul>
        </nav>
      </div>
    </div> -->
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

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->

    <!--*************************** 
          Minified  js 
     ***************************-->

    <!--*********************************** 
         vendor,plugins and main js
      ***********************************-->

    <!-- <script src="assets/js/vendor/vendor.min.js"></script>
    <script src="assets/js/plugins/plugins.min.js"></script>
    <script src="assets/js/main.js"></script> -->

</body>
</html>