package com.sgijsber.webblog.service;

import com.sgijsber.webblog.dao.PostingDao;
import com.sgijsber.webblog.dao.PostingDaoImp;
import com.sgijsber.webblog.model.Comment;
import com.sgijsber.webblog.model.Posting;
import java.util.List;

public class WebLogService {

    private static PostingDao postingDao = new PostingDaoImp();
    
    private static boolean isAdvanced = false;

    public static void addPosting(Posting p) {
        postingDao.create(p);
    }
    
    public static void changeAdvancedMode(){
        WebLogService.isAdvanced = !WebLogService.isAdvanced;
    }
    
    public static boolean isAdvancedMode(){
        return WebLogService.isAdvanced;
    }

    public static List<Posting> getPostings() {
        return postingDao.findAll();
    }
    
    public static Posting getPostingBy(Long postID){
        return postingDao.find(postID);
    }
    
    public static void addComment(Long postID, Comment c){
        postingDao.addComment(postID, c);
    }
    
    public static void editPostContent(Long postID, String p){
        postingDao.editPostContent(postID, p);
    }
    
    public static void removePost(Long postID){
        postingDao.removePost(postID);
    }
}
