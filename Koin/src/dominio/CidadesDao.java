package dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadesDao {
	
	private static final String sql = "SELECT * FROM CIDADES;";
	private List<Cidade> cidades = null;

	public List<Cidade> recuperarCidades() {

		this.cidades = new ArrayList<>();

		try {

			ResultSet resultSet = Conexao.executarQuery(sql);

			if (resultSet != null) {
				while (resultSet.next()) {

					Double codCidade = resultSet.getDouble("codigo_cidade");
					Double latitude = resultSet.getDouble("latitude");
					Double longitude = resultSet.getDouble("longitude");

					Cidade cidade = new Cidade();
					cidade.setCodigoCidade(codCidade);
					cidade.setLatitude(latitude);
					cidade.setLongitude(longitude);

					cidades.add(cidade);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cidades;

	}

	public Cidade recuperarCidadePorCodigo(Integer codigoCidade) {
		Cidade cidade = new Cidade();
		
		ResultSet resultSet = Conexao.executarQuery(sql);
		
		try {
			if (resultSet != null) {
				while (resultSet.next()) {
					
					Double codCidade = resultSet.getDouble("codigo_cidade");
					Double latitude = resultSet.getDouble("latitude");
					Double longitude = resultSet.getDouble("longitude");
					
					cidade.setCodigoCidade(codCidade);
					cidade.setLatitude(latitude);
					cidade.setLongitude(longitude);
					}
				}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
			
		return cidade;
		
	}

}
