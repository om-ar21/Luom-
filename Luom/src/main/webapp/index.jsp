<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Favoris"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<meta name="description" content="" />
<title>Luom</title>
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico" />

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
<link rel="stylesheet" href="assets/sass/pages/shopPages/_shop.scss" />

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

	<!--header a mettre ici -->
	<jsp:include page="/Header" />
	<!--Wishlist ici-->

	<!-- OffCanvas Cart Start -->
	<jsp:include page="/MiniCart" />
	<!-- OffCanvas Cart End -->

	<!-- main slider start -->
	<section class="bg-light">
		<div class="main-slider dots-style theme1">
			<c:forEach var="slid" items="${requestScope['slids']}">
				<div class="slider-item" style="background-image:url('${slid.img}')">
					<div class="container">
						<div class="row align-items-center slider-height">
							<div class="col-12">
								<div class="slider-content">
									<p class="text animated" data-animation-in="fadeInDown"
										data-delay-in=".300">${ slid.titre }</p>
									<h2 class="title animated">
										<span class="animated d-block" data-animation-in="fadeInLeft"
											data-delay-in=".800">Skincare Brush
											Set</span> <span class="animated font-weight-bold"
											data-animation-in="fadeInRight" data-delay-in="1.5">Sale
											30% Off</span>
									</h2>
									<a href="${slid.lien}"
										class="btn btn-outline-primary btn--lg animated mt-45 mt-sm-25"
										data-animation-in="fadeInLeft" data-delay-in="1.9">Voir</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- slider-item end -->

		</div>
	</section>
	<!-- main slider end -->

	<!-- blog-section start -->
	<!--code py-80 pour le premier ecart avec le slider-->
	<c:if test="${ cat1.del==false || cat2.del==false || cat3.del==false }">
	<section class="blog-section theme1 pt-80 pb-27">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-title text-center">
						<h2 class="title pb-3 mb-3">Catégories Phares</h2>
						<p class="text">Chez Luom nous pensons à tous le monde,
							Femmes, Hommes, Enfants ! Il y en a pour tous les goûts.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12">

					<div class="blog-init slick-nav">
						<!--Boucler ici si on voulait mais comme on met en dur alors brrrr-->
						<c:if test="${ cat1.del!=true }">
						<div class="slider-item">
							<div class="single-blog">
								<a class="blog-thumb mb-20 zoom-in d-block overflow-hidden"
									href="SeeCat?id=1&titre=Femme"> <img
									src="assets/img/blog-post/femme.jpg" alt="blog-thumb-naile" />
								</a>
								<div class="blog-post-content">
									<a
										class="blog-link theme-color d-inline-block mb-10 text-uppercase"
										href="SeeCat?id=1&titre=Femme">${ cat1.titre }</a>
								</div>
							</div>
						</div>
						</c:if>
						<c:if test="${ cat2.del!=true }">
						<div class="slider-item">
							<div class="single-blog">
								<a class="blog-thumb mb-20 zoom-in d-block overflow-hidden"
									href="SeeCat?id=2&titre=Homme"> <img
									src="assets/img/blog-post/homme.jpg" alt="blog-thumb-naile" />
								</a>
								<div class="blog-post-content">
									<a
										class="blog-link theme-color d-inline-block mb-10 text-uppercase"
										href="SeeCat?id=2&titre=Homme">${ cat2.titre }</a>
								</div>
							</div>
						</div>
						</c:if>
						<c:if test="${ cat3.del!=true }">
						<div class="slider-item">
							<div class="single-blog">
								<a class="blog-thumb mb-20 zoom-in d-block overflow-hidden"
									href="SeeCat?id=3&titre=Enfant"> <img
									src="assets/img/blog-post/enfant.jpg" alt="blog-thumb-naile" />
								</a>
								<div class="blog-post-content">
									<a
										class="blog-link theme-color d-inline-block mb-10 text-uppercase"
										href="SeeCat?id=3&titre=Enfant">${ cat3.titre }</a>
								</div>
							</div>
						</div>
						</c:if>

					</div>
				</div>
			</div>
		</div>
		</div>
	</section>
	</c:if>
	<!-- blog-section end -->

	<!-- product tab start -->
	<!-- <section class="product-tab bg-white pt-50 pb-80">
		<div class="container">
			<div class="product-tab-nav mb-50">
				<div class="row align-items-center">
					<div class="col-12">
						<div class="section-title text-center">
							<h2 class="title pb-3 mb-3">Nos Produits En Vogues</h2>
							<p class="text">Grâce au systeme de notation clients,
								profitez toujours des meilleurs produits du moment</p>
						</div>
					</div>
					<div class="col-12">
						<nav class="product-tab-menu theme1">
							<ul class="nav nav-pills justify-content-center" id="pills-tab"
								role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="pills-home-tab" data-toggle="pill" href="#pills-home"
									role="tab" aria-controls="pills-home" aria-selected="true">new
										products</a></li>
								<li class="nav-item"><a class="nav-link"
									id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
									role="tab" aria-controls="pills-profile" aria-selected="false">onsale</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
									role="tab" aria-controls="pills-contact" aria-selected="false">upcoming
										products</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			product-tab-nav end
			<div class="row">
				<div class="col-12">
					<div class="tab-content" id="pills-tabContent">
						first tab-pane
						<div class="tab-pane fade show active" id="pills-home"
							role="tabpanel" aria-labelledby="pills-home-tab">
							<div class="product-slider-init theme1 slick-nav">
								boucler ici
								<div class="slider-item">
									<div class="card product-card">
										<div class="card-body p-0">
											<div class="media flex-column">
												<div class="product-thumbnail position-relative">
													<span class="badge badge-danger top-right">New</span> <a
														href="single-product.html"> <img class="first-img"
														src="assets/img/product/1.png" alt="thumbnail" />
													</a>
													product links
													<ul class="actions d-flex justify-content-center">
														<li><a class="action" href="wishlist.html"> <span
																data-toggle="tooltip" data-placement="bottom"
																title="add to wishlist" class="icon-heart">
															</span>
														</a></li>
														<li><a class="action" href="#" data-toggle="modal"
															data-target="#compare">
																<span data-toggle="tooltip" data-placement="bottom"
																title="Add to compare" class="icon-shuffle"></span>
														</a></li>
														<li><a class="action" href="#" data-toggle="modal"
															data-target="#quick-view">
																<span data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>
													</ul>
													product links end
												</div>
												<div class="media-body">
													<div class="product-desc">
														<h3 class="title">
															<a href="shop-grid-4-column.html">All
																Natural Makeup Beauty Cosmetics</a>
														</h3>
														<div class="star-rating">
															<span class="ion-ios-star"></span> <span
																class="ion-ios-star"></span> <span class="ion-ios-star"></span>
															<span class="ion-ios-star"></span> <span
																class="ion-ios-star de-selected"></span>
														</div>
														<div
															class="d-flex align-items-center justify-content-between">
															<span class="product-price">$11.90</span>
															<button class="pro-btn" data-toggle="modal"
																data-target="#add-to-cart">
																<i class="icon-basket"></i>
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						second tab-pane
						<div class="tab-pane fade" id="pills-profile" role="tabpanel"
							aria-labelledby="pills-profile-tab">
							<div class="product-slider-init theme1 slick-nav">
								boucler ici
								<div class="slider-item">
									<div class="card product-card">
										<div class="card-body p-0">
											<div class="media flex-column">
												<div class="product-thumbnail position-relative">
													<span class="badge badge-danger top-right">New</span> <a
														href="single-product.html"> <img class="first-img"
														src="assets/img/product/1.png" alt="thumbnail" />
													</a>
													product links
													<ul class="actions d-flex justify-content-center">
														<li><a class="action" href="wishlist.html"> <span
																data-toggle="tooltip" data-placement="bottom"
																title="add to wishlist" class="icon-heart">
															</span>
														</a></li>
														<li><a class="action" href="#" data-toggle="modal"
															data-target="#compare">
																<span data-toggle="tooltip" data-placement="bottom"
																title="Add to compare" class="icon-shuffle"></span>
														</a></li>
														<li><a class="action" href="#" data-toggle="modal"
															data-target="#quick-view">
																<span data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>
													</ul>
													product links end
												</div>
												<div class="media-body">
													<div class="product-desc">
														<h3 class="title">
															<a href="shop-grid-4-column.html">All
																Natural Makeup Beauty Cosmetics</a>
														</h3>
														<div class="star-rating">
															<span class="ion-ios-star"></span> <span
																class="ion-ios-star"></span> <span class="ion-ios-star"></span>
															<span class="ion-ios-star"></span> <span
																class="ion-ios-star de-selected"></span>
														</div>
														<div
															class="d-flex align-items-center justify-content-between">
															<span class="product-price">$11.90</span>
															<button class="pro-btn" data-toggle="modal"
																data-target="#add-to-cart">
																<i class="icon-basket"></i>
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						third tab-pane
						<div class="tab-pane fade" id="pills-contact" role="tabpanel"
							aria-labelledby="pills-contact-tab">
							<div class="product-slider-init theme1 slick-nav">
								boucler ici
								<div class="slider-item">
									<div class="card product-card">
										<div class="card-body p-0">
											<div class="media flex-column">
												<div class="product-thumbnail position-relative">
													<span class="badge badge-danger top-right">New</span> <a
														href="single-product.html"> <img class="first-img"
														src="assets/img/product/1.png" alt="thumbnail" />
													</a>
													product links
													<ul class="actions d-flex justify-content-center">
														<li><a class="action" href="wishlist.html"> <span
																data-toggle="tooltip" data-placement="bottom"
																title="add to wishlist" class="icon-heart">
															</span>
														</a></li>
														<li><a class="action" href="#" data-toggle="modal"
															data-target="#compare">
																<span data-toggle="tooltip" data-placement="bottom"
																title="Add to compare" class="icon-shuffle"></span>
														</a></li>
														<li><a class="action" href="#" data-toggle="modal"
															data-target="#quick-view">
																<span data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>
													</ul>
													product links end
												</div>
												<div class="media-body">
													<div class="product-desc">
														<h3 class="title">
															<a href="shop-grid-4-column.html">All
																Natural Makeup Beauty Cosmetics</a>
														</h3>
														<div class="star-rating">
															<span class="ion-ios-star"></span> <span
																class="ion-ios-star"></span> <span class="ion-ios-star"></span>
															<span class="ion-ios-star"></span> <span
																class="ion-ios-star de-selected"></span>
														</div>
														<div
															class="d-flex align-items-center justify-content-between">
															<span class="product-price">$11.90</span>
															<button class="pro-btn" data-toggle="modal"
																data-target="#add-to-cart">
																<i class="icon-basket"></i>
															</button>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> -->
	<!-- product tab end -->

	<!-- product tab start -->
	<div class="product-tab bg-white py-80 pb-50">
		<div class="container">
			<div class="row d-flex justify-content-center">
			<div class="col-12">
					<div class="section-title text-center">
						<h2 class="title pb-3 mb-3">Nos Produits</h2>
						<p class="text">Parcourez notre boutique en toute simplicité</p>
					</div>
				</div>
				<%-- <div class="col-lg-3 mb-30 order-lg-first">
					<aside class="left-sidebar theme1">
						<!-- search-filter start -->
						<div class="search-filter">
							<div class="sidbar-widget pt-0">
								<h4 class="title">Bijoux</h4>
							</div>
						</div>

						<ul id="offcanvas-menu2" class="blog-ctry-menu">
							<c:forEach var="cat" items="${requestScope['cats']}">
								<!--boucle sur les catégories-->
								<li><a href="javascript:void(0)">${ cat.titre }</a>
									<ul class="category-sub-menu">
										<!--boucle sur les sous-catégories-->
										<c:set var="sscat" value="${ cat.ciblesscat() }" scope="page"></c:set>
										<c:forEach var="sscate" items="${sscat}">
											<li><a href="#">${ sscate.titre }</a></li>
										</c:forEach>
									</ul></li>
							</c:forEach>
						</ul>

						<!-- search-filter end -->
						<div class="product-widget mb-60 mt-30">
							<h3 class="title">Product Tags</h3>
							<ul class="product-tag d-flex flex-wrap">
								<li><a href="#">shopping</a></li>
								<li><a href="#">New products</a></li>
								<li><a href="#">Accessories</a></li>
								<li><a href="#">sale</a></li>
							</ul>
						</div>
						<!--second banner start-->
						<div
							class="banner hover-animation position-relative overflow-hidden">
							<a href="shop-grid-4-column.html" class="d-block"> <img
								src="assets/img/banner/2.jpg" alt="img" />
							</a>
						</div>
						<!--second banner end-->
					</aside>
				</div> --%>
				<div class="col-9 mb-30">
					<!-- <div class="grid-nav-wraper bg-lighten2 mb-30">
						<div class="row align-items-center">
							<div class="col-12 col-md-6 mb-3 mb-md-0">
								<nav class="shop-grid-nav">
									<ul class="nav nav-pills align-items-center" id="pills-tab"
										role="tablist">
										<li>
                    <span class="total-products text-capitalize"
                      >There are 13 products.</span
                    >
                  </li>
									</ul>
								</nav>
							</div>
							<div class="col-12 col-md-6 position-relative">
								<div class="shop-grid-button d-flex align-items-center">
									<span class="sort-by">Sort by:</span> <select
										class="form-select custom-select"
										aria-label="Default select example">
										<option selected>Open this select menu</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
							</div>
						</div>
					</div> -->
					<!-- product-tab-nav end -->
					<div class="tab-content" id="pills-tabContent">
						<!-- first tab-pane -->
						<div class="tab-pane fade show active" id="pills-home"
							role="tabpanel" aria-labelledby="pills-home-tab">
							<div class="row grid-view theme1">
							<c:if test="${ first==false }">
								<c:forEach var="prod" items="${requestScope['prods']}">
								<c:set var="maVariable" value="${prod.id}" scope="page"></c:set>
									<!--Boucler sur les produits ici-->
									<div class="col-sm-6 col-lg-4 mb-30">
										<div class="card product-card">
											<div class="card-body">
												<div class="product-thumbnail position-relative">
													<span class="badge badge-danger top-right">New</span> <a
														href="SeeProduit?id=${prod.id}"> <img class="first-img"
														src="${prod.img}" alt="thumbnail" />
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
                      <a   class="action" href="Index">
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
                          <a  class="action " href="Index" >
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
													<h3 class="title" style="height: 48px">
														<a href="SeeProduit?id=${prod.id}">${prod.titre}</a>
													</h3>
													
													<div
														class="d-flex align-items-center justify-content-between">
														<span class="product-price">${prod.prix}€</span>
														<form method="POST">
															<button type="submit" name="padd" value="${prod.id}"
																class="pro-btn" data-toggle="modal"
																data-target="#add-to-cart">
																<i class="icon-basket"></i>
															</button>
														</form>
													</div>
												</div>
											</div>
										</div>
										<!-- product-list End -->
									</div>
									<!-- modal by prods -->
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
																<div class="single-product">
																	<div class="product-thumb">
																		<img src="assets/img/slider/thumb/2.jpg"
																			alt="product-thumb" />
																	</div>
																</div>
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
																		<a href="#"><i class="icon-heart"></i> Add to
																			wishlist</a>
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
								
								</c:forEach></c:if>
								<c:forEach var="prod" items="${requestScope['voirprods']}">
								<c:set var="maVariable" value="${prod.id}" scope="page"></c:set>
									<!--Boucler sur les produits ici-->
									<div class="col-sm-6 col-lg-4 mb-30">
										<div class="card product-card">
											<div class="card-body">
												<div class="product-thumbnail position-relative">
													<span class="badge badge-danger top-right">New</span> <a
														href="SeeProduit?id=${prod.id}"> <img class="first-img"
														src="${prod.img}" alt="thumbnail" />
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
                      <a   class="action" href="Index">
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
                          <a  class="action " href="Index" >
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
													<h3 class="title" style="height: 48px">
														<a href="SeeProduit?id=${prod.id}">${prod.titre}</a>
													</h3>
													
													<div
														class="d-flex align-items-center justify-content-between">
														<span class="product-price">${prod.prix}€</span>
														<form method="POST">
															<button type="submit" name="padd" value="${prod.id}"
																class="pro-btn" data-toggle="modal"
																data-target="#add-to-cart">
																<i class="icon-basket"></i>
															</button>
														</form>
													</div>
												</div>
											</div>
										</div>
										<!-- product-list End -->
									</div>
									<!-- modal by prods -->
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
																<div class="single-product">
																	<div class="product-thumb">
																		<img src="assets/img/slider/thumb/2.jpg"
																			alt="product-thumb" />
																	</div>
																</div>
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
																			<input type="number" min="1" step="1"
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
																		<a href="#"><i class="icon-heart"></i> Add to
																			wishlist</a>
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
								<div class="row">
      <div class="col-12">
        <nav class="pagination-section mt-30 mb-30">
          <ul class="pagination justify-content-center">


            <li class="page-item"><form method="POST"><button type="submit" name="voirplus" value="${maVariable }" class="btn btn-dark btn--md">Charger plus</button></form></li>

          </ul>
        </nav>
      </div>
    </div>
							</div>
						</div>
						<!-- second tab-pane mar -->

						<!-- marche pas sur l'index a cause du sass lie a une certaine page enfin le fait est que j'ai essaye rien n'y a fait -->

					</div>
				</div>
				
			</div>
		</div>
	</div>
	<!-- product tab end -->

	<!-- staic media start -->
	<section class="static-media-section bg-white">
		<div class="container">
			<div class="static-media-wrap theme-bg">
				<div class="row">
					<div class="col-lg-3 col-sm-6 py-3">
						<div class="d-flex static-media2 flex-column flex-sm-row">
							<img class="align-self-center mb-2 mb-sm-0 mr-auto mr-sm-3"
								src="assets/img/icon/2.png" alt="icon" />
							<div class="media-body">
								<h4 class="title">Free Shipping</h4>
								<p class="text">On all orders over $75.00</p>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 py-3">
						<div class="d-flex static-media2 flex-column flex-sm-row">
							<img class="align-self-center mb-2 mb-sm-0 mr-auto mr-sm-3"
								src="assets/img/icon/3.png" alt="icon" />
							<div class="media-body">
								<h4 class="title">Free Returns</h4>
								<p class="text">Returns are free within 9 days</p>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 py-3">
						<div class="d-flex static-media2 flex-column flex-sm-row">
							<img class="align-self-center mb-2 mb-sm-0 mr-auto mr-sm-3"
								src="assets/img/icon/4.png" alt="icon" />
							<div class="media-body">
								<h4 class="title">100% Payment Secure</h4>
								<p class="text">Your payment are safe with us.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 py-3">
						<div class="d-flex static-media2 flex-column flex-sm-row">
							<img class="align-self-center mb-2 mb-sm-0 mr-auto mr-sm-3"
								src="assets/img/icon/5.png" alt="icon" />
							<div class="media-body">
								<h4 class="title">Support 24/7</h4>
								<p class="text">Contact us 24 hours a day</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- staic media end -->

	<!-- footer strat -->
	<jsp:include page="/Footer" />
	<!-- footer end -->

	<!-- modals start -->
	<!-- first modal -->

	<!-- second modal -->
	
	<!-- modals end -->

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