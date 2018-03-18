import java.util.*;

public class BoxOffice {
	
	public void pickupTicket(int date, int hour, int reservationNumber, String name, String phone, Map<Integer, Order> orderMap)
	{
		if (!orderMap.containsKey(reservationNumber)){
			System.out.println("Pickup fail. No such reservation.");
			return;
		}

		Order order = orderMap.get(reservationNumber);
		if (!order.getCustomerName().equals(name) || !order.getPhoneNumber().equals(phone)){
			System.out.println("Pickup fail. Identification check fail.");
			return;
		}

		if (order.isCanceled()){
			System.out.println("Pickup fail. Reservation already cancelled.");
			return;
		}

		if (order.isPickedUp()){
			System.out.println("Pickup fail. Reservation already picked up.");
			return;
		}

		order.setPickedUp(true);
		orderMap.put(order.getReservationNumber(), order);
		System.out.println("Pickup #" + order.getReservationNumber() + ". name: " + order.getCustomerName() + ", tickets: " + order.getNumberOfTickets());
		
	}

}