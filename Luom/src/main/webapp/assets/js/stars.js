/*function myFunction(){
	alert("essai");
} juste pour test si c'est bien integré et c'est le cas*/

const stars = document.querySelectorAll(".star");
const acacher = document.querySelectorAll(".acacher");
const rating = document.querySelector("#rating");

for (let i=0; i<stars.length; i++){
	stars[i].starValue = (i+1);
	["mouseover","mouseout","click"].forEach(function (e){
		stars[i].addEventListener(e, starRate);
	})
}
let starValue = 0;
document.getElementById("rating").setAttribute('value', starValue);
rating.innerHTML = starValue

function starRate(e){
	let type = e.type;
	starValue = this.starValue;
	
	stars.forEach(function(ele, ind){
		if (type == "click"){
			if(ele.classList.contains("star")){
				ele.classList.add("de-selected");
			}
			
			if(ind < starValue){
				ele.classList.remove("de-selected");
			}
			
			document.getElementById("rating").setAttribute('value', starValue);
			rating.innerHTML = starValue
			console.log(starValue);
			
		}
		
		const reset0 = document.getElementById('note0');
		reset0.addEventListener('click', function handleMouseOver() {
  		starValue = 0;
  		document.getElementById("rating").setAttribute('value', starValue);
  		rating.innerHTML = starValue
  		if(ele.classList.contains("star")){
				ele.classList.add("de-selected");
			}

		});
		
	})
}