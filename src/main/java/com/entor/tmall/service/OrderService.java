package com.entor.tmall.service;

import java.util.List;

import com.entor.tmall.bean.Order;

public interface OrderService {
	String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";
 
    public void add(Order c);
 
    public void delete(int id);
    public void update(Order c);
    public Order get(int id);
    public List list();

}
