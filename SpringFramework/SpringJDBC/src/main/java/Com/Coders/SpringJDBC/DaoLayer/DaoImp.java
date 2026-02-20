package Com.Coders.SpringJDBC.DaoLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import Com.Coders.SpringJDBC.entity.Student;


@Component
public class DaoImp implements Dao {
	
	@Autowired
	JdbcTemplate template;
	
	//RowMapper is functional interface it has maprow method it accepts two parameters(resultset,rownumber) 
	//anonymous class for RowMapper interface
	RowMapper<Student> rm=new RowMapper<Student>() {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Student s=new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAge(rs.getInt(3));
			s.setMarks(rs.getInt(4));
			
			return s;
		}
		
		
	};
	
	//lambda expression RoWMapper Interface
	RowMapper<Student> rm1=(ResultSet rs, int rowNum) ->{
			Student s=new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAge(rs.getInt(3));
			s.setMarks(rs.getInt(4));
			
			return s;
		};
	
	
	
	//BeanPropertyRowMapper class which implements by default RowMapper method just we need to give class file name in consrtuctor
	RowMapper<Student> rm2=new BeanPropertyRowMapper<Student>(Student.class);
	
	@Override
	public void insertData(Student std) {
		
		String sql="insert into student values (?,?,?,?)";
		//update method in template class is usedd for(insert,update,delect) returns int
		int row=template.update(sql,std.getId(),std.getName(),std.getAge(),std.getMarks());    
		
		System.out.println("inserted successfully");
		
		
	}

	
	@Override
	public void updateData(Student std) {
		String sql;
		int row;
		if(std.getName()!=null) {
			sql="update student set name=? where id=?";
			row=template.update(sql,std.getName(),std.getId());
		}else if(std.getAge()!=0) {
			sql="update student set age=? where id=?";
			row=template.update(sql,std.getAge(),std.getId());
		}else {
			sql="update student set marks=? where id=?";
			row=template.update(sql,std.getMarks(),std.getId());
		}
//		System.out.println(
//			    std.getId() + " " +
//			    std.getName() + " " +
//			    std.getAge() + " " +
//			    std.getMarks()
//			);
		System.out.println("updated successfully");
		
	}


	@Override
	public void deleteStd(Student std) {
		
		String sql="delete from student where id=?";
		int row=template.update(sql,std.getId());
		
		System.out.println("deleted successfully");
		
	}


	@Override
	public void selectStd(Student std) {
		String sql="select * from student where id=?";
		//queryForObject method :is used to select single object or row and returns single object
		Student s=template.queryForObject(sql, rm,std.getId()); 
		
		System.out.println(s);
		
		System.out.println("selected student successfully by Id ");
		
	}


	@Override
	public void viewAllStds() {
		System.out.println();
		String sql="select * from student";
		//query method :is used to select all row returns list
		 List<Student> s=template.query(sql, rm);
		 System.out.println("All Students Data:");
//		 System.out.println();
		 System.out.println("id name age marks");
		 s.forEach(std->System.out.println(std.getId()+" "+std.getName()+" "+std.getAge()+" "+std.getMarks()));
		 
		System.out.println();
		
		System.out.println("Viewed all Students data Successfully ");
	}

	

}
