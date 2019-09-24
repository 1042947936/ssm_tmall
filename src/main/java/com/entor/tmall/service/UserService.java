package com.entor.tmall.service;

import java.util.List;

import com.entor.tmall.bean.User;

public interface UserService {
	void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
}
