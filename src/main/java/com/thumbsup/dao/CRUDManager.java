package com.thumbsup.dao;

import java.util.List;

public abstract class CRUDManager <T, E>{
	
	public abstract T insert(T object);
	public abstract T select(E PK);
	public abstract List<T> selectAll();
	public abstract T delete(T object);
	public abstract T update(T object);
	
}
