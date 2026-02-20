package Com.Coders.SpringJDBC.DaoLayer;

import Com.Coders.SpringJDBC.entity.Student;

public interface Dao {
	void insertData(Student std);

	void updateData(Student std);

	void deleteStd(Student std);

	void selectStd(Student std);

	void viewAllStds();
}
