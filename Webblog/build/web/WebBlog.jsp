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

                            <div id="comment_list_${post.id}">
                            </div>
                            <br />

                            <!--<form name="comment_form" action="AddComment" method="POST">-->
                                <input id="Comment_${post.id}" name="Comment" type="text" class="comment_textArea" />
                                <input id="hidden_postID_${post.id}" name="hidden_postID" type="hidden" value="${post.id}" />
                                <br />
                                <input name="submit_comment" type="submit" id="${post.id}" onclick="updateCommentList(this.id)" value="Comment"/>
                            <!--</form>-->
                            <br />
                        </div>
                        <br />
                    </c:forEach>
                </div>



                <br /><br />
            </div>
        </div>
        <script>
                    function updateCommentList(newPostID) {
                    var stringPostID = newPostID.toString();
                    commentDiv = '#comment_list_'.concat(stringPostID);
                    
                    $(commentDiv).empty();
                            globalPostID = newPostID;
                            
                            var comment = document.getElementById("Comment_" + newPostID).value;
                           
                            $.getJSON("http://localhost:8080/Webblog/AddComment.json", {postID: String(globalPostID), Comment: comment}, processCommentList);
                            
                            function processCommentList(t) {
                            $.each(t, function(index, data) {
                            var divName = String(globalPostID).concat(data["id"]);
                            $(commentDiv).append("<div id="+divName+"><p>Reaction no:"+data["id"]+"</p><p>"+data["content"]+"</p></div>");
                            $("#"+divName).addClass("comment");
                                });
                            }
                        }
                 
                $(document).ready(function(){
                     
                     $.getJSON("http://localhost:8080/Webblog/ListCommands.json", null, getCommentList);
                     
                     function getCommentList(t) {
                         $.each(t, function(index, data) {
                             var postID = data["id"];
                             
                             var commentDiv = "#comment_list_".concat(data["id"]);
                             $(commentDiv).empty();
                             
                             $.each(data["comments"], function(index,comment) {
                                    var commentDivID = String(postID).concat(comment["id"]);
                                    $(commentDiv).append("<div id="+commentDivID+"><p>Reaction no:"+comment["id"]+"</p><p>"+comment["content"]+"</p></div>");
                                    $("#"+commentDivID).addClass("comment");
                             });
                         });
                     }
                 });
        </script>
    </body>
</html>
