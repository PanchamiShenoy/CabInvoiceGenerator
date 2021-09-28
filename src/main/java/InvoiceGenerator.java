import java.util.HashMap;

public class InvoiceGenerator {
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final double MINIMUM_FARE = 5;

	private static final int COST_PER_TIME_PREMIUM = 2;
	private static final double MINIMUM_COST_PER_KM_PREMIUM = 15.0;
	private static final double MINIMUM_FARE_PREMIUM = 20;
	HashMap<Integer, InvoiceSummary> map = new HashMap<>();

	/*
	 * method to calculate fare
	 */
	public double calculateFare(double distance, int time, String category) {
		if (category.equals("premium")) {
			double totalFare = distance * MINIMUM_COST_PER_KM_PREMIUM + time * COST_PER_TIME_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		} else {
			double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
			return Math.max(totalFare, MINIMUM_FARE);
		}
	}

	/*
	 * method to calculate fare for multiple ride
	 */
	public double calculateFare(Ride[] rides, String category) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time, category);
		}
		return totalFare;
	}

	/*
	 * method to get invoice summary of multiple rides
	 */
	public InvoiceSummary getInvoiceSummary(int id, Ride[] rides, String category) {
		double totalFare = 0;
		totalFare = this.calculateFare(rides, category);
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