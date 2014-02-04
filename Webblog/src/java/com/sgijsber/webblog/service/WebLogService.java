package com.sgijsber.webblog.service;

import com.sgijsber.webblog.dao.PostingDao;
import com.sgijsber.webblog.dao.PostingDaoImp;
import com.sgijsber.webblog.model.Posting;
import java.util.List;

public class WebLogService {

    private static PostingDao postingDao = new PostingDaoImp();

    public static void addPosting(Posting p) {
        postingDao.create(p);
    }

    public static List<Posting> getPostings() {
        return postingDao.findAll();
    }
;
}
