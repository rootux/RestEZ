package com.demo.restez.utils;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;
import com.google.web.bindery.requestfactory.shared.BaseProxy;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class ContextProjector
{
    public static <T extends BaseProxy> T copyBeanByContext(RequestContext targetContext, T oldBeanProxy, Class<T> typeClass)
	{
		if (oldBeanProxy == null)
			return null;
		
		T newBeanProxy = targetContext.create(typeClass);
		AutoBean<T> oldBean = AutoBeanUtils.getAutoBean(oldBeanProxy);
		AutoBean<T> newBean = AutoBeanUtils.getAutoBean(newBeanProxy);
		AutoBeanCodex.decodeInto(AutoBeanCodex.encode(oldBean), newBean);
		newBeanProxy = newBean.as();
		targetContext.edit(newBeanProxy);
		return newBeanProxy;
	}
}
