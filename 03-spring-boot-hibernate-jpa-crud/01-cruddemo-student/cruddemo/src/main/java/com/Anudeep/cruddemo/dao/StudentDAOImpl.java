package com.Anudeep.cruddemo.dao;

import com.Anudeep.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for Entity Manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {

        entityManager.persist(theStudent); //--> Saves the student
    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastname desc", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastname) {

        // create query

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastname = :theData", Student.class);

        // set query parameters

        theQuery.setParameter("theData", theLastname);

        // return query results

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {

        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numberOfRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numberOfRowsDeleted;
    }


}
