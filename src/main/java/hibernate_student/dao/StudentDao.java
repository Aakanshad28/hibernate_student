package hibernate_student.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


import hibernate_student.dto.Student;

public class StudentDao {
	Student student = new Student();

	public EntityManager entityManager() {

//		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("aakansha");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		return entityManager;

		return Persistence.createEntityManagerFactory("aakansha").createEntityManager();
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = entityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();

	}

	public void getAllStudent() {
		EntityManager entityManager = entityManager();

		Query query = entityManager.createQuery("SELECT s FROM Student s");
		List<Student> list = query.getResultList();
		System.out.println(list);
	}

	public void updateStudent(Student updatedStudent) {
		Student student = new Student();
		student.setId(1);
		student.setName("shruti");
		student.setMarks(456);
		student.setPhone(78907890);
		student.setAddress("pune");
		student.setEmail("s2@mail");

		EntityManager entityManager = entityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student dbStudent = entityManager.find(Student.class, student.getId());
		if (dbStudent != null) {
			entityTransaction.begin();
			entityManager.merge(updatedStudent);
			entityTransaction.commit();
		} else {
			System.out.println("Student with given id is not found");
		}

	}

	public void deleteStudent(int id) {
		EntityManager entityManager = entityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student dbStudent = entityManager.find(Student.class, id);
		if (dbStudent != null) {
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		} else {
			System.out.println("Student with given id is not found");
		}

	}

	public void getStudent(long phone) {
		EntityManager entityManager = entityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s  WHERE s.phone=?1");
		query.setParameter(1, phone);
		try {

			Student student = (Student) query.getSingleResult();
			System.out.println(student);

		} catch (Exception e) {
			System.out.println("Student with " + phone + "not found");

		}
	}

	public void getStudent(String email) {
		EntityManager entityManager = entityManager();
		Query query = entityManager.createQuery("SELECT s FROM Student s  WHERE s.email=?1");
		query.setParameter(1, email);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			System.out.println("Student with " + email + "not found");
		}

	}

	public void getStudent() {
		EntityManager entityManager = entityManager();
		Student student = entityManager.find(Student.class, 1);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("student with the given id not found!");

		}

	}

}
