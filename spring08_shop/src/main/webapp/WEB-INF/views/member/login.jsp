<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 
 <script type="text/javascript" src="../resources/js/jquery.cookie.js"></script>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script>
  $(document).ready(function(){
	  let returnUrl = "${param.returnUrl}";
	  if(returnUrl != "")
		  alert(returnUrl + "요청한 페이지는 회원에게만 제공됩니다.");
	  
	  
	  if("${membersDTO}"){	     
	     $("#email").val("${membersDTO.memberEmail}");
	     $("#rememberEmail").prop('checked',true);	     
	  }
	  
	  
	  $('#rememberEmail').click(function(){
		  let chk = $(this).is(":checked");
		  console.log(chk);
		  if(!chk){
			  $.removeCookie('REMEMBER',  { path: '/' });
		  }
	  });
  });
</script>
 
     <div class="container mb-5">			
		<div class="avatar">
			<!-- <img src="../resources/images/avatar.png" alt="Avatar">  -->
			<i class="fa-solid fa-user-injured fa-6x"></i>
		</div>				
		<h4 class="text-center">Member Login</h4>	
		
			<form name="login" method="post"  action="login.do" >
				<div class="form-group">
					<input type="text" class="form-control" name="memberEmail" placeholder="Email"  id= "email" required="required">		
				</div>
				<div class="form-group mt-3">
					<input type="password" class="form-control" name="memberPass" placeholder="Password" required="required">	
				</div>   
				
				<div class="form-check mt-3">
				<label class="form-check-label" for="rememberEmail">Email 기억하기:</label>
					<input type="checkbox" class="form-check-input" name="rememberEmail" placeholder="rememberEmail" id="rememberEmail" > 
					
				</div> 
				     
				<div class="form-group text-center mt-5">
				    <input type="text" name="returnUrl" value="${param.returnUrl}" /> 
 					<button type="submit" class="btn btn-dark btn-lg btn-block login-btn" >Login</button>
				</div>
			</form>
  </div>
     
  