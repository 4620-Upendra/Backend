package Com.Coders.SpringDataJPA.repository;

import Com.Coders.SpringDataJPA.entity.Student;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository    //In Spring Framework, @Repository is used to mark a class as a Data Access Layer (DAO) component.   and  It tells Spring:“This class interacts with the database.”  and this @Repository  act @Component to create bean(object) 
                                    //JpaRepoitory<antity class name,Primarykey datatype>
public interface MyStudentRepo extends JpaRepository<Student, Integer> {
	
	//user defined method this can done by mainly three prefixs:findBy,deleteBy,countBy
	//1)findBy
	//returntype findBy(class variable name):by this method sql queries are automaticly generated
	Student findBySid(Integer n);
	
	Student findByName(String n);
	
	List<Student> findByAgeGreaterThan(int a);
	
	//ii)countBy
	int countByAgeGreaterThan(Integer a);
	
	//iii)deleteBy
	void deleteById(Integer a);
	
	@Transactional    //without this anonation we connot perfrom delete operation 
	void deleteByName(String n);
	
	//we can write own query by our own method in two ways by using jsql(java persistance query lanuage),native query
	
	//1)by using jpql(java persistance query lanuage) workss on Class entity
	@Query("select s from Student s")
	List<Student> getAllStudents();
	
	//by this every time we will get only student with id 2
	@Query("select s from Student s where sid=2")
	List<Student> getAllStudentsById();
	
	//dynamicly getting student by id   and variable name in query and in param should me same
	@Query("select s from Student s where sid=:id")
	List<Student> getAllStudentsById(@Param("id") Integer n);
	
	//2) by using Native query lanuage works like normal sql
	@Query(value="select * from student",nativeQuery=true)
	List<Student>printAllStudents();
	
	@Query(value="select * from student where sid=:id",nativeQuery=true)
	List<Student>printAllStudentsById(@Param("id") Integer a);
	
	@Query(value="select * from student where name=:n",nativeQuery=true)
	List<Student>printAllStudentsByName(@Param("n") String st);
}
