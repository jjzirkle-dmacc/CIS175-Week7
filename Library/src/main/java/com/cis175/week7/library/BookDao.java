package com.cis175.week7.library;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BookDao {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Library");

	public void insertBook(Book bookToAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bookToAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Book> getAllBooks() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		String q = "select b from Book b";
		TypedQuery<Book> typedQuery = em.createQuery(q, Book.class);
		List<Book> all = typedQuery.getResultList();
		return all;

	}
}
