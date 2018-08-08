package by.htp.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.main.dao.ManagerDAO;
import by.htp.main.entity.TourManager;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	private ManagerDAO managerDAO;
	
	@Transactional
	@Override
	public TourManager createManager(TourManager manager) {
		
		if(checkeMail(manager.geteMail())) {
			return null;
		}		
		
		managerDAO.createManager(manager);		
		
		return logination(manager); // по логике не может быть налом 
	}	

	@Transactional
	@Override
	public TourManager logination(TourManager manager) {
		
		if(!checkeMail(manager.geteMail())) {
			return null;
		}	
		
		TourManager managerFromDB = managerDAO.getOneManager(manager);
		System.out.println(managerFromDB + "serviceImpl line 40");
		
		return managerFromDB; // может быть налом, если пароль не совпал
	}

	@Transactional
	@Override
	public boolean checkeMail(String eMail) {
		
		System.out.println(managerDAO.checkEmail(eMail) + "serviceImpl line48");
		if(managerDAO.checkEmail(eMail)) return true; // true если логин есть
		else return false; // false если нет логина
	}	
	
	public void setManagerDAO(ManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	@Transactional
	@Override
	public List<TourManager> getAllManagers() {
		
		return managerDAO.getManagers();
	}

	@Transactional
	@Override
	public void deleteManager(int id) {
		managerDAO.removeManager(id);		
	}
}
