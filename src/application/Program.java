package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		if (checkOut.before(checkIn)) {
			System.out.println("Check-out data must be after check-in date");
		}
		else if(checkIn.before(now) || checkOut.before(now)){
			System.out.println("Check-in and check-out dates must be after current date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date updCheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date updCheckOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(updCheckIn, updCheckOut);
			if(error != null) {
				System.out.println("Error in reservation. " + error);
			}
			else {
				System.out.println(reservation);
			}
			
		}

		sc.close();
	}

}
