package com.shah.urlshortener.request;

import com.sun.istack.NotNull;

public class UrlCreate {
	  @NotNull
	    private String alias;
	    @NotNull
	    private String url;

	    public UrlCreate(final String alias, final String url) {
	        this.alias = alias;
	        this.url = url;
	    }

	    public String getAlias() {
	        return alias;
	    }

	    public String getUrl() {
	        return url;
	    }

	    @Override
	    public String toString() {
	        return "RedirectCreationRequest{" +
	                "alias='" + alias + '\'' +
	                ", url='" + url + '\'' +
	                '}';
	    }
}
