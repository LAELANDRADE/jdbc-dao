package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		
		System.out.println("===>>>  01. Testando o seller findById  <<<===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n===>>>  02. Testando o seller findByDepartment  <<<===");
		
		Department department = new Department (2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===>>>  03. Testando o seller findAll  <<<===");
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n===>>>  04. Testando o insert seller   <<<===");
		
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		System.out.println(newSeller);
		
		System.out.println("\n===>>>  05. Testando o update seller   <<<===");
		
		seller = sellerDao.findById(9);
		seller.setName("Martha Waine");
		seller.setEmail("marthawaine@hotmail.com");
		sellerDao.update(seller);
				
		System.out.println("Update OK! id = " + seller.getId());
		System.out.println(seller);
		
	}
}