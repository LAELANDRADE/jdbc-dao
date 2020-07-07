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

		
		System.out.println("===>>>  01. Testando o department findById  <<<===");
		
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		
		System.out.println("\n===>>>  02. Testando o department findAll  <<<===");
		
		List <Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===>>>  03. Testando o department insert   <<<===");
		
		Department newDep = new Department (null, "Clothes");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		System.out.println(newDep);
		
		System.out.println("\n===>>>  04. Testando o department update    <<<===");
		
		department = departmentDao.findById(6);
		department.setName("Music");
		departmentDao.update(department);	
		System.out.println("Update OK! id = " + department.getId());
		System.out.println(department);
		
		System.out.println("\n===>>>  05. Testando o department delete   <<<===");
		
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);	
		System.out.println("Department Deleted OK! ==>> Department: " + id);
		sc.close();
	}
}