import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {
	/*
	 * calculate fare when distance and time is provided
	 */
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time, "normal");
		Assert.assertEquals(25, fare, 0.0);
	}

	/*
	 * return minimum fare when distance and time is less
	 */
	@Test
	public void givenLessDistanceMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time, "normal");
		Assert.assertEquals(5, fare, 0.0);
	}

	/*
	 * calculate fare for multiple rides
	 */
	@Test
	public void givenMultipleRideReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare = invoiceGenerator.calculateFare(rides, "normal");
		Assert.assertEquals(30, fare, 0.0);
	}

	/*
	 * to get summary of multiple rides
	 */
	@Test
	public void givenMultipleRideReturnInvoiceSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(1, rides, "normal");
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

	/*
	 * to get summary based on id
	 */
	@Test
	public void givenMultipleRideReturnSummaryById() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(1, rides, "normal");
		// InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		InvoiceSummary expectedInvoiceSummary = invoiceGenerator.getSummaryById(1);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}

	/*
	 * generate invoice summary for premium rides
	 */
	@Test
	public void givenMultipleRideReturnSummaryForPremium() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(1, rides, "premium");
		// InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
		InvoiceSummary expectedInvoiceSummary = invoiceGenerator.getSummaryById(1);
		Assert.assertEquals(expectedInvoiceSummary, summary);
	}
}
