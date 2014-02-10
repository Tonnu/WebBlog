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
        <link rel="stylesheet" type="text/css" href="css/WebblogPageLayout.css" /> 
        <title>Web Blog Admin Page</title>
        
    </head>
    <body>
        <div id="main_container">
            <div id="header_container">Header</div>
            <div id="left_container"></div>
            <div id="right_container">
                <div id="links">
                <a href="ListBlogs" class="link">Blog page</a><br />
                <a href="ChangeMode" class="link">Change mode</a>
                </div>
            </div>
            <div id="content_container">
                <br />
                <div class="posting_form">
                    
                    <form name="posting_form" action="AddPost" method="POST">
                        <p> Title: </p>
                        <input name="Title" type="text"></input>
                        <br />
                        <p> Posting: </p>
                        <textarea name="Posting"></textarea>
                        <button name="submit_button" type="submit" id="post_button"> add Posting </button>
                    </form>
                </div>
                <br /><br />
            </div>
        </div>
    </body>
</html>
