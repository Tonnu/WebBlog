/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            $(commentDiv).append("<div id=" + divName + "><p>Reaction no:" + data["id"] + "</p><p>" + data["content"] + "</p></div>");
            $("#" + divName).addClass("comment");
        });
    }
}


$(document).ready(function() {

    $.getJSON("http://localhost:8080/Webblog/ListCommands.json", null, getCommentList);

    function getCommentList(t) {
        $.each(t, function(index, data) {
            var postID = data["id"];

            var commentDiv = "#comment_list_".concat(data["id"]);
            $(commentDiv).empty();

            $.each(data["comments"], function(index, comment) {
                var commentDivID = String(postID).concat(comment["id"]);
                $(commentDiv).append("<div id=" + commentDivID + "><p>Reaction no:" + comment["id"] + "</p><p>" + comment["content"] + "</p></div>");
                $("#" + commentDivID).addClass("comment");
            });
        });
    }
});

$(document).ready(function(){
    $('textarea').autosize();   
});
