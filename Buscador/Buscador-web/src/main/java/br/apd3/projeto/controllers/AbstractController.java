package br.apd3.projeto.controllers;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractController implements Controller {
    
    private HttpServletRequest request;
    private String returnPage;
    
    @Override
    public void init(HttpServletRequest request) {
        setRequest(request);
    }
    
    public void setReturnPage(String page) {
        this.returnPage = page;
    }
    
    @Override
    public String getReturnPage() {
        return this.returnPage;
    }
    
    public HttpServletRequest getRequest() {
        return this.request;
    }
    
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
}
