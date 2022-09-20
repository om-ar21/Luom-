<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zxx">

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

<!-- header start -->
<jsp:include page="/Header" />
<jsp:include page="/MiniCart"/>
<!-- header end -->

<!-- breadcrumb-section start -->
<nav class="breadcrumb-section theme1 bg-lighten2 pt-30 pb-30" style="background-color: aliceblue;">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="section-title text-center">
          <h2 class="title pb-4 text-dark text-capitalize">
            ${ produit.titre }
          </h2>
        </div>
      </div>
      <div class="col-12">
        <ol
          class="breadcrumb bg-transparent m-0 p-0 align-items-center justify-content-center"
        >
          <li class="breadcrumb-item"><a href="Index">Home</a></li>
          <li class="breadcrumb-item"><a href="SeeCat?id=${cate.id}&titre=${cate.titre}">${ cate.titre }</a></li>
          <li class="breadcrumb-item"><a href="SeeSscat?id=${sscate.id}&titre=${sscate.titre}">${ sscate.titre }</a></li>
          <li class="breadcrumb-item active" aria-current="page">
          REF ${ produit.id }
          </li>
        </ol>
      </div>
    </div>
  </div>
</nav>
<!-- breadcrumb-section end -->


<!-- product-single start -->
<section class="product-single theme1" style="margin-top:27px;">
  <div class="container">
    <div class="row">
      <div class="col-lg-4 mb-5 mb-lg-0">
        <div>
          <div class="position-relative">
            <span class="badge badge-danger top-right">New</span>
          </div>
          <div class="product-sync-init mb-20">
            <div class="single-product">
              <div class="product-thumb">
                <img src="${ produit.img }" alt="product-thumb" />
              </div>
            </div>
            <!-- single-product end -->
            <!--boucler les images ici car la premiere sera toujours l'image principale-->
            <c:forEach var="img" items="${requestScope['imgs']}" >
            <div class="single-product">
              <div class="product-thumb">
                <img src="${ img.lien }" alt="product-thumb" />
              </div>
            </div>
            </c:forEach>
            <!-- single-product end -->
            
          </div>
        </div>
        <div class="product-sync-nav single-product">
          <div class="single-product">
            <div class="product-thumb">
              <a href="javascript:void(0)">
                <img src="${ produit.img }" alt="product-thumb"
              /></a>
            </div>
          </div>
          <!-- single-product end -->
          <c:forEach var="img" items="${requestScope['imgs']}" >
          <!--boucler les images ici car la premiere sera toujours l'image principale-->
          <div class="single-product">
            <div class="product-thumb">
              <a href="javascript:void(0)">
                <img src="${ img.lien }" alt="product-thumb"
              /></a>
            </div>
          </div>
          </c:forEach>
          <!-- single-product end -->
          
        </div>
      </div>
      <div class="col-lg-8 d-flex justify-content-center">
        <div class="single-product-info" style="padding-left:10px; padding-right:10px;">
          <div class="single-product-head">
            <h2 class="title mb-20">${ produit.titre }</h2>
            <div class="star-content mb-20">
            <c:choose>
			<c:when test="${ empty requestScope['comprods'] }">Produit non noté</c:when>
			<c:otherwise>
            <c:forEach var="i" begin="1" end="${ requestScope.rate }">
                                           			<span class="star-on"><i class="ion-ios-star"></i> </span>
                                        			</c:forEach>
                                        			<c:forEach begin="${ requestScope.rate }" end="4">
                                        			<span class="star-on de-selected"><i class="ion-ios-star"></i> </span>
                                        			
                                        			</c:forEach>
                                        			</c:otherwise>
                                        			</c:choose>
              <a href="#section_further_down"
                ><span class="ml-2"><i class="far fa-comment-dots"></i></span>
                Lire commentaires <!-- <span>(1)</span> --></a
              >
              <c:if test="${ sessionScope.isConnected==true }"><c:choose>
              <c:when test="${ requestScope.mycom!=null }">
              	<span class="edite ml-2"><i class="far fa-edit"></i>
              	Vous avez déjà commenté
              	</span>
              	</c:when>
              	<c:otherwise>
              <a href="#section_further_down"
                ><span class="edite ml-2"><i class="far fa-edit"></i></span> Ecrire un commentaire</a
              ></c:otherwise></c:choose></c:if>
            </div>
          </div>
          <div class="product-body mb-40">
            <div class="d-flex align-items-center mb-30">
              <span class="product-price mr-20"
                ><!--<del class="del">${ produit.prix }€</del>-->
                <span class="onsale">${ produit.prix }€</span>
                <c:choose>
                
                <c:when test="${ produit.stock<produit.stock_minimum && produit.stock!=0 && qcom==0 }"><span class="badge btn-warning" style="margin-left:7px;">Stock limité : ${ produit.stock }</span></c:when>
                <c:when test="${ produit.stock==0 && qcom==0 }"><span class="badge btn-danger" style="margin-left:7px;">Stock épuisé</span></c:when>
                <c:when test="${ qcom!=0 }"><span class="badge btn-success" style="margin-left:7px;">Réapprovisionnement en cours</span>
                
                <c:choose>
                
                <c:when test="${ produit.stock<produit.stock_minimum && produit.stock!=0 }"><span class="badge btn-warning" style="margin-left:214px;">Stock limité : ${ produit.stock }</span></c:when>
                <c:when test="${ produit.stock==0 }"><span class="badge btn-danger" style="margin-left:214px;">Stock épuisé</span></c:when>
                <c:otherwise>
                <span class="badge btn-dark" style="margin-left:214px;">Disponible : ${ produit.stock }</span></c:otherwise>
                </c:choose>
                
                
                </c:when>
                <c:otherwise>
                <span class="badge btn-dark" style="margin-left:7px;">Disponible : ${ produit.stock }</span></c:otherwise>
                
                
                </c:choose>
                </span
              >
             
              <!-- <span class="badge position-static bg-dark rounded-0"
                >Save 10%</span
              >-->
            </div>
            
            <p>
              ${produit.presentation}
            </p>
            
          </div>
          <div class="product-footer">
            <div
              class="product-count style d-flex flex-column flex-sm-row mt-30 mb-30"
            >
            <c:if test="${ produit.stock!=0 }">
            <form method="POST">
              <div class="count d-flex">
                <input type="number" min="1" step="1" value="1" max="${ produit.stock }" name="newqte" />
                <div class="button-group">
                  <a class="count-btn increment">
                    <i class="fas fa-chevron-up"></i>
                  </a>
                  <a class="count-btn decrement">
                    <i class="fas fa-chevron-down"></i>
                  </a>
                </div>
                <button type="submit" name="paddqte" class="btn btn-dark btn--xl mt-sm-0">
                  <span class="mr-2"><i class="ion-android-add"></i></span>
                  Ajouter au panier
                </button>
              </div>
              
              </form></c:if>
            </div>
            <c:if test="${ sessionScope.isConnected==true }">
													<c:set var="idprod" value="${ produit.id }" scope="page"></c:set>
													<c:set var="f" value="${ produit.getFavoris(idprod) }" scope="page"></c:set>
                     <c:choose>
                     <c:when test="${ f.fav==1 && f.id_user==sessionScope.userid && f.id_produit==produit.id}">
                      <form method="POST">
                      <li>
                      <a   class="action" href="Index">
                      <button type="submit" data-toggle="tooltip"
                              data-placement="bottom"
                              name="btnrmv"
                               title="remove from wishlist" 
                               style="color: rgb(234, 115, 23);">&#10084;</button>
                               <input type="hidden" name="idp" value="${produit.id}" />
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
                            <input type="hidden" name="idp" value="${produit.id}" />
                          </a>
                        </li> 
                       </form>
                      
                     
                        
                        
                      </c:otherwise>
                      </c:choose>
                      </c:if>
                      

            <div class="pro-social-links mt-10">
              <ul class="d-flex align-items-center">
                <li class="share">Share</li>
                <li>
                  <a href="#"><i class="ion-social-facebook"></i></a>
                </li>
                <li>
                  <a href="#"><i class="ion-social-twitter"></i></a>
                </li>
                <li>
                  <a href="#"><i class="ion-social-google"></i></a>
                </li>
                <li>
                  <a href="#"><i class="ion-social-pinterest"></i></a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<section class="theme1 bg-white pt-60 pb-80">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="section-title text-center">
          <h2 class="title pb-3 mb-3">Produits pouvant vous plaire</h2>
        </div>
      </div>
      <div class="col-12">
        <div class="product-slider-init theme1 slick-nav">
          <!--boucler ici-->
          <c:forEach var="pcat" items="${requestScope['prodscat']}" >
          <c:if test="${pcat.id!=produit.id}">
          <div class="slider-item">
            <div class="card product-card">
              <div class="card-body p-0">
                <div class="media flex-column">
                  <div class="product-thumbnail position-relative">
                  

                  
                    <span class="badge badge-danger top-right">New</span>
                    <a href="SeeProduit?id=${pcat.id}">
                    
                      <img
                        class="first-img"
                        src="${ pcat.img }"
                        alt="thumbnail"
                        style="width: 300px;height: 300px"
                      />
                    </a>
                    <!-- product links -->
                    <ul class="actions d-flex justify-content-center">
                      <c:if test="${ sessionScope.isConnected==true }">
													<c:set var="idprod" value="${ pcat.id }" scope="page"></c:set>
													<c:set var="f" value="${ pcat.getFavoris(idprod) }" scope="page"></c:set>
                     <c:choose>
                     <c:when test="${ f.fav==1 && f.id_user==sessionScope.userid && f.id_produit==pcat.id}">
                      <form method="POST">
                      <li>
                      <a   class="action" href="Index">
                      <button type="submit" data-toggle="tooltip"
                              data-placement="bottom"
                              name="btnrmv"
                               title="remove from wishlist" 
                               style="color: rgb(234, 115, 23);">&#10084;</button>
                               <input type="hidden" name="idp" value="${pcat.id}" />
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
                            <input type="hidden" name="idp" value="${pcat.id}" />
                          </a>
                        </li> 
                       </form>
                      
                      </c:otherwise>
                      </c:choose>
                      </c:if>
                      
                      <li><a class="action" href="#" data-toggle="modal"
															data-target="#quick-view${pcat.id}">

																<span data-toggle="tooltip" data-placement="bottom"
																title="Quick view" class="icon-magnifier"></span>
														</a></li>
                      
                    </ul>
                    
                    
                    <!-- product links end-->
                  </div>
                  <div class="media-body">
                    <div class="product-desc" id="section_further_down">
                      <h3 class="title" style="height: 48px">
                        <a href="SeeProduit?id=${pcat.id}"
                          >${ pcat.titre }</a
                        >
                      </h3>
                      
                        <span class="product-price">${pcat.prix}€</span>
                        <form method="POST" >
															<button type="submit" name="padd" value="${pcat.id}"
																class="pro-btn" data-toggle="modal"
																data-target="#add-to-cart">
																<i class="icon-basket"></i>
															</button>
														</form>
                          
                      
                    </div>
                  </div>
                  

                  
                </div>
              </div>
            </div>
          </div>
          </c:if>
          
                            
          
          </c:forEach>
          <!-- slider-item end -->
        </div>
      </div>
    </div>
  </div>
