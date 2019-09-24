package com.entor.tmall.service;

import java.util.List;

import com.entor.tmall.bean.Order;
import com.entor.tmall.bean.OrderItem;

public interface OrderItemService {
	public void add(OrderItem c);
	 
	public void delete(int id);
	public void update(OrderItem c);
	public OrderItem get(int id);
	public List list();
 
	public void fill(List<Order> os);
 
	public void fill(Order o);

}
