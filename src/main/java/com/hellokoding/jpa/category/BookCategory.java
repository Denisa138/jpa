package com.hellokoding.jpa.category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.hellokoding.jpa.book.Book;

@Entity(name = "BookCategory")
@Table(name = "book_category")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(
            mappedBy = "bookCategory",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Book> books;

    public BookCategory() {
        books = new ArrayList<>();
    }

    public BookCategory(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
        for (Book book: books) {
            book.setBookCategory(this);
        }
    }
}