</section>
<!-- product-single end -->
<!-- product tab start -->
<div class="product-tab theme1 bg-white pb-80">
  <div class="container">
    <div class="product-tab-nav">
      <div class="row align-items-center">
        <div class="col-12">
          <nav class="product-tab-menu single-product">
            <ul
              class="nav nav-pills justify-content-center"
              id="pills-tab"
              role="tablist"
            >
              <li class="nav-item">
                <a
                  class="nav-link"
                  id="pills-home-tab"
                  data-toggle="pill"
                  href="#pills-home"
                  role="tab"
                  aria-controls="pills-home"
                  aria-selected="true"
                  >Description</a
                >
              </li>
              
              <li class="nav-item">
                <a
                  class="nav-link active"
                  id="pills-contact-tab"
                  data-toggle="pill"
                  href="#pills-contact"
                  role="tab"
                  aria-controls="pills-contact"
                  aria-selected="false"
                  >Commentaires</a
                >
              </li>

			  <!-- a cacher quand il est pas co et quand il n'a pas commenté -->
			  <c:if test="${ !empty sessionScope.usernom && requestScope.mycom!=null }">
              <li class="nav-item">
                <a
                  class="nav-link"
                  id="Mypills-contact-tab"
                  data-toggle="pill"
                  href="#Mypills-contact"
                  role="tab"
                  aria-controls="Mypills-contact"
                  aria-selected="false"
                  >Mon Commentaire</a
                >
              </li>
              </c:if>
            </ul>
          </nav>
        </div>
      </div>
    </div>
    <!-- product-tab-nav end -->
    <div class="row">
      <div class="col-12">
        <div class="tab-content" id="pills-tabContent">
          <!-- first tab-pane -->
          <div
            class="tab-pane fade"
            id="pills-home"
            role="tabpanel"
            aria-labelledby="pills-home-tab"
          >
            <div class="single-product-desc">
              <p>
                ${produit.presentation}
              </p>
            </div>
          </div>
          <!-- second tab-pane -->
          
          <!-- third tab-pane -->
          <div
            class="tab-pane fade show active"
            id="pills-contact"
            role="tabpanel"
            aria-labelledby="pills-contact-tab"
          >
            <div class="single-product-desc">
              <div class="row">
              
              <%-- <c:if test="${ok==true }">
                              <div class="alert alert-success mt-2 text-center" role="alert">Le commentaire à bien été supprimé.</div>
                            	</c:if> --%>
                            	
              <c:if test="${ empty sessionScope.usernom}">
                <div class="col-12 pb-30 d-flex justify-content-center">
              	Veuillez vous <a href="Connexion" style="padding-left: 7px;padding-right: 7px;"><b>connecter</b></a> pour rediger un commentaire ou faire une opération sur le vôtre.
              	
              	</div>
              	</c:if>
              	<c:if test="${ requestScope.mycom!=null }">
              	<%-- <form method="POST">
              	<c:if test="${sure==true }">
                              <div class="alert alert-warning mt-2 text-center" role="alert">êtes-vous sur ? cette opération est irréversible <button type="submit" name="yes" class="btn btn-success btn-sm" style="margin-right:7px; margin-left:7px">Oui</button> <button type="submit" name="non" class="btn btn-danger btn-sm">Non</button></div>
                            	</c:if></form> --%>
              	
                            	<%-- <c:if test="${ok==false }">
                              <div class="alert alert-warning mt-2 text-center" role="alert">Le commentaire n'a pas été supprimé conformément à vos souhaits.</div>
                            	</c:if> --%>
              	<div class="col-12 pb-30 d-flex justify-content-center">
              	Vous avez déjà commenté cet article, pour modifier votre commentaire veuillez allez sur l'onglet mon commentaire.
              	
              	
              	</div>
              	
              	
              	</c:if>
              	<c:choose>
              	<c:when test="${ requestScope.mycom!=null || empty sessionScope.usernom}">
                <div class="review-wrapper col-lg-12 d-flex justify-content-center">
                <div>
                  
                    <!--boucler ici-->
                    <c:if test="${empty requestScope['comprods']}">Aucuns commentaires pour le moment</c:if>
                    <c:forEach var="com" items="${requestScope['comprods']}" >
                    <div class="single-review">
                    <div class="d-flex justify-content-center">
                	<div>
                      <div class="review-content">
                        <div class="review-top-wrap p-2">
                          <div class="review-left">
                            <div class="review-name">
                              <h4>${ com.getUser().nom } ${ com.getUser().prenom }</h4>
                            </div>
                            <div class="rating-product">
                            <c:forEach var="i" begin="1" end="${ com.note }">
                            <span class="star-on"><i class="ion-ios-star"></i> </span>
			              	</c:forEach>
			              	<c:forEach begin="${ com.note }" end="4">
                                        			<span class="star-on de-selected"><i class="ion-ios-star"></i> </span>
                                        			
                                        			</c:forEach>
                           
                            </div>
                          </div>
                          
                        </div>
                        <div class="p-2">
                          <p>
                            ${ com.contenu }
                          </p>
                        </div>
                        <div class="p-2">
                          <p>
                            ${ com.day }
                          </p>
                        </div>
                      </div>
                    </div>
                    </div>
                    </div>
                    </c:forEach>
                    
                  
                </div>
                </div>
                </c:when>
                
                <c:otherwise>
                <div class="review-wrapper col-lg-7 d-flex justify-content-center">
                <div>
                    <!--boucler ici-->
                    <c:if test="${empty requestScope['comprods']}">Aucuns commentaires pour le moment</c:if>
                    <c:forEach var="com" items="${requestScope['comprods']}" >
                    <div class="single-review">
                    <div class="d-flex justify-content-center">
                	<div>
                      <div class="review-content">
                        <div class="review-top-wrap p-2">
                          <div class="review-left">
                            <div class="review-name">
                              <h4>${ com.getUser().nom } ${ com.getUser().prenom }</h4>
                            </div>
                            <div class="rating-product">
                            <c:forEach var="i" begin="1" end="${ com.note }">
                            <span class="star-on"><i class="ion-ios-star"></i> </span>
			              	</c:forEach>
			              	<c:forEach begin="${ com.note }" end="4">
                                        			<span class="star-on de-selected"><i class="ion-ios-star"></i> </span>
                                        			
                                        			</c:forEach>
                           
                            </div>
                          </div>
                          
                        </div>
                        <div class="p-2">
                          <p>
                            ${ com.contenu }
                          </p>
                        </div>
                        <div class="p-2">
                          <p>
                            ${ com.day }
                          </p>
                        </div>
                      </div>
                      </div>
                      </div>
                      </div>
                      <br>
                    
                    </c:forEach>
                    
                  
                </div>
                </div>
                <c:if test="${ !empty sessionScope.usernom && requestScope.mycom==null }">
                <div class="col-lg-5">
                  <div class="ratting-form-wrapper">
                    <h3>Ajouter un commentaire</h3><a id="note0">Réinitialiser note</a>
                    <div class="ratting-form">
                      <form method="post">
                        <div class="star-box">
                        
                          <span>Votre note:</span>
                          <div class="rating-product">
                            <span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span><input type="hidden" id="rating" name="note" min="0" max="5"></span>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-12">
                            <div class="rating-form-style form-submit">
                              <textarea
                                name="message"
                                placeholder="Message"
                              ></textarea>
                              <button type="submit" name="comment" class="btn btn-dark btn--xl mt-5 mt-sm-0">Envoyer</button>
                            </div>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
                </c:if>
                
                
                </c:otherwise>
                
                </c:choose>
                
              </div>
            </div>
          </div>
			
		  <!-- a cacher quand il est pas co et quand il n'a pas commenté -->
		  <c:if test="${ !empty sessionScope.usernom && requestScope.mycom!=null }">
          <div
            class="tab-pane fade"
            id="Mypills-contact"
            role="tabpanel"
            aria-labelledby="Mypills-contact-tab"
          >
          <div class="single-product-desc">
            <div class="row">
              <div class="col-lg-7">
                <div class="review-wrapper">
                
                  <div class="single-review">
                    <div class="review-content">
                      <div class="review-top-wrap">
                        <div class="review-left">
                          <div class="review-name">
                            <h4>${ mycom.getUser().nom } ${ mycom.getUser().prenom }</h4>
                          </div>
                          <div class="rating-product">
                          <c:forEach var="i" begin="1" end="${ mycom.note }">
                            <i class="ion-android-star"></i>
                          </c:forEach>
                          <c:forEach begin="${ mycom.note }" end="4">
                                        			<span class="star-on de-selected"><i class="ion-ios-star"></i> </span>
                                        			
                                        			</c:forEach>
                          </div>
                        </div>
                        
                      </div>
                      <div class="review-bottom">
                        <p>
                          ${ mycom.contenu }
                        </p>
                      </div>
                    </div>
                  </div>
                  
                </div>
              </div>
              <div class="col-lg-5">
                  <div class="ratting-form-wrapper">
                    <h3>Modifier votre commentaire</h3><a id="note0">Réinitialiser note</a>
                    <div class="ratting-form">
                      <form method="post">
                        <div class="star-box">
                        
                          <span>Votre note:</span>
                          <div class="rating-product">
                            <span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span class="star star-on de-selected"><i class="fas fa-star"></i> </span>
			              	<span><input type="hidden" id="rating" name="note" min="0" max="5"></span>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-12">
                            <div class="rating-form-style form-submit">
                              <textarea
                                name="message"
                                placeholder="Message"
                              >${ mycom.contenu }</textarea>
                              <button type="submit" name="modif" class="btn btn-dark btn--xl mt-5 mt-sm-0">Modifier</button>
                              <!-- <button type="submit" name="suppri" class="btn btn-dark btn--xl mt-5 mt-sm-0">Supprimer</button> -->
                              <a class="action btn btn-dark btn--xl mt-5 mt-sm-0" href="#" data-toggle="modal"
															data-target="#quick-viewsure"
															>

																Supprimer
														</a>
                            </div>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              
            </div>
          </div>
          </div>
          </c:if>

        </div>
      </div>
    </div>
  </div>
