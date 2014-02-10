<%-- 
    Document   : listblog_div
    Created on : Feb 10, 2014, 9:54:45 AM
    Author     : user
--%>

<div>
    <c:forEach var="post" items="#{postings}" >
        <div class="post">
            <form id="${post.id}">

                <p class="title"><c:out value="${post.title}"></c:out></p>
                <p><c:out value="${post.content}"></c:out></p>
                <p class="date_text"><c:out value="${post.date}"></c:out></p>

            </form>

            <div id="comment_list_${post.id}">
            </div>
            <br />
            
            <textarea id="Comment_${post.id}" name="Comment" class="comment_textArea"></textarea>
            <input id="hidden_postID_${post.id}" name="hidden_postID" type="hidden" value="${post.id}" />
            <br />
            <input name="submit_comment" type="submit" id="${post.id}" onclick="updateCommentList(this.id)" value="Comment"/>
          
            <br />
        </div>
        <br />
    </c:forEach>
</div>
