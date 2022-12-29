package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Book;
import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.BookNotFoundException;
import com.cg.bookstore.exception.CategoryNotFoundException;
import com.cg.bookstore.repository.IBookRepository;
import com.cg.bookstore.repository.ICategoryRepository;

@Service
public class IBookServiceImpl implements IBookService{

	@Autowired
	private IBookRepository ibookRepository;
	
	@Autowired
	private ICategoryRepository iCategoryRepository;
	
	@Override
	public Book createBook(int categoryId,Book b) {
		Optional<Category> optionalCategory=iCategoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new CategoryNotFoundException("category not found with id :"+categoryId);
		}
		Category category=optionalCategory.get();
		b.setCategory(category);
		Book newbook=ibookRepository.save(b);
		return newbook;
	}

	@Override
	public List<Book> listAllBooks() {
		return ibookRepository.findAll();
	}

	@Override
	public void deleteBook(int b) {
		Optional<Book>optionalBook= ibookRepository.findById(b);
		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("book not found with id :"+b);
		}
		ibookRepository.deleteById(b);
	}

	@Override
	public Book editBook(Book b) {
		Optional<Book> optionalBook= ibookRepository.findById(b.getBookId());
		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("book not found with id :"+b.getBookId());
		}
		Book updateBook=ibookRepository.save(b);
		return updateBook;
	}

	@Override
	public Book viewBook(int b) {
		Optional<Book> optionalBook= ibookRepository.findById(b);
		if(optionalBook.isEmpty()) {
			throw new BookNotFoundException("book not found with id :"+b);
		}
		Book book=optionalBook.get();
		return book;
	}

	@Override
	public Book getByName(String name) {
		Book book=ibookRepository.findByTitle(name);
		return book;
	}
//
//	@Override
//	public List<Book> findBySearch(String keyword) {
//		List<Book> book=ibookRepository.search(keyword);
//		return book;
//	}

	@Override
	public Book createBook(Book b) {
		Book newbook=ibookRepository.save(b);
		return newbook;
	}

	@Override
	public List<Book> listBooksByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Book> listBooksByCategory(int categoryId) {
//		return ibookRepository.findByCategory(categoryId);
//	}
}
