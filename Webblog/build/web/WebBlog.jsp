<%-- 
    Document   : WebBlog
    Created on : Feb 3, 2014, 12:46:24 PM
    Author     : user
--%>

<%@page import="com.sgijsber.webblog.controller.BlogViewServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/WebblogPageLayout.css" /> 

        <%@page  import="java.util.List" %> 
        <%@page  import="com.sgijsber.webblog.model.Posting" %> 
    </head>
    <body>
        <div id="main_container">
            <div id="header_container">Header</div>
            <div id="left_container"></div>
            <div id="right_container">
                <a href="/Webblog/WebBlogAdm.jsp">Admin page</a>
            </div>
            <div id="content_container">
                <br />
                <div class="posting_form">
                    <p>View Page</p>

                    <%
                        List<Posting> postings = (List<Posting>) session.getAttribute("postings");
                        
                        if(postings != null){
                            out.println(String.format("<p>%s<p>", postings.toString()));
                        } else {
                            out.println("<p>No postings found</p>");
                        }
                    %>
                    <form name="posting_form" action="BlogViewServlet" method="POST">
                        <p> Title: </p>
                        <input name="Title" type="text"></input>
                        <br />
                        <p> Posting: </p>
                        <input name="Posting" type="text"></input>
                        <button name="submit_button" type="submit" id="post_button"> add Posting </button>
                    </form>
                </div>
                <br /><br />
            </div>
        </div>
    </body>
</html>
