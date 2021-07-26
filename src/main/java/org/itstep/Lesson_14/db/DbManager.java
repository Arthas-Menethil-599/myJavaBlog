package org.itstep.Lesson_14.db;

import lombok.extern.java.Log;
import org.itstep.Lesson_14.entities.BaseEntity;
import org.itstep.Lesson_14.entities.Post;
import org.itstep.Lesson_14.entities.User;
import org.itstep.Lesson_14.models.Blog;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Log
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
            if(transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return user;
    }

    public static final boolean addOrUpdate(final Operations operations, final BaseEntity object) {
        boolean flag = false;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            if(operations.equals(Operations.CREATE)) {
                manager.persist(object);
            } else {
                manager.merge(object);
            }

            transaction.commit();
            flag = true;
        } catch (Exception e) {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return flag;
    }

    public static List<Blog> getAllPosts() {
        List<Blog> posts = new ArrayList<>();
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            List<Object[]> results = manager.createQuery("Select p.id, p.title, p.content, u.fullName from Post p inner join User u on p.author = u.id").getResultList();
            for (Object[] row : results) {
                Blog post = new Blog();
                post.setId((Integer) row[0]);
                post.setTitle((String) row[1]);
                post.setContent((String) row[2]);
                post.setFullName((String) row[3]);

                posts.add(post);
            }



            transaction.commit();
        } catch (Exception e) {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return posts;
    }

}
