package by.htp.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.main.entity.TourManager;

@Repository
public class HibernateManagerDAO implements ManagerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean checkEmail(String eMail) {
		
		if(eMail == null || eMail.isEmpty()) return false;
		
		Session session = sessionFactory.getCurrentSession();
		List<TourManager> managerFromDBList = session.createQuery("from TourManager where eMail=" + "\'" + eMail + "\'").list();
		System.out.println(managerFromDBList + "DAOImpl line26");
		if(managerFromDBList != null) return true;
		else return false;
	}
	
	@Override
	public void createManager(TourManager manager) {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.saveOrUpdate(manager);
		//session.getTransaction().commit();		
		
	}

	@Override
	public void editManager(int oldManagerId, TourManager newManager) {
		
		
	}

	@Override
	public List<TourManager> getManagers() {
		Session session = sessionFactory.getCurrentSession();
		List<TourManager> managerList = session.createQuery("from TourManager").list();
		return managerList;
	}

	@Override
	public TourManager getOneManager(TourManager manager) {
		Session session = sessionFactory.getCurrentSession();
		
		TourManager managerFromDB = (TourManager) session.createQuery("from TourManager where eMail=" + "\'" + manager.geteMail() + "\'" ).list().get(0);				
		
		if(managerFromDB.getHashPassword().equals(manager.getHashPassword())) return managerFromDB;
		
		else return null;
		
	}

	@Override
	public void removeManager(int managerId) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from TourManager where id=" + "\'" + managerId + "\'" );
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	

}
