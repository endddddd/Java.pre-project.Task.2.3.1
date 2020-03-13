package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("From User");
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public void removeUser(long id) {

        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));

    }

    @Override
    public void updateUser(String name, String password, Long id) {

        sessionFactory.getCurrentSession()
                .createQuery("UPDATE User SET name =:pName, password =:pPass WHERE id =:pId")
                .setParameter("pName", name)
                .setParameter("pPass", password)
                .setParameter("pId", id)
                .executeUpdate();
    }

    // нельзя добавить пользователей с одинаковым именем
    @Override
    public boolean isNotReg(String name) {
        return getAllUsers()
                .stream()
                .anyMatch((e) -> e.getName().hashCode() == name.hashCode());
    }

    @Override
    public List<User> getUserById(long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("From User where id =:pId")
                .setParameter("pId", id);
        return query.getResultList();
    }
}
