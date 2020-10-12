package com.jsoft.dao;

import java.util.List;

import com.jsoft.pojo.UserBean;

public interface InsertDao {
public void insertValues(UserBean userBean);
public List<UserBean> getValues();
public void delete(UserBean userBean);
public void updateValues(UserBean userBean);

}
