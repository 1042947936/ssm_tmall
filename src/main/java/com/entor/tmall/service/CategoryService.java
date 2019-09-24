package com.entor.tmall.service;

import java.util.List;

import com.entor.tmall.bean.Category;
import com.entor.tmall.bean.CategoryExample;
import com.entor.tmall.util.Page;

public interface CategoryService{
    public List<Category> list();

    public void add(Category category);

    public void delete(int id);

    public Category get(int id);

    public void update(Category category);
}
