package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1 : Seller findById ===");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println();
		System.out.println("=== TEST 2 : Seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== TEST 3 : Seller findAll ===");

		List<Seller> list1 = sellerDao.findAll();

		for (Seller obj : list1) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== TEST 4 : Seller insert ===");
		Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		// sellerDao.insert(seller1);
		// System.out.println("Inserted! New id = " + seller1.getId());

		System.out.println();
		System.out.println("=== TEST 5 : Seller update ===");
		seller = sellerDao.findById(8);
		seller.setName("Noelle Page");
		sellerDao.update(seller);

		System.out.println("Update Completed! ");

		list1 = sellerDao.findAll();

		for (Seller obj : list1) {
			System.out.println(obj);
		}

		System.out.println("=== TEST 6 : Seller deleteById ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete Completed!!");

		sc.close();

	}

}
