package com.cg.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entity.Category;
import com.cg.bookstore.exception.BookNotFoundException;
import com.cg.bookstore.exception.CategoryNotFoundException;
import com.cg.bookstore.repository.ICategoryRepository;

@Service
public class ICategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryRepository icategoryRepository;
	
	@Override
	public Category addCategory(Category categoryName) {
		Category newCategory=icategoryRepository.save(categoryName);
		return newCategory;
	}

	@Override
	public Category editCategory(Category cat) {
		Optional<Category> optionalBook= icategoryRepository.findById(cat.getCategoryId());
		if(optionalBook.isEmpty()) {
			throw new CategoryNotFoundException("product not found with id :"+cat.getCategoryId());
		}
		Category updateCategory=icategoryRepository.save(cat);
		return updateCategory;
	}

	@Override
	public List<Category> viewAllCategories() {
		return icategoryRepository.findAll();
	}

	@Override
	public void removeCategory(int cat) {
		Optional<Category> optionalCategory= icategoryRepository.findById(cat);
		if(optionalCategory.isEmpty()) {
			throw new BookNotFoundException("product not found with id :"+cat);
		}
		icategoryRepository.deleteById(cat);
	}

}
