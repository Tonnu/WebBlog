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
        <title>Web blog</title>
        <link rel="stylesheet" href="resources/css/WebblogPageLayout.css" /> 

        <%@page import="java.util.List" %> 
        <%@page import="com.sgijsber.webblog.model.Posting" %> 
    </head>
    <body>
        <div id="main_container">
            <div id="header_container">Header</div>
            <div id="left_container">Left container</div>
            <div id="right_container">
                <a href="ShowAdmin">Add Post</a>
            </div>
            <div id="content_container">
                <br />
                <p>View Page</p>
                <div>
                    <c:forEach var="post" items="#{postings}" >
                        <div class="post">
                        <form id="${post.id}">
                            
                            <p class="title"><c:out value="${post.title}"></c:out></p>
                            <p><c:out value="${post.content}"></c:out></p>
                            <p><c:out value="${post.date}"></c:out></p>
                            
                        </form>

                        <c:forEach var="comment" items="#{post.comments}" >
                            <div id="comment.id" class="comment">
                                <p>Reaction no: <c:out value="${comment.id}"></c:out></p>
                                <p><c:out value="${comment.content}"></c:out></p>
                                </div>
                        </c:forEach>
                        <br />
                        <form name="comment_form" action="BlogViewServlet" method="POST">
                            <input name="Comment" type="text" class="comment_textArea"></input>
                            <br />
                            <button name="submit_comment" type="submit"> add Comment </button>
                        </form>
                        <br />
                        </div>
                            <br />
                    </c:forEach>
                </div>
                <br /><br />
            </div>
        </div>
    </body>
</html>
