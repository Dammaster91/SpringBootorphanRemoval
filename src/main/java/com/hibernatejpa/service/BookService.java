package com.hibernatejpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hibernatejpa.entity.Book;
import com.hibernatejpa.entity.Story;

@Component
public interface BookService {
	public Book saveBook(Book book);
	public String removeStoryFromBook(int id);
	public List<Book> getAllBook();
	public List<Story> getAllStory();
}