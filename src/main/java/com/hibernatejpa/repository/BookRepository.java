package com.hibernatejpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernatejpa.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Serializable> {
	public Book findByBookId(int bookId);
}