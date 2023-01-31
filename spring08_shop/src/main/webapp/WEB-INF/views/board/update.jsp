<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
   $('#update').click(function(){
      $('[name=content]').val($('[name=content]').val().replace(/\n/gi, '<br/>'));
      $('#frm').attr('action','update.do').submit();
   });
});
</script>
<div class="container">
   <form name="frm" id="frm" method="post" enctype="multipart/form-data">
      <table class="table table-bordered mt-1">
         <tr>
            <th>작성자</th>
            <td colspan="3"><input type="text" name="writer" id="writer"
               value="${dto.writer}"  readonly="readonly"/></td>            
         </tr>
         
         <tr>
           <th >등록일</th>
           <td>${dto.reg_date}</td>
         </tr>

         <tr>
            <th>제목</th>
            <td colspan="3"><input type="text" name="subject" id="subject" 
               value="${dto.subject}" /></td>
         </tr>         

         <tr>
            <th>내용</th>
            <td colspan="3">
            <textarea name="content"
                  id="content" rows="13" style="width:100%" >
                  ${dto.content}
            </textarea></td>
         </tr>

         <tr>
            <th>첨부파일</th>
            <td colspan="3"><input type="file" name="filename" /> <span>${fn:substringAfter(dto.upload, "_") }</span>
            </td>
         </tr>
      </table>
      <div class="text-center mt-5 mb-5">
      <input type="hidden" name="num" value="${dto.num}" /> <input
         type="hidden" name="currentPage" value="${currentPage}" /> <input
         type="button" id="update" value="수정" /> <input type="button"
         id="cancel" value="취소" />
         <input type="button" id="back" value="뒤로" />
      </div>   
   </form>
 </div>



