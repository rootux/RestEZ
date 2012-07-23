package com.demo.restez.proxies;

import com.demo.restez.enums.*;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyForName("com.demo.restez.model.Restaurant")
public interface RestaurantProxy extends ValueProxy
{
	public String getName();
	
	public void setName(String name);
	
	public String getDesc();
	
	public void setDesc(String desc);
	
	public String getAddress();
	
	public void setAddress(String address);
	
	public boolean getIsKosher();
	
	public void setIsKosher(boolean isKosher);
	
	public boolean getIsFancy();
	
	public void setIsFancy(boolean isFancy);
	
	public PriceCategory getAvgPrice();
	
	public void setAvgPrice(PriceCategory avgPrice);
	
	public ServiceQuality getServiceQuality();
	
	public void setServiceQuality(ServiceQuality serviceQuality);
	
	public Integer getRating();
	
	public void setRating(Integer rating);
	
	public boolean getIsTakeAway();
	
	public void setIsTakeAway(boolean isTakeAway);
}
