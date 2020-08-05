package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department department = new Department(1, "Books");
		System.out.println(department);

		Seller seller = new Seller(1, "Julia Roberts", "julia@gamil.com", new Date(), 3000.0, department);
		System.out.println(seller);

		SellerDao sellerDao = DaoFactory.createSellerDao();

	}

}
