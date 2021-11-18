package com.hibernatejpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hibernatejpa.entity.Book;
import com.hibernatejpa.entity.Story;
import com.hibernatejpa.repository.BookRepository;
import com.hibernatejpa.repository.StoryRepository;
import com.hibernatejpa.service.BookService;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private StoryRepository storyRepository;

	@Transactional
	public Book saveBook(Book book) {

		book = bookRepository.save(book);
		return book;

	}

	public String removeStoryFromBook(int bookId) {
		Optional<Book> bookResponse = bookRepository.findById(bookId);
		Book book = bookResponse.get();
		book.getStoryList().removeAll(book.getStoryList());
		bookRepository.save(book);
		return "Removed Stories from Book successfully";
	}

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}
	
	@Override
	public List<Story> getAllStory() {
		return storyRepository.findAll();
	}

}