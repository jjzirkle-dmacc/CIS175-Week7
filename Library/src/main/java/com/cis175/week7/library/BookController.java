package com.cis175.week7.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cis175.week7.library.Book;

@Controller
public class BookController {
	
	@Autowired BookDao dao;
	
	private static final String[ ] language = { "English", "French", "German", "Spanish" };
	
	@RequestMapping(value = "/form")
	public ModelAndView book( ){
		ModelAndView modelAndView = new ModelAndView( );
		
		modelAndView.setViewName("bookForm");
		modelAndView.addObject("book", new Book( ));
		modelAndView.addObject("language", language);
		
		return modelAndView;
	}

	@RequestMapping(value = "/result")
	public ModelAndView processUser(Book book){
		System.out.println("In processUser");
		ModelAndView modelAndView = new ModelAndView();
		dao.insertBook(book);
		System.out.println("Value in getName"+ book.getTitle());
		modelAndView.setViewName("bookResult");
		modelAndView.addObject("b", book);
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewAll")
	public ModelAndView viewAll( ){
		ModelAndView modelAndView = new ModelAndView();
		List<Book> allBooks = dao.getAllBooks();
		modelAndView.setViewName("viewAllBooks");
		modelAndView.addObject("all", allBooks);
		return modelAndView;
	}

	@Bean
	public BookDao dao(){
		BookDao bean = new BookDao();
		return bean;
	}

}
