package com.example.library00.book.dao;

import com.example.library00.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    private final static String ADD_BOOK_SQL="INSERT INTO book_info VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?)";
    private final static String DELETE_BOOK_SQL="delete from book_info where book_id = ?";
    private final static String EDIT_BOOK_SQL="update book_info set name=?,author=?,publish=?,ISBN=?,introduction=?,language=?,price=?,pubdate=?,class_id =?,pressmark=?,state=? where book_id=? ;";
    private final static String QUERY_ALL_BOOKS_SQL="SELECT * FROM book_info";
    private final static String QUERY_BOOK_SQL="SELECT * FROM book_info where book_id like ? or name like ?";
    private final static String MATCH_BOOK_SQL="SELECT count(*) FROM book_info WHERE book_id like ?  or name like ?  ";
    //根据书号查询图书
    private final static String GET_BOOK_SQL="SELECT * FROM book_info where book_id = ? ";

    public int matchBook(String serchWord){
        String swcx = "%"+serchWord+"%";
        return jdbcTemplate.queryForObject(MATCH_BOOK_SQL,new Object[]{swcx,swcx},Integer.class);
    }
    public ArrayList<Book> queryBook(String sw){
        String swcx = "%"+sw+"%";
        final ArrayList<Book> books=new ArrayList<Book>();
        jdbcTemplate.query(QUERY_BOOK_SQL, new Object[]{swcx, swcx}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                rs.beforeFirst();
                while(rs.next()){
                    Book book = new Book();
                    book.setAuthor(rs.getString("author"));
                    book.setBookId(rs.getLong("book_id"));
                    book.setClassId(rs.getInt("class_id"));
                    book.setIntroduction(rs.getString("introduction"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setLanguage(rs.getString("language"));
                    book.setName(rs.getString("name"));
                    book.setPressmark(rs.getInt("pressmark"));
                    book.setPubdate(rs.getDate("pubdate"));
                    book.setPrice(rs.getBigDecimal("price"));
                    book.setState(rs.getInt("state"));
                    book.setPublish(rs.getString("publish"));
                    books.add(book);
                }
            }
        });
        return books;
    }
    public ArrayList<Book> getAllBooks() {
        final ArrayList<Book> books = new ArrayList<>();
        jdbcTemplate.query(QUERY_ALL_BOOKS_SQL, new ResultSetExtractor<ArrayList<Book>>() {
            @Override
            public ArrayList<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    Book book = new Book();
                    book.setPrice(rs.getBigDecimal("price"));
                    book.setState(rs.getInt("state"));
                    book.setPublish(rs.getString("publish"));
                    book.setPubdate(rs.getDate("pubdate"));
                    book.setName(rs.getString("name"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setClassId(rs.getInt("class_id"));
                    book.setBookId(rs.getLong("book_id"));
                    book.setAuthor(rs.getString("author"));
                    book.setIntroduction(rs.getString("introduction"));
                    book.setPressmark(rs.getInt("pressmark"));
                    book.setLanguage(rs.getString("language"));
                    books.add(book);
                }
                return books;
            }
        });
        return books;
    }

    public int deleteBook(long bookId){

        return jdbcTemplate.update(DELETE_BOOK_SQL,bookId);
    }

    public int addBook(Book book){
        String name = book.getName();
        String author = book.getAuthor();
        String publish = book.getPublish();
        String isbn = book.getIsbn();
        String introduction = book.getIntroduction();
        String language = book.getLanguage();
        BigDecimal price = book.getPrice();
        Date pubdate=book.getPubdate() ;
        int classId = book.getClassId();
        int pressmark=book.getPressmark();
        int state = book.getState();

        return jdbcTemplate.update(ADD_BOOK_SQL,new Object[]{name,author,publish,isbn,introduction,language,price,pubdate,classId,pressmark,state});
    }

    public Book getBook(Long bookId){
        final Book book = new Book();
        jdbcTemplate.query(GET_BOOK_SQL, new Object[]{bookId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                book.setAuthor(rs.getString("author"));
                book.setBookId(rs.getLong("book_id"));
                book.setClassId(rs.getInt("class_id"));
                book.setIntroduction(rs.getString("introduction"));
                book.setIsbn(rs.getString("isbn"));
                book.setLanguage(rs.getString("language"));
                book.setName(rs.getString("name"));
                book.setPressmark(rs.getInt("pressmark"));
                book.setPubdate(rs.getDate("pubdate"));
                book.setPrice(rs.getBigDecimal("price"));
                book.setState(rs.getInt("state"));
                book.setPublish(rs.getString("publish"));
            }
        });
        return book;
    }
    public int editBook(Book book){
        Long bookId=book.getBookId();
        String name=book.getName();
        String author=book.getAuthor();
        String publish=book.getPublish();
        String isbn=book.getIsbn();
        String introduction=book.getIntroduction();
        String language=book.getLanguage();
        BigDecimal price=book.getPrice();
        Date pubdate=book.getPubdate();
        int classId=book.getClassId();
        int pressmark=book.getPressmark();
        int state=book.getState();

        return jdbcTemplate.update(EDIT_BOOK_SQL,new Object[]{name,author,publish,isbn,introduction,language,price,pubdate,classId,pressmark,state,bookId});
    }
}
