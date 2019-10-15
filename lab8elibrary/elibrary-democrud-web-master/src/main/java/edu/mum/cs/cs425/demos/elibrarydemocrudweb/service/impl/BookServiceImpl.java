package edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.impl;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.Book;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.repository.BookRepository;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

//@Service(value = "MainBookService")
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Iterable<Book> getAllBooks() {
//        return ((List<Book>)repository.findAll())
//                .stream()
//                .sorted(Comparator.comparing(Book::getTitle))
//                .collect(Collectors.toList());
        return repository.findAll(Sort.by("title"));
    }

    @Override
    public Page<Book> getAllBooksPaged(int pageNo) {
        return repository.findAll(PageRequest.of(pageNo, 5, Sort.by("title")));
    }

    @Override
    public Book saveBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        repository.deleteById(bookId);
    }

    @Override
    public Optional<Book> findByISBN(String isbn) {
        return repository.findBookByIsbn(isbn);
    }

    @Override
    public Page<Book> searchBook(Pageable pageNum, String sText) {
//        List<Book> findBooks;
//        findBooks = repository.findAll();
//
//        if(sbook.getTitle() != ""){
//            if(sbook.getTitle().equals(findBooks)){
//
//            }
//            Collectors.toList();
//        }
//        return new PageImpl<Book>(findBooks, PageRequest.of(pageNum, 5, Sort.by("title")),
//                findBooks.size());
//    }
//        System.out.println(repository.findAllByTitleContains(sText, pageNum));
        System.out.println(repository.findAllByTitleIsContaining(sText)+"--------------------------------------");
        System.out.println();
        return repository.findAllByTitleContains(sText, pageNum);
    }

}
