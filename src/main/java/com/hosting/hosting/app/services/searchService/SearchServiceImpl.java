package com.hosting.hosting.app.services.searchService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hosting.hosting.app.model.Cart;

public class SearchServiceImpl implements SearchService{
    private String apiKey= "";
    private RestTemplate restTemplate;
    

    SearchServiceImpl( RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Cart fetchDomaindata(String domainName) {
        String url=String.format("https://api.whoisfreaks.com/v1.0/domain/availability?apiKey=%s&domain=%s&sug=true&count=10",apiKey,domainName);
        ResponseEntity<> responce = restTemplate.getForEntity(url, null);
        if(responce.getStatusCode().is2xxSuccessful(){
            return 
        })
    }

    @Override
    public void addInCart(Cart cart) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addInCart'");
    }
    @Override
    public Cart checkDomainDetails(String domainName) {
       /* String url="";
        ResponseEntity<> responce = restTemplate.getForEntity(null, null);
        if(responce.getStatusCode().is2xxSuccessful(){
            return 
        }) */
       return null;
    }

    
}
