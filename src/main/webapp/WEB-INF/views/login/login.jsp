<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1 align="center">로그인 폼</h1>
<form action="./loginok.do" method="post">
    <table border="1" align="center">
        <tbody>
        <tr>
            <th>아이디</th>
            <td><input type="text" name="id" placeholder="아이디"></td>

        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pwd" placeholder="비밀번호"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="전송">
                <input type="reset" value="리셋">
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>