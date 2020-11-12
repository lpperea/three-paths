package lpp.tree.paths.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lpp.tree.paths.business.IPathsBiz;
import lpp.tree.paths.in.TripletesIn;
import lpp.tree.paths.out.TripletesOut;

@Service
public class PathsBizImpl implements IPathsBiz {

	private static Logger logger = LoggerFactory.getLogger(PathsBizImpl.class);
	
	@Override
	public TripletesOut tripletes(TripletesIn dataIn) {

		TripletesOut out = new TripletesOut();
		
		//Obtener datos de los parámetros de entrada
		List<String> entrada = dataIn.getEntrada();
		if(entrada == null ||
				entrada.isEmpty()) {
			out.setError("La entrada está vacía");
			return out;
		}
		
		//Construir la lista de caminos de la entrada
		int total = Integer.valueOf(entrada.get(0));
		List<Camino> caminos = new ArrayList<>();
		try {
			for(int i = 1; i < total; i++) {
				caminos.add(new Camino(entrada.get(i)));
			}
		} catch(Exception e) {
			out.setError("Error al obtener los caminos de entrada " + e);
		}
		
		
		List<String> tripletes = this.getTripletes(total, caminos);
		out.setTotal(tripletes.size());
		out.setTripletes(tripletes);
		return out;
	}
	
	private List<String> getTripletes(final int totalNodos, List<Camino> caminos) {
		
		//Eliminar los que no son visibles
		caminos = caminos.stream().filter(c -> c.visitable).collect(Collectors.toList());
		
		Map<Integer, Set<Integer>> adyacentes = new Hashtable<>();
		
		for(Camino c : caminos) {
			for(int i = 1; i < c.origen; i++) {
				if(adyacentes.get(i) == null) {
					adyacentes.put(i, new HashSet<>());
				}
				adyacentes.get(i).add(c.destino);
			}
			for(int i = c.origen + 1; i <= totalNodos; i++) {
				if(adyacentes.get(c.origen) == null) {
					adyacentes.put(c.origen, new HashSet<>());
				}
				adyacentes.get(c.origen).add(i);
			}
		}
		
		Set<String> tripletes = new HashSet<>();
		for(int i = 1; i<=totalNodos-2; i++) {//No es necesario recorrer a partir del nodo n-2 ya que los tripletes requieren 3 nodos
			Set<Integer> aux = adyacentes.get(i);
			if(aux == null) {
				continue;
			}
			for(int d : aux) {
				if(adyacentes.get(d) != null) {
					for(int k : adyacentes.get(d)) {
						tripletes.add("" + i + d + k);
					}
				}
			}
		}
		logger.info("Total de tripletes obtenidos: " + tripletes.size());
		System.out.println("Tripletes: " + tripletes);
		return new ArrayList<>(tripletes);
	}
}

class Camino{
	int origen, destino;
	boolean visitable;

	public Camino(int origen, int destino) {
		this.origen = origen;
		this.destino = destino;
	}
	
	public Camino(int origen, int destino, boolean visitable) {
		this.origen = origen;
		this.destino = destino;
		this.visitable = visitable;
	}
	
	public Camino(String text) {
		String datos[] = text.split(" ");
		this.origen = Integer.parseInt(datos[0]);
		this.destino = Integer.parseInt(datos[1]);
		this.visitable = "r".equals(datos[2]);
	}
	
	@Override
	public String toString() {
		return "" + this.origen + this.destino;
	}
}