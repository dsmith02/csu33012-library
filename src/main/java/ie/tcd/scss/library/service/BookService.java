package ie.tcd.scss.library.service;

import ie.tcd.scss.library.domain.Book;
import ie.tcd.scss.library.domain.LibrarySection;
import ie.tcd.scss.library.repo.BookRepository;
import ie.tcd.scss.library.repo.LibrarySectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService
{
    private final BookRepository bookRepository;
    private final LibrarySectionRepository librarySectionRepository;

    @Autowired
    public BookService(BookRepository bookRepository, LibrarySectionRepository librarySectionRepository)
    {
        this.bookRepository = bookRepository;
        this.librarySectionRepository = librarySectionRepository;
    }

    public Book createBook(String title, String authors, Integer publicationYear, Integer price, String isbn,
                           String keywords, String description, String librarySectionCode)
    {
        LibrarySection librarySection = librarySectionRepository
                .findById(librarySectionCode)
                .orElseThrow(() -> new RuntimeException("Library Section does not exist: " + librarySectionCode));
        return bookRepository.save(new Book(title, authors, publicationYear, price, isbn, keywords, description,
                librarySection));
    }

    public Iterable<Book> lookup()
    {
        return bookRepository.findAll();
    }

    public long total()
    {
        return bookRepository.count();
    }
}
