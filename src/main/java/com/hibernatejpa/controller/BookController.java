package com.hibernatejpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernatejpa.entity.Book;
import com.hibernatejpa.entity.Story;
import com.hibernatejpa.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	@ResponseBody
	public Book saveBook(@RequestBody Book book) {
		Book bookResponse = bookService.saveBook(book);
		return bookResponse;
	}

	@RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteBook(@PathVariable int bookId) {
		String bookResponse = bookService.removeStoryFromBook(bookId);

		return bookResponse;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> resp = null;
		List<Book> list = bookService.getAllBook();
		if (list == null || list.isEmpty()) {
			String message = "No Data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		}
		return resp;
	}
	
	@RequestMapping(value = "/allStory", method = RequestMethod.GET)
	public ResponseEntity<?> getAllStory() {
		ResponseEntity<?> resp = null;
		List<Story> list = bookService.getAllStory();
		if (list == null || list.isEmpty()) {
			String message = "No Data Found";
			resp = new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			resp = new ResponseEntity<List<Story>>(list, HttpStatus.OK);
		}
		return resp;
	}
	
}