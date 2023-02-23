package com.dao;

import com.exception.DataNotFoundException;
import com.exception.SomethingWentWrong;

public interface GPMDao {
	public void login(String id, String password) throws DataNotFoundException, SomethingWentWrong;
}
