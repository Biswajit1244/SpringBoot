<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WELCOME TO PRODUCT REGISTER PAGE!!</h3>
	<form action="save" method="POST">
		<pre>
ID : <input type="text" name="prodId" />
CODE : <input type="text" name="prodCode" />
COST : <input type="text" name="prodCost" />
MODEL:
<input type="radio" name="prodModel" value="HIGH"> HIGH
<input type="radio" name="prodModel" value="MID"> MID
<input type="radio" name="prodModel" value="LOW"> LOW
Description:
 <textarea name="prodDesc"></textarea>
FORMAT:
 <select name="prodFormat">
 <option>RED</option>
 <option>GREEN</option>
 <option>BLUE</option>
 </select>
GRADES:
 <input type="checkbox" name="prodGrd" value="A"> A
 <input type="checkbox" name="prodGrd" value="B"> B
 <input type="checkbox" name="prodGrd" value="C"> C
 <input type="checkbox" name="prodGrd" value="D"> D
BRANDS:
 <select name="prodBrnd" multiple="multiple">
 <option>VNR</option>
 <option>XYZ</option>
 <option>NIT</option>
 <option>DRM</option>
 </select>

<input type="submit" value="Add Product" />
</pre>
	</form>
</body>
</html>