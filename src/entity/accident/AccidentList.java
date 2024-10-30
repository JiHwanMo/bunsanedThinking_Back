package entity.accident;

import java.util.ArrayList;

import exception.NotExistException;

/**
 * @author KimChan
 * @version 1.0
 * @created 27-5-2024 ���� 4:40:40
 */
public interface AccidentList {

	/**
	 * 
	 * @param accident
	 * @return 
	 */
	public int add(Accident accident);

	/**
	 * 
	 * @param id
	 */
	public void delete(int id) throws NotExistException;

	/**
	 * 
	 * @param id
	 */
	public Accident get(int id) throws NotExistException;

	/**
	 * 
	 * @param id
	 */
	public void update(Accident accident) throws NotExistException;

	public ArrayList<Accident> getAll();

	public ArrayList<Accident> getAllCompletedReport();

	public ArrayList<Accident> getAllUnprocessedReport();

	public ArrayList<Accident> getAllByCustomer(int id);

}