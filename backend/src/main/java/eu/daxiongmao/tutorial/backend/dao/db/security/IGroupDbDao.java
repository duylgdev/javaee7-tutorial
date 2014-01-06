package eu.daxiongmao.tutorial.backend.dao.db.security;

import javax.ejb.Local;

import eu.daxiongmao.tutorial.backend.dao.db.IGenericDbDao;
import eu.daxiongmao.tutorial.model.security.Group;

/**
 * GROUP database dao.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - January 2014
 * 
 */
@Local
public interface IGroupDbDao extends IGenericDbDao<Group> {

}
