package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.service;

import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.Book;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.Loan;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model.User;
import com.metropolitan.IT355_PZ1_MarkoSimonovic5349.repository.MemoryBase;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class LoanService {
    private final MemoryBase db;

    public LoanService(MemoryBase db) {
        this.db = db;
    }

    public void createLoan(String bookName, String userUsername){
        Optional<Book> bookOpt = db.getBookList().stream()
                .filter(b -> b.getName().equals(bookName))
                .findFirst();

        Optional<User> userOpt = db.getUserList().stream()
                .filter(u -> u.getUsername().equals(userUsername))
                .findFirst();

        if (bookOpt.isPresent() && userOpt.isPresent()) {
            Book book = bookOpt.get();
            User user = userOpt.get();

            book.setAvailable(false);
            db.getLoanList().add(new Loan(book, user, LocalDate.now()));
        }
    }

    public void finishLoan(String bookName, String userUsername){
        Optional<Loan> loanOpt = db.getLoanList().stream()
                .filter(l -> (l.getBook().getName().equals(bookName) && l.getUser().getUsername().equals(userUsername)))
                .findFirst();

        Optional<Book> bookOpt = db.getBookList().stream()
                .filter(b -> b.getName().equals(bookName))
                .findFirst();

        if(loanOpt.isPresent() && bookOpt.isPresent()){
            loanOpt.get().setReturnDate(LocalDate.now());
            bookOpt.get().setAvailable(true);
        }
    }
}
