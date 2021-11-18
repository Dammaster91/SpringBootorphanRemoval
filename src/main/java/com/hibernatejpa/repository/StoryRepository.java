package com.hibernatejpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernatejpa.entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Serializable> {
}