package com.capgemini.biblioteca.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.capgemini.biblioteca.model.Copia;

@Repository
public class CopiaRepositoryImpl {
	
	public List<Copia> getCopiasByIsbn(String isbn) {
		List<Copia> copias = new ArrayList<Copia>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "admin");
			Statement sql = con.createStatement();
			
			ResultSet rs = sql.executeQuery("select * from copias\r\n"
					+ "where isbn = '" + isbn + "';");
	
			while(rs.next()) {
				copias.add(new Copia(rs.getLong("id"), rs.getInt("estado")));
			}
			sql.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return copias;
	}
}

