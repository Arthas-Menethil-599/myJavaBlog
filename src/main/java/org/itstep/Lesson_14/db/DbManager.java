package org.itstep.Lesson_14.db;

import org.itstep.Lesson_14.entities.User;

import javax.persistence.*;

public class DbManager {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");


    public static final User getUserByEmail(String email) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        User user = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Query query = manager.createQuery("from User u where u.email =: email");
            user = (User) query.setParameter("email", email).getSingleResult();

            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return user;
    }

    public static final boolean addOrUpdateUser(final Operations operations, User user) {
        boolean flag = false;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            if(operations.equals(Operations.CREATE)) {
                manager.persist(user);
            } else {
                manager.merge(user);
            }

            transaction.commit();
            flag = true;
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return flag;
    }

}
