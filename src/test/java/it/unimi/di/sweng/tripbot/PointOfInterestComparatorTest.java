package it.unimi.di.sweng.tripbot;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.mockito.Mockito;

import it.unimi.di.sweng.tripbot.Geolocalization.GmapsPosition;

public class PointOfInterestComparatorTest {
	
	@Rule
	public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max

	@BeforeClass
	public static void setUpTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	@Test
	public void pointOfInterestComparatorTest() throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		Date date1 = dateFormat.parse("2016-06-03-09.00.00");
		Date date2 = dateFormat.parse("2016-06-10-09.00.00");
		GmapsPosition mockPosition = Mockito.mock(GmapsPosition.class);
		Mockito.when(mockPosition.toString()).thenReturn("fake-position");
		PointOfInterest pointOfInterest1 = new PointOfInterest("Museum A", date1, mockPosition, "1");
		PointOfInterest pointOfInterest2 = new PointOfInterest("Museum A", date2, mockPosition, "1");
		PointOfInterestComparator myComparator = new PointOfInterestDateComparator();
		assertEquals(-1, myComparator.compare(pointOfInterest1, pointOfInterest2));
	}

}