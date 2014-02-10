<%-- 
    Document   : WebBlog
    Created on : Feb 3, 2014, 12:46:24 PM
    Author     : user
--%>

<%@page import="com.sgijsber.webblog.controller.BlogViewServlet"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/WebblogPageLayout.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web blog</title>
        
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/js_listblog.js"></script>
    </head>
    <body>
        <div id="main_container">
            <div id="header_container"></div>
            <div id="left_container">
                <div id="about">
                    <p class="subtitle">About</p>
                </div>
                <div id="pictures">
                    <p class="subtitle">Pictures</p>
                </div>
                <div id="myfriends">
                    <p class="subtitle">My Friends!</p>
                    <p>Nobody</p>
                </div>
            </div>
            <div id="right_container">
                <div id="links">
                <a href="ShowAdmin" class="link">Add Post</a>
                </div>
            </div>
            <div id="content_container">
                <br />
                
                <%@include file="/WEB-INF/templates/div_listblog.jsp" %>        

                <br /><br />
            </div>
        </div>
       
    </body>
</html>
