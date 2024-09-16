package br.com.lrt.cansados.repository;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lrt.cansados.datasource.JdbcDataSource;

public class GenericRepository implements DaoGeneric<Object> {

	protected JdbcDataSource jds = null;
	protected Connection connection;

	public GenericRepository() {
		jds = JdbcDataSource.createInstance();
	}

	@Override
	public void jdbcConect() {
		connection = jds.begin();
	}

	@Override
	public void jdbcClose() {
		try {
			connection.close();
		} catch (SQLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	@Override
	public Object persiste(Object t) {
		try {
			jdbcConect();
			PreparedStatement ps = connection.prepareStatement("");
			jdbcClose();
			return null;
		} catch (SQLException e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public List<Object> all(Object o) {
		try {
			jdbcConect();
			PreparedStatement ps = connection
					.prepareStatement("select * from " + o.getClass().getSimpleName().toLowerCase());
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			Field[] fields = o.getClass().getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getType().getName());
			}
			List<Object> all = new ArrayList<>();
			int index = 0;
			while (rs.next()) {

			}

			jdbcClose();
			return all;
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}

	}

	@Override
	public Object merge(Object t) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public void remove(Object e) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public Object find(Long id) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

	@Override
	public Object maxId(Object o) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select max(id) as id from " + o.getClass().getSimpleName().toLowerCase());
			ResultSet rs = ps.executeQuery();
			Long id = 0L;
			if (rs.next()) {
				id = rs.getLong(1);
			}

			return id;
		} catch (Exception e) {
			throw new UnsupportedOperationException("Not supported yet."); // Generated from
																			// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

		}
	}

}
