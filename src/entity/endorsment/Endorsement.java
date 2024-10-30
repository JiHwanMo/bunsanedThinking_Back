package entity.endorsment;

import java.util.Date;

import entity.contract.Contract;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-5-2024 ���� 4:40:42
 */
public class Endorsement extends Contract {

	public Endorsement(Contract contract) {
		super(contract);
		// TODO Auto-generated constructor stub
	}

	private Date applyDate;
	private EndorsementStatus endorsementStatus;

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public EndorsementStatus getEndorsementStatus() {
		return endorsementStatus;
	}

	public void setEndorsementStatus(EndorsementStatus endorsementStatus) {
		this.endorsementStatus = endorsementStatus;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void apply(){

	}

	public void review(){

	}

}