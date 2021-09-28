public class InvoiceGenerator {
	private static final int COST_PER_TIME = 1;
	private static double  MINIMUM_COST_PER_KM = 10.0;

	public double calculateFare(double distance, int time) {
		return distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;		
	}
}
