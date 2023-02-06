<%@page import="com.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
table, th, td {
  border:1px solid black;
  border-collapse: collapse;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>

<script type="text/javascript">
 
 	$(document).ready(function () {
		 var i = 0;
		 var $trs = $('#result tr');
		 
		 $trs.each(function() {
		 	var $tds = $(this).find('td');
		 	var width = $tds.length;
		 	var num = 2;
		 	for(i = width - 2; i >= 0; i--) {
		 		if($($tds[i]).html() == $($tds[i + 1]).html() && $($tds[i]).html() != ""){
		 			$($tds[i]).attr('colspan', num);
		 			num++;
		 			$($tds[i + 1]).remove();
		 		} else {
		 			num = 2;
		 		}
		 	}
		 	$tds = $(this).find('td');
		 	width = $tds.length;
		 	$($tds[0]).attr('seq', 0);
		 	for(i = 1; i < width; i++) {
		 		$($tds[i]).attr('seq', parseInt($($tds[i - 1]).attr('seq')) + $($tds[i - 1]).prop('colspan'));
		 	}
		 });
		
		 var height = $trs.length;
		 var j = 0;
		
		 for(i = height - 2; i >= 0; i--){
		 	$($trs[i]).find('td').each(function() {
		 		var seq = parseInt($(this).attr('seq'));
		 		var $tdUnder = $($trs[i + 1]).find('td[seq="' + seq + '"]');
		 		if($tdUnder.length && ($tdUnder.html() != "") && ($tdUnder.html() == $(this).html()) && ($tdUnder.prop('colspan') == $(this).prop('colspan'))) {
		 			$(this).prop('rowspan', $tdUnder.prop('rowspan') + 1);
		             $tdUnder.remove();
		 		}
		 	});
		 }
 	});
   
</script>

<body>

<h1>Welcome <%= session.getAttribute("name") %></h1>

<div id="result">
	<table border ="1" width="500" align="left" id="myTable">
	    <tr bgcolor="#4682b4">
	     <th style="text-align: left;color:white"><b>Department</b></th>
	     <th style="text-align: left;color:white"><b>Student ID</b></th>
	     <th style="text-align: left;color:white"><b>Marks</b></th>
	     <th style="text-align: left;color:white"><b>Pass %</b></th>
	    </tr>
	    <%
	    ArrayList<Student> std = (ArrayList<Student>)request.getAttribute("data"); 
	    for(Student s:std) {%>
	       <tr>
	           <td style="text-align: center;"><%=s.getDepartment()%></td>
	           <td><a href="#" onclick="return alert('<%=s.getName()%>');"><%=s.getStudentId()%></td>
	           <td style="text-align: right;"><%=Integer.toString(s.getMarks())%></td>
	           <td style="text-align: center;"><%=s.getPass()%></td>
	       </tr>
	    <%}%>
	</table> 
</div>

</body>
</html>
