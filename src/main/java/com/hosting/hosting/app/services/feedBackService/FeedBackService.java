package com.hosting.hosting.app.services.feedBackService;

import com.hosting.hosting.app.model.FeedBack;

public interface FeedBackService {
    String addFeedBack(FeedBack FeedBack);
    FeedBack readFeedBack();
}
