package com.example.demo.repo;
 import java.util.List;
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.jdbc.core.JdbcTemplate;
 import org.springframework.jdbc.core.RowMapper; 
 import org.springframework.stereotype.Repository; 
 import com.example.demo.dto.DbsPersons; 
 
 @Repository
 public class Personrepo {
	 
@Autowired
JdbcTemplate jdbcTemplate;

RowMapper<DbsPersons> dbRowMapper = (rs, num)->{
	DbsPersons dBSPersons = new DbsPersons();
    dBSPersons.setId(rs.getInt(1));
    dBSPersons.setFirstName(rs.getString(2)); 
    dBSPersons.setLastName(rs.getString(3)); 
    dBSPersons.setCity(rs.getString(4));
    return dBSPersons;
	
};
public List<DbsPersons> fetchAllPersons()
{
	String sqlQuery="select * from tailors";
	List<DbsPersons> res = jdbcTemplate.query(sqlQuery, dbRowMapper);
	return res;

 }
public String addaNewTuple(DbsPersons dp) {
	// TODO Auto-generated method stub
	String newTQuery = "insert into tailors values"+"("+dp.getId()+",'"+dp.getCity()+"','"+dp.getFirstName()+"','"+dp.getLastName()+"')";
	int num=jdbcTemplate.update(newTQuery);
	String res;
	if(num>0) res="Succesfully added";
	else res= " There is Problem";
	return res;	
	
	
}
public String updateTupleName(DbsPersons dp) {
	// TODO Auto-generated method stub
	String updateQuery = "update tailors set firstName=?, lastName=?, city=? where id=?";
	int num=jdbcTemplate.update(updateQuery, dp.getFirstName(), dp.getLastName(),dp.getCity(),dp.getId());
	String res;
	if(num>0) res="Succesfully added";
	else res= " There is Problem";
	return res;	
	
	
}


 }


