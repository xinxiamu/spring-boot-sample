package com.example.ymu.dao.impl;

import com.example.ymu.dao.BookDao;
import com.example.ymu.dao.base.BaseDaoImpl;
import com.example.ymu.dao.repository.BookRepository;
import com.example.ymu.domain.vo.VBook;
import jooq.gen.testDb.tables.Author;
import jooq.gen.testDb.tables.Book;
import jooq.gen.testDb.tables.records.BookRecord;
import org.jooq.Record2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BookDaoImpl extends BaseDaoImpl<BookRepository> implements BookDao {


    @Override
    public VBook getBookInfo(long bookId) {
        VBook vBook = jooqDsl.select(Book.BOOK.BOOK_NAME, Author.AUTHOR.NAME)
                .from(Book.BOOK)
                .leftJoin(Author.AUTHOR)
                .on(Book.BOOK.AUTHOR_ID.eq(Author.AUTHOR.ID))
                .where(Book.BOOK.ID.eq(bookId))
                .fetchOneInto(VBook.class);
        return vBook != null ? vBook : new VBook();
    }

    @Override
    public List<VBook> getAll() {
        List<VBook> result = jooqDsl.select(Book.BOOK.BOOK_NAME,Author.AUTHOR.NAME)
                .from(Book.BOOK)
                .leftJoin(Author.AUTHOR)
                .on(Book.BOOK.AUTHOR_ID.eq(Author.AUTHOR.ID))
                .fetchInto(VBook.class);
        return result != null ? result : new ArrayList<VBook>();
    }

    @Override
    public String getBookNameById(long bookId) {
        BookRecord bookRecord = jooqDsl.selectFrom(Book.BOOK).where(Book.BOOK.ID.eq(bookId)).fetchOne();
        return bookRecord.getBookName();
    }
}
