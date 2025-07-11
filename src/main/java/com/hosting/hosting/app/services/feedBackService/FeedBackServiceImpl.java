package com.hosting.hosting.app.services.feedBackService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hosting.hosting.app.entities.FeedBackEntity;
import com.hosting.hosting.app.model.FeedBack;
import com.hosting.hosting.app.repository.FeedBackRepository;

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
        return "Thank you for Your Valueable Feedback";
    }

    @Override
    public List<FeedBack> readFeedBack() {
        
        List<FeedBackEntity> lstEntities = feedBackRepository.findAll();
        List<FeedBack> lst = lstEntities.stream().map(feedback -> new FeedBack(feedback.getId(),feedback.getName(),feedback.getEmail(),feedback.getDateTime(),feedback.getTitle(),feedback.getDescription())).toList();
        return lst;
    }
    
}
