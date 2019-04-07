package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.beans.Troler;
import com.example.beans.mapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo7ApplicationTests {
	 @Autowired
     JdbcTemplate jdbcTemplate;
	 @Autowired
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	@Test
	public void contextLoads() {
		int count=this.jdbcTemplate.queryForObject("select count(*) from tuser", Integer.class);
	      System.out.println("count=:"+count);
	      int count2=this.jdbcTemplate.queryForObject("select count(*) from tuser where uname=?",new Object[]{"admin"},Integer.class);
	      System.out.println("count2=:"+count2);
	    int count01=this.jdbcTemplate.queryForObject("select count(*) from tuser where uname=?",Integer.class,"admin");
	    System.out.println(count01);
	    String str=this.jdbcTemplate.queryForObject("select uname from tuser where uid=?", String.class,1);
	 System.out.println(str);
	 Troler roler = this.jdbcTemplate.queryForObject(
			 "select rid, rname,rtime from troler where rid = ?",
			 new RowMapper<Troler>(){
			 public Troler mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Troler roler = new Troler();
				 roler.setRname(rs.getString("rname")); 
				 roler.setRtime(rs.getString("rtime"));
			 return roler;
			 }
			 }
			 ,1);
     System.out.println(roler);
     
     Troler roler2 = this.jdbcTemplate.queryForObject(
			 "select rid, rname,rtime from troler where rid = ?",new mapper(),1);
     System.out.println(roler2);
     
     List<Troler> roler1 = this.jdbcTemplate.query(
			 "select rid, rname,rtime from troler",
			 new RowMapper<Troler>(){
			 public Troler mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Troler roler = new Troler();
				 roler.setRname(rs.getString("rname")); 
				 roler.setRtime(rs.getString("rtime"));
			 return roler;
			 }
			 });
     System.out.println(roler1);
     this.jdbcTemplate.update("insert into troler(rid,rname) values(4,'teacher')");
     //this.jdbcTemplate.update("delete from troler where rid=?",4);
     System.out.println("----------------------------------");
	System.out.println(test01("admin"));
	 System.out.println("----------------------------------");
		System.out.println(test02("admin"));
	List<Map<String, Object>> list=this.jdbcTemplate.queryForList("select * from troler");	
	 System.out.println("list:"+list);
	
	}
	
	public int test01(String uname) {
		String sql="select count(*) from tuser where uname= :name";
	  SqlParameterSource psql=new MapSqlParameterSource("name", uname);
	return this.namedParameterJdbcTemplate.queryForObject(sql, psql,Integer.class);
	}
   public int test02(String uname) {
	   String sql="select count(*) from tuser where uname= :name";
	   Map<String, String> psql=Collections.singletonMap("name", uname);
	   return this.namedParameterJdbcTemplate.queryForObject(sql, psql, Integer.class);
   }
  public void insert(int rid,String uname) {
	  this.jdbcTemplate.update("insert into troler(rid,rname) values(?,?)");
  }
}