</div>
<!-- product tab end -->

<c:forEach var="pcat" items="${requestScope['prodscat']}" >
                  <div
  class="modal fade theme1 style1"
  id="quick-view${pcat.id }"
  tabindex="-1"
  role="dialog"
>
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
																		<img src="${pcat.img}"
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
																			src="${pcat.img}"
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
																<a href="SeeProduit?id=${pcat.id}">
																	<h2 class="title">${pcat.titre}</h2></a>
																	<h4 class="sub-title">Disponible: ${pcat.stock}</h4>
																	
																</div>
																<div class="product-body">
																	<span class="product-price text-center"> <span
																		class="new-price">${pcat.prix}€</span>
																	</span>
																	<p>${pcat.presentation}</p>

																</div>
																<div class="d-flex mt-30"></div>
																<div class="product-footer">
																<form method="POST">
																	<div
																		class="product-count style d-flex flex-column flex-sm-row my-4">
																		<div class="count d-flex">
																			<input type="number" min="1" max="${pcat.stock}" step="1"
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
																			<button type="submit" name="paddqte" value="${pcat.id}" class="btn btn-dark btn--xl mt-5 mt-sm-0">
																				<span class="mr-2"><i class="ion-android-add"></i></span>
																				Ajouter
																			</button>
																			<a href="SeeProduit?id=${pcat.id}" class="btn btn-dark btn--xl mt-5 mt-sm-0">
																			
																				<span class="mr-2"><i class="ion-android-add"></i></span>
																				Voir 
																			</a>
																		</div>
																	</div>
																	
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
																	<!-- <div class="addto-whish-list">
																		<a href="#"><i class="icon-heart"></i> Add to
																			wishlist</a>
																	</div> -->
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
</div>
</c:forEach>


<!-- new arrival section start -->

<!-- new arrival section end -->

<!-- footer strat -->
<jsp:include page="/Footer" />
<!-- footer end -->

<!-- modals start -->
<div
  class="modal fade theme1 style1"
  id="quick-viewsure"
  tabindex="-1"
  role="dialog"
>
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
														
														<div class="col-lg-12">
															<div class="modal-product-info">
																<div class="product-head">
																<form method="POST">
              	
                              <div class="alert alert-warning mb-30 text-center" role="alert">êtes-vous sûr ? cette opération est irréversible <button type="submit" name="yes" class="btn btn-success btn-sm" style="margin-right:7px; margin-left:7px">Oui</button> <button type="button" name="non" data-dismiss="modal" class="btn btn-danger btn-sm">Non</button></div>
                            	</form>
																</div>
																<div class="product-body">
																	<h4 class="text-center mb-30">Contenu du commentaire :</h4>
																	<p class="text-center"><b>${ mycom.contenu }</b></p>

																</div>
																
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
									</div>

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
    <script src="assets/js/stars.js"></script>

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