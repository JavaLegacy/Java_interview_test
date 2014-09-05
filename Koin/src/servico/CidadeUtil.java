package servico;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dominio.Cidade;
import dominio.CidadesDao;

/**
 * 
 * @author saulo
 * 
 */
@Path("/")
public class CidadeUtil {

	CidadesDao cidadesDao = null;

	/**
	 * 
	 * @return
	 */
	@Path("/distanciaentrecidades/{codcidade1}/{codcidade2}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CidadeVO calculaDistanciaEntreCidades(
			@PathParam("codcidade1") Integer codcidade1,
			@PathParam("codcidade2") Integer codcidade2) {

		this.cidadesDao = new CidadesDao();
		Cidade cidade1 = this.cidadesDao.recuperarCidadePorCodigo(codcidade1);
		Cidade cidade2 = this.cidadesDao.recuperarCidadePorCodigo(codcidade2);

		CidadeVO cidadeVO = new CidadeVO();
		cidadeVO.setCidade1(cidade1);
		cidadeVO.setCidade2(cidade2);

		cidadeVO.setDistancia(this.calcularDistanciaEntreCidades(cidade1,
				cidade2));

		return cidadeVO;
	}

	public double calcularDistanciaEntreCidades(Cidade cidade1, Cidade cidade2) {

		Double lat1 = cidade1.getLatitude();
		Double lat2 = cidade2.getLatitude();
		Double lon1 = cidade1.getLongitude();
		Double lon2 = cidade2.getLongitude();

		return this.distance(lat1, lon1, lat2, lon2, 'K');

	}

	/**
	 * 
	 * @return
	 */
	@Path("/cidadesproximas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cidade menorDistancia() {

		CidadesDao cidadesDao = new CidadesDao();
		cidadesDao.recuperarCidades();

		Cidade cidade = new Cidade();
		// cidade.setCodigoCidade(1);
		// cidade.setLatitude(123);
		// cidade.setLongitude(456);

		return cidade;
	}

	/**
	 * 
	 * 
	 * 
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @param unit
	 * @return
	 */
	private double distance(double lat1, double lon1, double lat2, double lon2,
			char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	void Dijkstra(Vertex s) {
		for (Vertex v : vertexSet) {
			v.path = null;
			v.dist = INFINITY;
		}
		s.dist = 0;
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		q.insert(s);
		while (!q.isEmpty()) {
			Vertex v = q.extractMin(); // remove vértice com dist mínimo
			for (Edge e : v.adj) {
				Vertex w = e.dest;
				if (v.dist + e.weight < w.dist) {
					w.dist = v.dist + e.weight;
					w.path = v;
					if (w.queueIndex == -1) // w ∉ q (ver a seguir)
						q.insert(w);
					else
						q.decreaseKey(w);
				}
			}
		}
	}

	/**
	 * Este metodo converte graus decimais em radianos
	 * 
	 * @param deg
	 * @return
	 */
	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/**
	 * Este metodo converte radianos para decimal
	 * 
	 * @param rad
	 * @return
	 */
	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
