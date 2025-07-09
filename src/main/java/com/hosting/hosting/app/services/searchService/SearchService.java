package com.hosting.hosting.app.services.searchService;

import com.hosting.hosting.app.model.Cart;

public interface SearchService {
    Cart checkDomainDetails(String domainName);
    Cart fetchDomaindata(String domainName);
    void addInCart(Cart cart);
}
