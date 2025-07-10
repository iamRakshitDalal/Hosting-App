package com.hosting.hosting.app.services.feedBackService;

import org.springframework.beans.BeanUtils;

import com.hosting.hosting.app.entities.FeedBackEntity;
import com.hosting.hosting.app.model.FeedBack;
import com.hosting.hosting.app.repository.FeedBackRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

public class FeedBackServiceImpl implements FeedBackService {

    
    private FeedBackRepository feedBackRepository;
    FeedBackServiceImpl(FeedBackRepository feedBackRepository){
        this.feedBackRepository = feedBackRepository;
    }
    @Override
    public String addFeedBack(FeedBack FeedBack) {
        FeedBackEntity feedBackEntity = new FeedBackEntity();
        BeanUtils.copyProperties(FeedBack, feedBackEntity);
        feedBackRepository.save(feedBackEntity);
        return "Thank you for Your Valuable Feedback";
    }

    @Override
    public FeedBack readFeedBack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFeedBack'");
    }
    
}
