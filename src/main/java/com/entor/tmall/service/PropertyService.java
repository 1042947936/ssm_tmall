package com.entor.tmall.service;

import java.util.List;

import com.entor.tmall.bean.Property;

public interface PropertyService {
	public void add(Property c);
	public void delete(int id);
	public void update(Property c);
	public Property get(int id);
	public List list(int cid);

}
