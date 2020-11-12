package lpp.tree.paths.in;

import java.io.Serializable;
import java.util.List;

public class TripletesIn implements Serializable {

	private static final long serialVersionUID = 1L;
	
	List<String> entrada;

	public List<String> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<String> entrada) {
		this.entrada = entrada;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TripletesIn [");
		if (entrada != null) {
			builder.append("entrada=");
			builder.append(entrada);
		}
		builder.append("]");
		return builder.toString();
	}
}
