package com.hellokoding.jpa.repo;

import com.hellokoding.jpa.category.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}
