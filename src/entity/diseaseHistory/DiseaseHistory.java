package entity.diseaseHistory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ����ȯ
 * @version 1.0
 * @created 27-5-2024 ���� 4:40:41
 */
//2024-06-04 김대현
public class DiseaseHistory implements Cloneable{
	public static final int DISEASE_HISTORY_SERIAL_NUMBER = 510;

	private int customerID;
	private Date diagnosisDate;
	private int id;
	private String name;

	public DiseaseHistory(String name, Date date) {
		this.setName(name);
		this.setDiagnosisDate(date);
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getDiagnosisDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.diagnosisDate);
	}

	public void setDiagnosisDate(Date diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void finalize() throws Throwable {

	}
	public DiseaseHistory clone(){
		DiseaseHistory diseaseHistory = new DiseaseHistory(getName(), this.diagnosisDate);
		diseaseHistory.setId(getId());
		diseaseHistory.setCustomerID(getCustomerID());
		return diseaseHistory;
		
	}
}