package entity.counsel;

import java.util.ArrayList;

import exception.NotExistException;

/**
 * @author KimChan
 * @version 1.0
 * @created 27-5-2024 ���� 4:40:41
 */
public interface CounselList {

	/**
	 * 
	 * @param counsel
	 */
	public void add(Counsel counsel);

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
	public Counsel get(int id) throws NotExistException;

	/**
	 * 
	 * @param id
	 * @throws NotExistException 
	 */
	public void update(Counsel counsel) throws NotExistException;

	public ArrayList<Counsel> getAll();

}