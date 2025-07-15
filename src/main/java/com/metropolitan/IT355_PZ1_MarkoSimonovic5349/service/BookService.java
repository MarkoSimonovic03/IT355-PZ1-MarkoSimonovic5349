package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.Author;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.Book;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.Category;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.User;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.repository.MemoryBase;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final MemoryBase db;

    public BookService(MemoryBase db) {
        this.db = db;
    }

    @PostConstruct
    public void loadBooks() {
        if (db.getBookList().isEmpty()) {
            db.getBookList().add(new Book("The Catcher in the Rye", "A story about teenage rebellion", true, new Author("J.D.", "Salinger", "American writer known for this novel"), Category.FICTION));
            db.getBookList().add(new Book("A Brief History of Time", "Exploring time and the universe", true, new Author("Stephen", "Hawking", "Famous physicist and cosmologist"), Category.SCIENCE));
            db.getBookList().add(new Book("1984", "Dystopian novel about totalitarian regime", true, new Author("George", "Orwell", "British writer and journalist"), Category.FICTION));
            db.getBookList().add(new Book("Biology 101", "High school biology textbook", true, new Author("Anna", "Johnson", "Biology professor and textbook author"), Category.SCIENCE));
            db.getBookList().add(new Book("My Life", "Autobiography of a political figure", true, new Author("John", "Smith", "Former president and public speaker"), Category.NON_FICTION));
            db.getBookList().add(new Book("Crime and Punishment", "A psychological novel about guilt", true, new Author("Fyodor", "Dostoevsky", "Renowned Russian novelist"), Category.FICTION));
            db.getBookList().add(new Book("The Big Bang Explained", "Scientific explanation of the universe's origin", true, new Author("Mark", "Peterson", "Astrophysicist and author"), Category.SCIENCE));
            db.getBookList().add(new Book("The Psychology of Crowds", "How people behave in masses", true, new Author("Gustave", "Le Bon", "French social psychologist"), Category.NON_FICTION));
            db.getBookList().add(new Book("To Kill a Mockingbird", "A novel about justice and racism", true, new Author("Harper", "Lee", "American novelist"), Category.FICTION));
            db.getBookList().add(new Book("The Selfish Gene", "A book on evolution and genetics", true, new Author("Richard", "Dawkins", "British evolutionary biologist"), Category.SCIENCE));
        }
    }

    public List<Book> getAllBooks() {
        return db.getBookList();
    }
}
