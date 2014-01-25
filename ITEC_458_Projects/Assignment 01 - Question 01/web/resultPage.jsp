<%-- 
    Document   : resultPage
    Created on : Mar 19, 2008, 7:24:58 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
        <link href="/Assignment_01_-_Question_01/css/site.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="header">
            <br>Certified Mathmatician Exam 1.1<br>&nbsp;
        </div>
        <div align="center">
        <fieldset ><legend style="text-align:center;">Answer Sheet Summary</legend>
            <table width="100%" border="0">
                <tr>
                    <th id="tableHeader" scope="col">Question</th>
                    <th id="tableHeader" scope="col">Correct Answer </th>
                    <th id="tableHeader" scope="col">Your Answer </th>
                    <th id="tableHeader" scope="col">Result</th>
                </tr>
                <c:forEach var="question" items="${questions}" varStatus="stat">
                    <tr class="${stat.count%2 == 0}">
                        <td>${question.questionString}</td>
                        <td>${question.correctAnswer}</td>
                        <td>${question.userAnswer}</td>
                        <td>${question.result}</td>
                    </tr>
                </c:forEach>
            </table>
            <p style="font-weight:bold;color:#000000;">
                Your Score ${score}
            </p>
        </fieldset>
    </div>
    </body>
</html>
