package by.htp.main.service;

import java.util.List;

import by.htp.main.entity.TourManager;

public interface ManagerService {

	TourManager createManager(TourManager manager);
	TourManager logination(TourManager manager);
	boolean checkeMail(String eMail);	
	List<TourManager> getAllManagers();
	void deleteManager(int id);
	
	
}
