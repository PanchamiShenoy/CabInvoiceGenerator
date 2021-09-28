import java.util.HashMap;

public class InvoiceGenerator {
	private static final int COST_PER_TIME = 1;
	private static double MINIMUM_COST_PER_KM = 10.0;
	private static double MINIMUM_FARE = 5.0;
	HashMap<Integer,InvoiceSummary> map =new HashMap<>();
	
	/*
	 * method to calculate fare
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	/*
	 * method to calculate fare for multiple ride
	 */
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}

	/*
	 * method to get invoice summary of multiple rides
	 */
	public InvoiceSummary getInvoiceSummary(int id,Ride[] rides) {
		double totalFare = 0;
		totalFare = this.calculateFare(rides);
		InvoiceSummary invoice = new InvoiceSummary(rides.length, totalFare);
		map.put(id, invoice);
		return invoice;
	}
	/*
	 * method to get summary by id
	 */
	public InvoiceSummary getSummaryById(int id) {
		return map.get(id);
	}
}
