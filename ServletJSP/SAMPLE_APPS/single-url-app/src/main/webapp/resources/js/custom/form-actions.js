/**
 * This file will hadle the form actions made through the Javascript
 */
$(document).ready(function(){

	$(".rstClick").on("click",function(){
		return false;
	});
	
	$(".subFrm").on("click",function(){
		var frm = $(document.createElement('form'));
		$(frm).attr("action","home");
		$(frm).attr("method","post");
		var input = $("<input />").attr("type","hidden").attr("name","pump").val($(this).prop('href'));
		$(frm).append($(input));
		$(frm).submit().remove();
	});	
	
});