package com.demo.restez.model;

import java.io.Serializable;

import com.demo.restez.enums.*;

public class Restaurant implements Serializable
{
    private static final long serialVersionUID = -6113543514470043529L;
    
    private String name;
    private String desc;
    private String address;
    private boolean isKosher;
    private boolean isFancy;
    private PriceCategory avgPrice;
    private ServiceQuality serviceQuality;
    private int rating;
    private boolean isTakeAway;
    
	public Restaurant(String name, String desc, String address, boolean isKosher, boolean isFancy,
                      PriceCategory avgPrice, ServiceQuality serviceQuality, int rating, boolean isTakeAway)
    {
	    super();
	    this.name = name;
	    this.desc = desc;
	    this.address = address;
	    this.isKosher = isKosher;
	    this.isFancy = isFancy;
	    this.avgPrice = avgPrice;
	    this.serviceQuality = serviceQuality;
	    this.rating = rating;
	    this.isTakeAway = isTakeAway;
    }
	public String getName()
    {
    	return name;
    }
	public void setName(String name)
    {
    	this.name = name;
    }
	public String getDesc()
    {
    	return desc;
    }
	public void setDesc(String desc)
    {
    	this.desc = desc;
    }
	public String getAddress()
    {
    	return address;
    }
	public void setAddress(String address)
    {
    	this.address = address;
    }
	public boolean isKosher()
    {
    	return isKosher;
    }
	public void setKosher(boolean isKosher)
    {
    	this.isKosher = isKosher;
    }
	public boolean isFancy()
    {
    	return isFancy;
    }
	public void setFancy(boolean isFancy)
    {
    	this.isFancy = isFancy;
    }
	public PriceCategory getAvgPrice()
    {
    	return avgPrice;
    }
	public void setAvgPrice(PriceCategory avgPrice)
    {
    	this.avgPrice = avgPrice;
    }
	public ServiceQuality getServiceQuality()
    {
    	return serviceQuality;
    }
	public void setServiceQuality(ServiceQuality serviceQuality)
    {
    	this.serviceQuality = serviceQuality;
    }
	public int getRating()
    {
    	return rating;
    }
	public void setRating(int rating)
    {
    	this.rating = rating;
    }
	public boolean isTakeAway()
    {
    	return isTakeAway;
    }
	public void setTakeAway(boolean isTakeAway)
    {
    	this.isTakeAway = isTakeAway;
    }
	
	@Override
    public int hashCode()
    {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ( (address == null) ? 0 : address.hashCode());
	    result = prime * result + ( (avgPrice == null) ? 0 : avgPrice.hashCode());
	    result = prime * result + ( (desc == null) ? 0 : desc.hashCode());
	    result = prime * result + (isFancy ? 1231 : 1237);
	    result = prime * result + (isKosher ? 1231 : 1237);
	    result = prime * result + (isTakeAway ? 1231 : 1237);
	    result = prime * result + ( (name == null) ? 0 : name.hashCode());
	    result = prime * result + rating;
	    result = prime * result + ( (serviceQuality == null) ? 0 : serviceQuality.hashCode());
	    return result;
    }
	
	@Override
    public boolean equals(Object obj)
    {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (! (obj instanceof Restaurant))
		    return false;
	    Restaurant other = (Restaurant) obj;
	    if (address == null)
	    {
		    if (other.address != null)
			    return false;
	    }
	    else if (!address.equals(other.address))
		    return false;
	    if (avgPrice == null)
	    {
		    if (other.avgPrice != null)
			    return false;
	    }
	    else if (!avgPrice.equals(other.avgPrice))
		    return false;
	    if (desc == null)
	    {
		    if (other.desc != null)
			    return false;
	    }
	    else if (!desc.equals(other.desc))
		    return false;
	    if (isFancy != other.isFancy)
		    return false;
	    if (isKosher != other.isKosher)
		    return false;
	    if (isTakeAway != other.isTakeAway)
		    return false;
	    if (name == null)
	    {
		    if (other.name != null)
			    return false;
	    }
	    else if (!name.equals(other.name))
		    return false;
	    if (rating != other.rating)
		    return false;
	    if (serviceQuality == null)
	    {
		    if (other.serviceQuality != null)
			    return false;
	    }
	    else if (!serviceQuality.equals(other.serviceQuality))
		    return false;
	    return true;
    }
	
	@Override
    public String toString()
    {
	    return "Restaurant [" + (address != null ? "address=" + address + ", " : "") +
	            (avgPrice != null ? "avgPrice=" + avgPrice + ", " : "") + (desc != null ? "desc=" + desc + ", " : "") +
	            "isFancy=" + isFancy + ", isKosher=" + isKosher + ", isTakeAway=" + isTakeAway + ", " +
	            (name != null ? "name=" + name + ", " : "") + "rating=" + rating + ", " +
	            (serviceQuality != null ? "serviceQuality=" + serviceQuality : "") + "]";
    }
}
