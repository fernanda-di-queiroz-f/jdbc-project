package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("== Test 1 Department insert ==");
		Department department = new Department(null, "Music");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());

		System.out.println();
		System.out.println("=== TEST 2 : Department update, findAll, findById ===");
		Department dep = departmentDao.findById(6);
		dep.setName("Tax");
		departmentDao.update(dep);

		System.out.println("\nUpdate Completed! ");
		System.out.println("");

		List<Department> list = departmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== TEST 3 : Department deleteById ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed!!");

		sc.close();

		list = departmentDao.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

	}

}
