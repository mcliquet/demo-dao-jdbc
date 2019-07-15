package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department insert ====");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== Test 2: seller findByID ====");
		Department department = departmentDao.findByID(3);
		System.out.println(department);
		
		System.out.println("=== Test 3: department Update ====");
		department = departmentDao.findByID(6);
		department.setName("House");
		departmentDao.update(department);
		System.out.println("Update Complete");
		
		System.out.println("\n=== Test 4: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteByID(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== Test 5: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}
		
		sc.close();
	}

}
