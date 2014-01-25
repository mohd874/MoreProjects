<%-- 
    Document   : index
    Created on : Mar 17, 2008, 8:05:46 PM
    Author     : Saeed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Math Quiz - Question ${questionNumber}</title>
        <link href="/Assignment_01_-_Question_01/css/site.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="header">
            <br>Certified Mathmatician Exam 1.1<br>&nbsp;
        </div>
        <form id="MathForm" name="MathForm" method="post" action="mathServ">
            <input type="hidden" value="${index}" name="index" />
            <fieldset>
                <legend>Question ${questionNumber}</legend>
                <table border="0">
                    <tr>
                        <td>${currentQuestion} = </td>
                        <td><input type="text" name="answer" /></td>
                        <td><input type="submit" name="action" value="Submit" /></td>
                    </tr>
            </table></fieldset>
            <div style="font-weight:bold;font-size:15pt;font-family:Arial;">
            ${questionMessage}
            </div>
        </form>
    </body>
</html>
