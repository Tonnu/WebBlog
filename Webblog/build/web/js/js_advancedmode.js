/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function updatePost(postID) {

    contentElementID = "postcontent_" + postID;
    editedContent = String(document.getElementById(contentElementID).value);

    $.ajax({
            async: false,
            type: "POST",
            url: "EditPostContent",
            data: {postID: postID, Content: editedContent}});
       
    return false;
}

function removePost(postID) {
    
    $.ajax({
            async: false,
            type: "POST",
            url: "RemovePost",
            data: {postID: postID}});
}

$(document).ajaxStop(function(){
    window.location.reload();
});

$(document).ready(function(){
    $('textarea').autosize();   
});

