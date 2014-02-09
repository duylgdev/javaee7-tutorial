package eu.daxiongmao.tutorial.frontend.pages;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import eu.daxiongmao.tutorial.backend.dao.db.common.IUserDbDao;
import eu.daxiongmao.tutorial.model.common.User;

@ManagedBean
@RequestScoped
public class IndexBacking {

	@EJB
	private IUserDbDao userDAO;

	private List<User> users;

	public List<User> getUsers() {
		if (users == null || users.isEmpty()) {
			users = userDAO.findAll();
		}
		return users;
	}

}
