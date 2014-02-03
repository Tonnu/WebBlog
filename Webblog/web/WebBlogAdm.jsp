<%-- 
    Document   : WebBlogAdm
    Created on : Jan 27, 2014, 2:53:42 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/WebblogPageLayout.css" /> 
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main_container">
            <div id="header_container">Header</div>
            <div id="left_container"></div>
            <div id="right_container"></div>
            <div id="content_container">
                <br />
                <div class="posting_form">
                    <form name="posting_form" action="BlogAdminServlet" method="POST">
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
