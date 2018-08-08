package by.htp.main.dao;

import java.util.List;

import by.htp.main.entity.TourManager;

public interface ManagerDAO {
	
	boolean checkEmail(String eMail);
	void createManager(TourManager manager);
	void editManager(int oldManagerId, TourManager newManager);
	List<TourManager> getManagers();
	TourManager getOneManager(TourManager manager);
	void removeManager(int managerId);

}
