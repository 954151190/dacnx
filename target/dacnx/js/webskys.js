$(function(){
$(".webnav li").not(".licur").hover(function(){$(this).addClass("licur")},function(){$(this).removeClass("licur")});
$("#banlbar").add("#banrbar").hover(function(){$(this).addClass("mhover")},function(){$(this).removeClass("mhover")});

$("#gun").imageScroller({
next:"prev",
prev:"next",
frame:"gunul",
child:"li",
margleftzhi:-130,
auto:true
});







var len=$("#banh li").length;
var jj=0;
$("#banh li:eq(0)").addClass("on");
$("#banlbar").click(function(){jj--;if(jj<0){jj=len-1;}showImg(jj);});
$("#banrbar").click(function(){jj++;if(jj==len){jj=0;}showImg(jj);});
$('.banner').hover(function(){if(MyTime){clearInterval(MyTime);}},function(){MyTime=setInterval(function(){showImg(jj)
jj++;if(jj==len){jj=0;}},3000);});
var MyTime=setInterval(function(){showImg(jj)
jj++;if(jj==len){jj=0;}},3000);

});
function showImg(i){$("#banh li").filter(":visible").fadeOut(100,function(){$("#banh li").eq(i).fadeIn(300);});
$("#banh li").eq(i).addClass("on").siblings().removeClass("on");}
