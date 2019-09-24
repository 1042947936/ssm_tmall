package com.entor.tmall.service;

import java.util.List;

import com.entor.tmall.bean.Product;

public interface ProductService {
    public void add(Product p);
    public void delete(int id);
    public void update(Product p);
    public Product get(int id);
    public List list(int cid);
    public void setFirstProductImage(Product p);

}
