package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookstore.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer>{

	public Book findByTitle(String title);
	//public List<Book> findByCategory(String cat);
	//public List<Book> search(String keyword);
	//public List<Book> listRecentlyAdded();
}
