package com.soecode.lyf.dao;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Appointment;


public class AppointmentDaoTest extends BaseTest {

	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private BookDao bookDao;

	@Test
	@Transactional
	public void testInsertAppointment() throws Exception {
		long bookId = 1000;
		long studentId = 12345678910L;
		int insert = appointmentDao.insertAppointment(bookId, studentId);
		Appointment appointment=appointmentDao.queryByKeyWithBook(bookId, studentId);
		assertEquals(1000, appointment.getBookId());
		assertEquals(12345678910L, appointment.getStudentId());
		
	}

	/*@Test
	@Transactional
	public void testQueryByKeyWithBook() throws Exception {
		long bookId = 1000;
		long studentId = 12345678910L;
		Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
		Assert.assertEquals(1000, appointment.getBookId());
		Assert.assertEquals(12345678910L, appointment.getStudentId());
	}*/

}
