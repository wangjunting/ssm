package com.soecode.lyf.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Book;

@Transactional
public class BookDaoTest extends BaseTest {

	@Autowired
	private BookDao bookDao;
	

	@SuppressWarnings("deprecation")
	@Test
	public void testQueryById() throws Exception {
		long bookId = 1000;
		Book book = bookDao.queryById(bookId);
		Assert.assertEquals("Java程序设计", book.getName());
	}

	@Test
	public void testQueryAll() throws Exception {
		String str=null;
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			str=str+book.getName();
		}
		Assert.assertEquals(null+"Java程序设计数据结构设计模式编译原理", str);
	}

	@Test
	public void testReduceNumber() throws Exception {
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		Assert.assertEquals(9, bookDao.queryById(bookId).getNumber());
	}

}
