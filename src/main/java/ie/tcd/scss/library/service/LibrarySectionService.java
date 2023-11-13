package ie.tcd.scss.library.service;

import ie.tcd.scss.library.domain.LibrarySection;
import ie.tcd.scss.library.repo.LibrarySectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarySectionService
{
    private final LibrarySectionRepository librarySectionRepository;

    @Autowired
    LibrarySectionService(LibrarySectionRepository librarySectionRepository)
    {
        this.librarySectionRepository = librarySectionRepository;
    }

    public LibrarySection createLibrarySection(String code, String name)
    {
        return librarySectionRepository
                .findById(code)
                .orElse(librarySectionRepository.save(new LibrarySection(code, name)));
    }

    public Iterable<LibrarySection> lookup()
    {
        return librarySectionRepository.findAll();
    }

    public long total()
    {
        return librarySectionRepository.count();
    }
}
