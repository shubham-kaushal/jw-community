package org.joget.apps.app.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.joget.apps.app.model.UserReplacement;
import org.joget.commons.spring.model.AbstractSpringDao;

public class UserReplacementDaoImpl extends AbstractSpringDao implements UserReplacementDao {
    
    public static final String ENTITY_NAME = "UserReplacement";

    public void saveUserReplacement(UserReplacement userReplacement) {
        super.saveOrUpdate(ENTITY_NAME, userReplacement);
    }

    public UserReplacement getUserReplacement(String id) {
        return (UserReplacement) super.find(ENTITY_NAME, id);
    }
    
    public List<UserReplacement> getTodayUserReplacements(String username) {
        Collection<Object> params = new ArrayList<Object>();
        String condition = " where e.replacementUser = ? and ? between e.startDate and e.endDate";
        params.add(username);
        params.add(new Date());
        
        return (List<UserReplacement>) super.find(ENTITY_NAME, condition, params.toArray(), null, null, null, null);
    }
    
    public List<UserReplacement> getUserReplacements(String condition, Object[] param, String sort, Boolean desc, Integer start, Integer rows) {
        return (List<UserReplacement>) super.find(ENTITY_NAME, condition, param, sort, desc, start, rows);
    }

    public Long count(String condition, Object[] params) {
        return super.count(ENTITY_NAME, condition, params);
    }

    public void delete(String id) {
        super.delete(ENTITY_NAME, getUserReplacement(id));
    }
}
