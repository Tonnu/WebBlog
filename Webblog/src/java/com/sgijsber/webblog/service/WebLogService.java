package com.sgijsber.webblog.service;

import com.sgijsber.webblog.dao.PostingDao;
import com.sgijsber.webblog.dao.PostingDaoImp;
import com.sgijsber.webblog.model.Posting;
import java.util.List;

public class WebLogService {

    private PostingDao postingDao;

    public WebLogService() {
        postingDao = new PostingDaoImp();
    }

    public void addPosting(Posting p) {
        postingDao.create(p);
    }

    public List<Posting> getPostings() {
        return postingDao.findAll();
    }
;
}
