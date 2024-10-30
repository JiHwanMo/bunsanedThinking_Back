package controller;

import java.util.ArrayList;

import entity.insurance.Automobile;
import entity.insurance.Disease;
import entity.insurance.Injury;
import entity.insurance.InjuryType;
import entity.insurance.Insurance;
import entity.insurance.InsuranceType;
import entity.insurance.ServiceType;
import entity.insurance.VehicleType;
import entity.product.Product;
import entity.product.ProductList;
import exception.DuplicateInsuranceException;
import exception.NotExistException;
import model.productManagement.ProductManagementModel;

public class ProductManagementController {
	private ProductManagementModel productManagementModel;
	public ProductManagementController() {
		productManagementModel = new ProductManagementModel();
	}
	public void addInsuranceProduct(InsuranceType insuranceType, String name, int limit, int ageRange, String coverage, int monthlyPremium,
			int contractPeriod, String diseaseName, int diseaseLimit, int surgeriesLimit, ProductList productList) throws DuplicateInsuranceException {
		productManagementModel.addInsuranceProduct(insuranceType, name, limit, ageRange, coverage, monthlyPremium, 
				contractPeriod, diseaseName, diseaseLimit, surgeriesLimit, productList);
	}

	public void addInsuranceProduct(InsuranceType insuranceType, String name, int limit, int ageRange, String coverage, int monthlyPremium,
			int contractPeriod, InjuryType injuryType, int surgeriesLimit, ProductList productList) throws DuplicateInsuranceException {
		productManagementModel.addInsuranceProduct(insuranceType, name, limit, ageRange, coverage, 
				monthlyPremium, contractPeriod, injuryType, surgeriesLimit, productList);
	}

	public void addInsuranceProduct(InsuranceType insuranceType, String name, int limit, int ageRange, String coverage, int monthlyPremium,
			int contractPeriod, int accidentLimit, VehicleType vehicleType, ArrayList<ServiceType> serviceTypeList,
			ProductList productList) throws DuplicateInsuranceException {
		productManagementModel.addInsuranceProduct(insuranceType, name, limit, ageRange, coverage, monthlyPremium, 
				contractPeriod, accidentLimit, vehicleType, serviceTypeList, productList);
	}

	public void deleteInsuranceProduct(ProductList productList, int id) throws NotExistException {
		productManagementModel.deleteInsuranceProduct(productList, id);
	}

	public Insurance getInsuranceProduct(ProductList productList, int id) throws NotExistException {
		return productManagementModel.getInsuranceProduct(productList, id);
	}

	public void updateInsuranceProduct(int index, String input, Disease diseaseInsurance, ProductList productList) throws DuplicateInsuranceException, NotExistException {
		productManagementModel.updateInsuranceProduct(index, input, diseaseInsurance, productList);
	}

	public void updateInsuranceProduct(int index, String input, Injury injuryInsurance, ProductList productList) throws DuplicateInsuranceException, NotExistException {
		productManagementModel.updateInsuranceProduct(index, input, injuryInsurance, productList);
	}

	public void updateInsuranceProduct(int index, String input, Automobile automobileInsurance, ArrayList<ServiceType> serviceTypeList, ProductList productList) throws DuplicateInsuranceException, NotExistException {
		productManagementModel.updateInsuranceProduct(index, input, automobileInsurance, serviceTypeList, productList);
	}
	public ArrayList<Product> getAll(ProductList productList){
		return productManagementModel.getAll(productList);
	}
}
