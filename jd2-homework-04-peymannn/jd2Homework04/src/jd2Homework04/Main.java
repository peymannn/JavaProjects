package jd2Homework04;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	static ArrayList<MusicAlbum> musicAlbums;
	static Customer whichCustomer;
	static Basket basket;

	public static void main(String[] args) {

		ArrayList<Customer> customers = new ArrayList<>();
		musicAlbums = new ArrayList<>();
		init(customers);

		selectCustomer(customers);

		generateBasket();

		selectAlbum();

	}

	private static void selectCustomer(ArrayList<Customer> customers) {
		for (var customer : customers) {
			customer.printCustomerInfo();
		}
		Scanner scanner;
		int customerID = 0;
		do {
			System.out.println("which Customer (1 or 2 entry)");
			scanner = new Scanner(System.in);
			customerID = scanner.nextInt();
		} while (!(customerID == 1 || customerID == 2));
		whichCustomer = customers.get(customerID - 1);
	}

	private static void selectAlbum() {
		System.out.println("----------------------------");
		System.out.println("Album Info");
		System.out.println("----------------------------");
		for (var album : musicAlbums) {
			album.printAlbumInfo();
		}
		Scanner scanner;
		MusicAlbum whichAlbum;
		int albumID = 0;
		do {
			System.out.println("please entry album ID");
			scanner = new Scanner(System.in);
			albumID = scanner.nextInt();
		} while (!(albumID == 1 || albumID == 2));

		basket.addAlbum(musicAlbums.get(albumID - 1));
		basketProcess();
	}

	private static void removeAlbum() {
		Scanner scanner;
		MusicAlbum whichAlbum;
		int albumID = 0;
		do {
			System.out.println("please entry album ID for remove");
			scanner = new Scanner(System.in);
			albumID = scanner.nextInt();
		} while (!(albumID == 1 || albumID == 2));

		basket.removeAlbum(albumID);
	}

	private static void searchAlbum() {
		Scanner scanner;
		int albumID = 0;
		do {
			System.out.println("please entry album ID for search");
			scanner = new Scanner(System.in);
			albumID = scanner.nextInt();
		} while (!(albumID == 1 || albumID == 2));
		MusicAlbum album = new MusicAlbum();
		album.id = albumID;
		basket.searchAlbum(album);
	}

	private static void searchAlbumName() {
		Scanner scanner;
		String albumName;
		System.out.println("please entry album Name for search");
		scanner = new Scanner(System.in);
		albumName = scanner.next();
		MusicAlbum album = new MusicAlbum();
		album.setAlbumName(albumName);
		basket.searchAlbumByAlbumName(album);
	}

	private static void searchAlbumPrice() {
		Scanner scanner;
		double albumPrice;
		System.out.println("please entry album Price for search");
		scanner = new Scanner(System.in);
		albumPrice = scanner.nextDouble();
		MusicAlbum album = new MusicAlbum();
		album.setPrice(albumPrice);
		basket.searchAlbumByPrice(album);
	}

	private static void basketProcess() {
		Scanner scanner;
		int choose = 0;
		do {
			System.out.println(
					"for select Album : 1 \nfor remove Album : 2 \nfor search Album : 3 \nfor Basket Info : 4 \nfor finish Shopping : 5 \n");
			scanner = new Scanner(System.in);
			choose = scanner.nextInt();
		} while (!(choose == 1 || choose == 2 || choose == 3 || choose == 4 || choose == 5));

		if (choose == 1) {
			selectAlbum();
		} else if (choose == 2) {
			removeAlbum();
			basketProcess();
		} else if (choose == 3) {
			System.out.println(
					"for search Album with ID : 1 \nfor search Album with Name : 2 \nfor search Album with Price : 3 \n");
			scanner = new Scanner(System.in);
			int searchChoose = scanner.nextInt();
			if (searchChoose == 1) {
				searchAlbum();
			} else if (searchChoose == 2) {
				searchAlbumName();
			} else if (searchChoose == 3) {
				searchAlbumPrice();
			}
			basketProcess();

		} else if (choose == 4) {
			basket.printBasketInfo();
			basketProcess();
		} else {
			basket.buyInBasketAlbums();
		}
	}

	private static void generateBasket() {
		basket = new Basket(1, whichCustomer);
	}

	private static void init(ArrayList<Customer> customers) {
		ArrayList<Song> songs = new ArrayList<>();
		ArrayList<Song> songs2 = new ArrayList<>();
		Song songOne = new Song("belalım", "arabesk", "ibo", 4);
		Song songTwo = new Song("güzelim", "pop", "tarkan", 3);
		songs.add(songOne);
		songs2.add(songTwo);
		Customer customerOne = new Customer(1, "peyman", "x@gmail.com ");
		Customer customerTwo = new Customer(2, "fatih", "y@gmail.com ");
		customers.add(customerOne);
		customers.add(customerTwo);
		MusicAlbum albumOne = new MusicAlbum(1, "sevdik", "ibo", new Date(System.currentTimeMillis()), songs, 1.5);
		MusicAlbum albumTwo = new MusicAlbum(2, "sevdalanduk", "tarkan", new Date(System.currentTimeMillis()), songs2,
				2.5);
		songOne.setAlbum(albumOne);
		songTwo.setAlbum(albumTwo);
		musicAlbums.add(albumOne);
		musicAlbums.add(albumTwo);
	}

}
