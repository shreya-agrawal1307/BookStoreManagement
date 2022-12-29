package com.cg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entity.Category;
import com.cg.bookstore.service.ICategoryService;

@RestController
public class ICategoryController {
	@Autowired
	private ICategoryService icategoryService;
	
	@PostMapping("/category/save")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category newCategory = icategoryService.addCategory(category);
		ResponseEntity<Category> responseEntity = new ResponseEntity<>(newCategory, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/category/all")
	public List<Category> fetchAllCategories() {
		List<Category> list = icategoryService.viewAllCategories();
		return list;
	}
	
	@PutMapping("/category/update")
	public ResponseEntity<Object> modifyBook(@RequestBody Category c){
		ResponseEntity<Object> responseEntity=null;
			Category updatedCategory=icategoryService.editCategory(c);
			responseEntity =new ResponseEntity<>(updatedCategory,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<String> removeCategory(@PathVariable("id")int c){
		ResponseEntity<String> responseEntity=null;
			icategoryService.removeCategory(c);
			responseEntity=new ResponseEntity<>("category deleted",HttpStatus.OK);
		return responseEntity;
	}
}
