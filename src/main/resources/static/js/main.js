$("#jsi-top-btn").on("click",function(){
 $('html,body').animate({scrollTop:0},500);
});

$("#jsi-down-btn").on("click",function(){
 $('html,body').animate({scrollTop:$(document).height()},500);
});