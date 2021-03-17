package org.sdju.mapper;

import org.apache.ibatis.annotations.Param;
import org.sdju.model.Book;

import java.util.HashMap;
import java.util.List;

public interface BookMapper {

    List<Book> getAllBooks();

    List<Book> getBooksByPage(@Param("start") Integer start, @Param("size") Integer size);

    List<Book> getBookByNameOrAuthor(Book book);

    Integer updateBook(Book book);

    Integer updateBook2(@Param("map") HashMap<String, Object> map,@Param("id") Integer id);

    List<Book> getBooksByIds(@Param("ids") List<Integer> ids);

    Integer batchAddBook(@Param("books") List<Book> books);

    List<Book> getBooksByAuthorFirstName(String author);

}
