package com.example.ymu.dao.base;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("rawtypes")
public abstract class BaseDaoImpl<T extends BaseRepository> implements BaseDao<T> {

	@Autowired
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	protected T mRepository;
	
	@Autowired
	protected DSLContext jooqDsl;
	
	@Override
	public T getMRepository() {
		System.out.println(">>>>>mRepository:" + mRepository.toString());
		return mRepository;
	}
	
	@Override
	public EntityManager getEntityManager() {
		return em;
	}
	
	@Override
	public DSLContext getJooq() {
		return jooqDsl;
	}
}
	
