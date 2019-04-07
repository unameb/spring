package com.example.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class mapper implements RowMapper<Troler>{
   public Troler mapRow(ResultSet rs, int rowNum) throws SQLException {
	   Troler roler = new Troler();
		 roler.setRname(rs.getString("rname")); 
		 roler.setRtime(rs.getString("rtime"));
	   return roler;  
   } 
  
}
