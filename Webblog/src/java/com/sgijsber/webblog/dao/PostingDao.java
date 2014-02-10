/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgijsber.webblog.dao;

import com.sgijsber.webblog.model.Comment;
import java.util.List;
import com.sgijsber.webblog.model.Posting;

public interface PostingDao {

    void create(Posting p);

    List<Posting> findAll();

    Posting find(Long id);
    
    void addComment(Long postID, Comment c);
    
    void editPostContent(Long postID, String content);
    
    void removePost(Long postID);
}
