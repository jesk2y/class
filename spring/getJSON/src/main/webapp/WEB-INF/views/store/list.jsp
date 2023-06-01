<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select name="cat" id="cat">
		<option value="">--</option>
		<option value="kor">한식</option>
		<option value="jp">일식</option>
		<option value="ws">양식</option>
	</select>

	<select name="sub" id="sub">
	</select>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
		$("#cat").change(function() {
			var val = $("#cat option:selected").val();
			
			console.log(val);
			$.getJSON("/store/stores", {cat : val}, function(data) {
				console.log(data);
				
				var str = "";
				
				$(data).each(function(idx, obj) {
					str += "<option>" + obj.sname + "</option>";
				});

				$("#sub").html(str);

			});
		});

	</script>
</body>
</html>