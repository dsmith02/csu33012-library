package ie.tcd.scss.library.repo;

import ie.tcd.scss.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
