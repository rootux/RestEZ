package com.demo.restez.model;

import java.io.Serializable;

import uk.co.jemos.podam.annotations.PodamIntValue;
import uk.co.jemos.podam.annotations.PodamStringValue;

import com.demo.restez.enums.*;

public class Restaurant implements Serializable
{
	private static final long serialVersionUID = -6113543514470043529L;

	private String name;

	@PodamStringValue(length=300)
	private String desc;

	private String address;

	private boolean isKosher;

	private boolean isFancy;

	private PriceCategory avgPrice;

	private ServiceQuality serviceQuality;

	@PodamIntValue(minValue = 1, maxValue = 10)
	private Integer rating;

	private boolean isTakeAway;

	public Restaurant()
	{
	}

	public Restaurant(String name, String desc, String address, boolean isKosher, boolean isFancy,
	                  PriceCategory avgPrice, ServiceQuality serviceQuality, Integer rating, boolean isTakeAway)
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

	public boolean getIsKosher()
	{
		return isKosher;
	}

	public void setIsKosher(boolean isKosher)
	{
		this.isKosher = isKosher;
	}

	public boolean getIsFancy()
	{
		return isFancy;
	}

	public void setIsFancy(boolean isFancy)
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

	public Integer getRating()
	{
		return rating;
	}

	public void setRating(Integer rating)
	{
		this.rating = rating;
	}

	public boolean getIsTakeAway()
	{
		return isTakeAway;
	}

	public void setIsTakeAway(boolean isTakeAway)
	{
		this.isTakeAway = isTakeAway;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ( (this.address == null) ? 0 : this.address.hashCode());
		result = prime * result + ( (this.avgPrice == null) ? 0 : this.avgPrice.hashCode());
		result = prime * result + ( (this.desc == null) ? 0 : this.desc.hashCode());
		result = prime * result + (this.isFancy ? 1231 : 1237);
		result = prime * result + (this.isKosher ? 1231 : 1237);
		result = prime * result + (this.isTakeAway ? 1231 : 1237);
		result = prime * result + ( (this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ( (this.rating == null) ? 0 : this.rating.hashCode());
		result = prime * result + ( (this.serviceQuality == null) ? 0 : this.serviceQuality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (this.address == null)
		{
			if (other.address != null)
				return false;
		}
		else if (!this.address.equals(other.address))
			return false;
		if (this.avgPrice != other.avgPrice)
			return false;
		if (this.desc == null)
		{
			if (other.desc != null)
				return false;
		}
		else if (!this.desc.equals(other.desc))
			return false;
		if (this.isFancy != other.isFancy)
			return false;
		if (this.isKosher != other.isKosher)
			return false;
		if (this.isTakeAway != other.isTakeAway)
			return false;
		if (this.name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!this.name.equals(other.name))
			return false;
		if (this.rating == null)
		{
			if (other.rating != null)
				return false;
		}
		else if (!this.rating.equals(other.rating))
			return false;
		if (this.serviceQuality != other.serviceQuality)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Restaurant [" + (this.name != null ? "name=" + this.name + ", " : "") +
		        (this.desc != null ? "desc=" + this.desc + ", " : "") +
		        (this.address != null ? "address=" + this.address + ", " : "") + "isKosher=" + this.isKosher +
		        ", isFancy=" + this.isFancy + ", " + (this.avgPrice != null ? "avgPrice=" + this.avgPrice + ", " : "") +
		        (this.serviceQuality != null ? "serviceQuality=" + this.serviceQuality + ", " : "") +
		        (this.rating != null ? "rating=" + this.rating + ", " : "") + "isTakeAway=" + this.isTakeAway + "]";
	}
}
