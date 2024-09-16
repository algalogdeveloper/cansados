package br.com.lrt.cansados.datasource;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.postgresql.ds.PGSimpleDataSource;

import br.com.lrt.cansados.model.Associado;

public class JdbcDataSource {
	private static JdbcDataSource source;
	private static Connection connection;

	public synchronized final Connection begin() {
		try {
			PGSimpleDataSource pg = new PGSimpleDataSource();
			pg.setUrl("jdbc:postgresql://localhost:5432/cansadosdb");
			pg.setUser("postgres");
			pg.setPassword("root");
			System.out.println("conectando ...");
			return connection = pg.getConnection();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void update(Object o) {
		try {
			String sql = "update " + o.getClass().getSimpleName().toLowerCase() + " set ";
			String data = "";
			Field[] t = o.getClass().getDeclaredFields();
			for (Field f : t) {

				data += f.getName() + "=?,";
			}
			if (o instanceof Associado) {
				Associado a = (Associado) o;
				String sql_final = sql + data.substring(0, data.length() - 1) + " where " + t[0].getName() + "=?";
				PreparedStatement ps = connection.prepareStatement(sql_final);
				ps.setObject(1, a.getId());
				ps.setObject(2, a.getNome());
				ps.setObject(3, a.getDtMatricula());
				ps.setObject(4, a.getType());
				ps.setObject(5, a.getId());
				System.out.println(ps.toString());
				ps.execute();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void persiste(Object object) {
		try {
			String values = "";
			String data = "";
			Field[] t = object.getClass().getDeclaredFields();
			for (Field f : t) {
				values += "?,";
				data += f.getName() + ",";
			}
			PreparedStatement ps = null;
			String sql = "insert into " + object.getClass().getSimpleName().toLowerCase() + "("
					+ data.substring(0, data.length() - 1) + ")values(" + values.substring(0, values.length() - 1)
					+ ")";
			if (object instanceof Associado) {
				Associado a = (Associado) object;
				ps = connection.prepareStatement(sql);
				ps.setObject(1, auto(object.getClass()) + 1);
				ps.setObject(2, a.getNome());
				ps.setObject(3, a.getDtMatricula());
				ps.setObject(4, a.getType());
			}
			System.out.println(ps.toString());
			ps.execute();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	private int auto(Class<? extends Object> class1) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select max(id) as id from " + class1.getSimpleName().toLowerCase());
			System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("id");
			return id;
		} catch (Exception e) {
			return 0;
		}

	}

	public List<Object> createQuery(Object a) {
		try {
			String query = "select * from " + a.getClass().getSimpleName().toLowerCase() + " o order by "+a.getClass().getDeclaredFields()[0].getName();
			System.out.println(query);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Object> lista = new ArrayList<Object>();
			System.out.println(ps.toString());
			if (a instanceof Associado) {
				while (rs.next()) {
					Associado associado = new Associado();
					associado.setId(rs.getLong(1));
					associado.setNome(rs.getString(2));
					associado.setDtMatricula(rs.getDate(3).toLocalDate());
					associado.setType(rs.getString(4));
					a = associado;
					lista.add(a);
				}

			}

			return lista;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public void end() {
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static JdbcDataSource createInstance() {
		return Objects.isNull(source) ? new JdbcDataSource() : source;
	}
}
