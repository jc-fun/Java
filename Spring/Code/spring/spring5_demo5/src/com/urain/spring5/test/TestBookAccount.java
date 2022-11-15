package com.urain.spring5.test;

import com.urain.spring5.entity.Book;
import com.urain.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/24 17:58
 * @description:
 * @version: 1.0
 */

public class TestBookAccount {
    @Test
    public void testJdbcTemplate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("1");
        book.setUsername("C++从入门到入土");
        book.setUstatus("a");
        book.setPubDate(LocalDateTime.of(2020, 12, 12, 12, 12, 12));
        bookService.addBook(book);
    }

    @Test
    public void testJdbcTemplateUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("1");
        book.setUsername("C++从入门到入土");
        book.setUstatus("c");
        bookService.updateBook(book);
    }

    @Test
    public void testJdbcTemplateDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook("2");
    }

    @Test
    public void testJdbcTemplateCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Integer count = bookService.findCount();
        System.out.println(count);
    }

    @Test
    public void testJdbcTemplateBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.findBook("1");
        System.out.println(book);
    }

    @Test
    public void testJdbcTemplateBookList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> bookList = bookService.findBookList();
        System.out.println(bookList);
    }

    @Test
    public void testJdbcTemplateBatch() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        for(int i = 0; i < 10000; i++) {
            batchArgs.add(new Object[]{Integer.toString(i), Integer.toString(i), Integer.toString(i), LocalDateTime.now()});
        }
        long start = System.currentTimeMillis();
        bookService.batchAdd(batchArgs);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为:" + (end - start) + "ms");
    }

    @Test
    public void testJdbcTemplateBatchUpdate() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        for(int i = 10000; i < 20000; i++) {
            batchArgs.add(new Object[]{Integer.toString(i), Integer.toString(i), LocalDateTime.now(), Integer.toString(20000 - i)});
        }
        long start = System.currentTimeMillis();
        bookService.batchUpdateBook(batchArgs);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为:" + (end - start) + "ms");
    }

    @Test
    public void testJdbcTemplateBatchDelete() {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> batchArgs = new ArrayList<>();
        for(int i = 10000; i < 20000; i++) {
            batchArgs.add(new Object[]{Integer.toString(20000 - i)});
        }
        long start = System.currentTimeMillis();
        bookService.batchDeleteBook(batchArgs);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为:" + (end - start) + "ms");
    }


}
