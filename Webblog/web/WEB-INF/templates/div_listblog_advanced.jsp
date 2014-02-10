<%-- 
    Document   : listblog_div
    Created on : Feb 10, 2014, 9:54:45 AM
    Author     : user
--%>

<div>
    <c:forEach var="post" items="#{postings}" >
        <div class="post" id="edit_post_div">
            <form id="${post.id}" name="adv_post_form">

                <p class="title"><c:out value="${post.title}"></c:out></p>

                <textarea id="postcontent_${post.id}">${post.content}</textarea>
                <input name="${post.id}" type="submit" id="edit_${post.id}" onclick="updatePost(this.name)" value="Edit"/>
                <input name="${post.id}" type="submit" id="remove_${post.id}" onclick="removePost(this.name)" value="Remove" />

                <p><c:out value="${post.date}"></c:out></p>

            </form>
        </div>
        <br />
    </c:forEach>
</div>

