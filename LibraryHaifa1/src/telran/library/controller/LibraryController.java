package telran.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import telran.library.api.*;
import telran.library.domain.entities.AuthorEntity;
import telran.library.dto.*;
import telran.library.service.interfaces.ILibrary;

@RestController
public class LibraryController {
	@Autowired
ILibrary library;
	@PostMapping(value=LibraryApiConstants.ADD_AUTHOR)
	LibReturnCode addAuthor(PublisherAuthor author) {
		return library.addAuthor(author);
	}
	@PostMapping(value=LibraryApiConstants.ADD_BOOK)
	LibReturnCode addBook(Book book) {
		return library.addBookItem(book);
	}
}
