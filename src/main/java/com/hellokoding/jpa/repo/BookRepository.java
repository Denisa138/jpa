package com.hellokoding.jpa.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hellokoding.jpa.book.Book;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
    @EntityGraph(attributePaths = "bookCategory")
    List<Book> findFirst10ByOrderByNameAsc();

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.bookCategory.id = ?1")
    void deleteInBulkByCategoryId(int categoryId);

    @Transactional
    void deleteByBookCategoryId(int categoryId);
}
