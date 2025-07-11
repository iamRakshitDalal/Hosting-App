package com.hosting.hosting.app.services.feedBackService;

import java.util.List;

import com.hosting.hosting.app.model.FeedBack;

public interface FeedBackService {
    String addFeedBack(FeedBack FeedBack);
    List<FeedBack> readFeedBack();
}
