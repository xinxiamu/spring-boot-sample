package com.example.ymu.dao.impl;

import com.example.ymu.dao.BookDao;
import com.example.ymu.dao.base.BaseDaoImpl;
import com.example.ymu.dao.repository.BookRepository;
import com.example.ymu.domain.vo.VBook;
import jooq.generated.tables.Author;
import jooq.generated.tables.Book;
import jooq.generated.tables.records.BookRecord;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static jooq.generated.tables.Book.*;


@Repository
public class BookDaoImpl extends BaseDaoImpl<BookRepository> implements BookDao {


    @Override
    public VBook getBookInfo(long bookId) {
        VBook vBook = jooqDsl.select(BOOK.BOOK_NAME, Author.AUTHOR.NAME)
                .from(BOOK)
                .leftJoin(Author.AUTHOR)
                .on(BOOK.AUTHOR_ID.eq(Author.AUTHOR.ID))
                .where(BOOK.ID.eq(bookId))
                .fetchOneInto(VBook.class);
        return vBook != null ? vBook : new VBook();
    }

    @Override
    public List<VBook> getAll() {
        List<VBook> result = jooqDsl.select(BOOK.BOOK_NAME,Author.AUTHOR.NAME)
                .from(BOOK)
                .leftJoin(Author.AUTHOR)
                .on(BOOK.AUTHOR_ID.eq(Author.AUTHOR.ID))
                .fetchInto(VBook.class);
        return result != null ? result : new ArrayList<VBook>();
    }

    @Override
    public String getBookNameById(long bookId) {
        Result<BookRecord> bookRecord = jooqDsl.selectFrom(BOOK).where(BOOK.ID.equals(bookId)).fetch();
        return "";
    }
}
