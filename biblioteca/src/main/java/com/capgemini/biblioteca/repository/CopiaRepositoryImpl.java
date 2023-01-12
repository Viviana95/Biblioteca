package com.capgemini.biblioteca.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.capgemini.biblioteca.model.Copia;

public class CopiaRepositoryImpl {
	@Autowired
	private CopiaRepository jpaRepo;
	
	List<Copia> copias = new ArrayList<Copia>();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegos", "root", "admin");
		Statement sql = con.createStatement();
		
		ResultSet rs = sql.executeQuery("select * from copias\r\n"
				+ "where nombre_jugador = '" + jugador + "';");

//		while(rs.next()) {
//			copias.add(new Copia(rs.getInt("id_partida"), 
//					rs.getString("nombre_jugador"), 
//					rs.getInt("eleccion_jugador"), 
//					rs.getInt("eleccion_ordernador"), 
//					rs.getDate("fecha_hora")));
//		}
		sql.close();
		con.close();
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	return copias;
	
}

