package org.sdju.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sdju.mapper.ArticleMapper;
import org.sdju.mapper.BookMapper;
import org.sdju.mapper.UserMapper;
import org.sdju.model.Article;
import org.sdju.model.Book;
import org.sdju.model.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {

    private UserMapper userMapper;
    private SqlSession sqlSession;
    private BookMapper bookMapper;
    private ArticleMapper articleMapper;
    @Before
    public void before() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        bookMapper = sqlSession.getMapper(BookMapper.class);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
    }

    @Test
    public void getArticleById3(){
        Article article = articleMapper.getArticleById3(1);
        System.out.println("article=" + article);
    }

    @Test
    public void getArticleById2(){
        Article article = articleMapper.getArticleById2(1);
        System.out.println("article=" + article);
    }

    @Test
    public void getArticleById(){
        Article article = articleMapper.getArticleById(1);
        System.out.println("article=" + article);
    }

    @Test
    public void getBooksByAuthorFirstName(){
        List<Book> list = bookMapper.getBooksByAuthorFirstName("罗");
        for(Book book : list){
            System.out.println("book=" + book);
        }
    }

    @Test
    public void updateBook2(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("author","加西亚.马尔克斯");

        Integer result = bookMapper.updateBook2(map, 11);
        System.out.println("result=" + result);
        sqlSession.commit();
    }

    @Test
    public void batchAddBook(){
        Book book1 = new Book();
        book1.setAuthor("马尔克斯");
        book1.setName("百年孤独");

        Book book2 = new Book();
        book2.setAuthor("陈忠实");
        book2.setName("白鹿原");

        Integer result = bookMapper.batchAddBook(Arrays.asList(book1, book2));
        System.out.println("result=" + result);
        sqlSession.commit();
    }

    @Test
    public void getBooksByIds(){
        List<Book> list = bookMapper.getBooksByIds(Arrays.asList(1,2,3));
        for (Book book : list){
            System.out.println("book=" + book);
        }
    }

    @Test
    public void updateBook(){
        Book book = new Book();
        book.setId(4);
        book.setName("孔已己");
        Integer result = bookMapper.updateBook(book);
        System.out.println("result=" + result);
        sqlSession.commit();
    }

    @Test
    public void getBookByNameOrAuthor(){
        Book bName = new Book();
        bName.setAuthor("村上春树");
        bName.setName("海边的卡夫卡");
        List<Book> list = bookMapper.getBookByNameOrAuthor(bName);
        for (Book book : list){
            System.out.println("book = " + book);
        }

    }

    @Test
    public void getBooksByPage(){
        List<Book> list = bookMapper.getBooksByPage(null, 3);
        for (Book book : list){
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getAllUsers(){

        List<User> list = userMapper.getAllUsers();
        for(User user : list){
            System.out.println("user=" + user);
        }
    }

    @Test
    public void getAllUsers2(){

        List<Map<String, Object>> list = userMapper.getAllUsers2();
        for(Map<String, Object> map : list){
            System.out.println("map=" + map);
        }
    }

    @Test
    public void getUserById(){

        User user = userMapper.getUserById(6);
        System.out.println("user=" + user);
    }

    @Test
    public void getUserOrderBy(){

        List<User> list = userMapper.getUserOrderBy("id");
        for (User user : list){
            System.out.println("user=" + user);
        }
    }

    @Test
    public void getUserNameContains(){

        List<User> list = userMapper.getUserNameContains("java");
        for (User user : list){
            System.out.println("user=" + user);
        }
    }

    @Test
    public void updateUsernameById(){
        Integer result = userMapper.updateUsernameById("java233333", 2);
        System.out.println("result=" + result);
        sqlSession.commit();

    }

    @Test
    public void addUser(){
        User user = new User();
        user.setId(7);
        user.setUsername("java100");
        user.setAddress("广州广州");
        Integer result = userMapper.addUser(user);
        System.out.println("result=" + result);
        sqlSession.commit();
        System.out.println("user=" + user);
    }

    @Test
    public void addUser2(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",8);
        map.put("username","java8888");
        map.put("address","广东");
        Integer result = userMapper.addUser2(map);
        System.out.println("result=" + result);
        sqlSession.commit();
    }

    @Test
    public void getAllBooks(){
        List<Book> list = bookMapper.getAllBooks();
        for (Book book : list){
            System.out.println("book=" + book );
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
