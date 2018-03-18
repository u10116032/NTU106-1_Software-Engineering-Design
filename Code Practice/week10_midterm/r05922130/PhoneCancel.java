import java.util.*;

public class PhoneCancel implements CancelService {

	public void cancelTicket(int date, int hour, int reservationNumber, String name, String phone, Map<Integer, Order> orderMap)
	{
		if (!orderMap.containsKey(reservationNumber)){
			System.out.println("Cancel fail. No such reservation.");
			return;
		}

		Order order = orderMap.get(reservationNumber);
		if (!order.getCustomerName().equals(name) || !order.getPhoneNumber().equals(phone)){
			System.out.println("Cancel fail. Identification check fail.");
			return;
		}

		if (order.isCanceled()){
			System.out.println("Cancel fail. Reservation already cancelled.");
			return;
		}

		if (order.isPickedUp()){
			System.out.println("Cancel fail. Reservation already picked up.");
			return;
		}

		order.setCanceled(true);
		orderMap.put(order.getReservationNumber(), order);
		System.out.println("Cancel #" + order.getReservationNumber() + ". name: " + order.getCustomerName() + ", tickets: " + order.getNumberOfTickets());
	}

}