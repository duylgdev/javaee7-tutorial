package eu.daxiongmao.tutorial.backend.dao.db.common;

import javax.ejb.Local;

import eu.daxiongmao.tutorial.backend.dao.db.IAssetDbDao;
import eu.daxiongmao.tutorial.model.common.User;

/**
 * USER database dao.
 * 
 * @author Guillaume Diaz
 * @version 1.0 - January 2014
 * 
 */
@Local
public interface IUserDbDao extends IAssetDbDao<User> {

}
