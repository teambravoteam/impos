$(function() {
	$(".coffee-a").click(function(){
		$(".cake-me").addClass("close");
		$(".cookie-me").addClass("close");
		$(".coffee-me").removeClass("close");
	})
	
	$(".cake-a").click(function(){
		$(".coffee-me").addClass("close");
		$(".cookie-me").addClass("close");
		$(".cake-me").removeClass("close");
	})
	
	$(".cookie-a").click(function(){
		$(".cake-me").addClass("close");
		$(".coffee-me").addClass("close");
		$(".cookie-me").removeClass("close");
	})
	
})
