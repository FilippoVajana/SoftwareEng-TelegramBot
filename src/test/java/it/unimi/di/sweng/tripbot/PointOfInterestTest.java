package it.unimi.di.sweng.tripbot;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;
import org.mockito.Mockito;

public class PointOfInterestTest {

	@Test
	public void pointOfInterestTest() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Rome"));
		Date date = dateFormat.parse("2016-06-03-09.00.00");
		GMapsPosition mockPosition = Mockito.mock(GMapsPosition.class);
		Mockito.when(mockPosition.toString()).thenReturn("fake-position");
		String expectedOutput = 
				"Location: Museum A\nDate: Fri Jun 03 09:00:00 CEST 2016\nPosition: fake-position\nGroup ID: 1";
		PointOfInterest pointOfInterest = new PointOfInterest("Museum A", date, mockPosition, "1");
		assertEquals(expectedOutput, pointOfInterest.toString());
	}
}
