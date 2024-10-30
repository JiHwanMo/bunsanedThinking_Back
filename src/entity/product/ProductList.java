package entity.product;

import java.util.ArrayList;

import entity.insurance.Insurance;
import entity.loan.Loan;
import exception.NotExistException;

/**
 * @author KimChan
 * @version 1.0
 * @created 20-5-2024 ���� 7:52:27
 */

//2024-05-29 김대현
//2024-06-02 김대현
public interface ProductList {

	/**
	 * 
	 * @param product
	 */
	public void add(Product product);

	/**
	 * 
	 * @param id
	 * @throws NotExistException 
	 */
	public void delete(int id) throws NotExistException;

	/**
	 * 
	 * @param id
	 * @throws NotExistException 
	 */
	public Product get(int id) throws NotExistException;

	public ArrayList<Product> getAll();

	public ArrayList<Insurance> getAllInsurance();

	public ArrayList<Insurance> getAllAutomobileInsurance();

	public ArrayList<Insurance> getAllInjuryInsurance();

	public ArrayList<Insurance> getAllDiseaseInsurance();

	public ArrayList<Loan> getAllLoan();

	public ArrayList<Loan> getAllCollateralLoan();

	public ArrayList<Loan> getAllFixedDepositLoan();

	public ArrayList<Loan> getAllInsuranceContractLoan();

	void update(Product product) throws NotExistException;

	public Loan getLoan(int id) throws NotExistException;

	public Insurance getInsurance(int id) throws NotExistException;

}