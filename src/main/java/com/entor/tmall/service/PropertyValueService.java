package com.entor.tmall.service;

import java.util.List;

import com.entor.tmall.bean.Product;
import com.entor.tmall.bean.PropertyValue;

public interface PropertyValueService {
	
	public void init(Product p);
	public void update(PropertyValue pv);
	public PropertyValue get(int ptid, int pid);
	public List<PropertyValue> list(int pid);

}
