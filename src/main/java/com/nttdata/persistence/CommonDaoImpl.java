package com.nttdata.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	private Class<T> entityClass;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(T t) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		session.save(t);
		session.getTransaction().commit();
	}

	@Override
	public T searchById(Long id) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		T result = session.get(this.entityClass, id);
		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<T> result = session.createQuery("FROM " + this.entityClass.getName()).list();
		return result;

	}

	@Override
	public void update(T t) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		session.saveOrUpdate(t);
		session.getTransaction().commit();
	}

	@Override
	public void delete(T t) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		session.delete(t);
		session.getTransaction().commit();
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
