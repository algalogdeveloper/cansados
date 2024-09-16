package br.com.lrt.cansados.repository;

import java.util.List;

import br.com.lrt.cansados.datasource.JdbcDataSource;
import br.com.lrt.cansados.model.Associado;

public class AssociadoRepository {
	
	private final JdbcDataSource dataSource;

	public AssociadoRepository() {
		dataSource = JdbcDataSource.createInstance();
	}

	public boolean save(Associado a) {
		try {
			dataSource.begin();
			dataSource.persiste(a);
			dataSource.end();
			return true;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public List<?> lista() {
		// TODO Auto-generated method stub
		dataSource.begin();
		List<Object> lista = dataSource.createQuery(new Associado());
		dataSource.end();
		return lista;
	}

	public void update(Associado associado) {
		dataSource.begin();
		dataSource.update(associado);
		dataSource.end();
		
	}

}
