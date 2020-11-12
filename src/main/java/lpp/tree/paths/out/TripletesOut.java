package lpp.tree.paths.out;

import java.io.Serializable;
import java.util.List;

public class TripletesOut implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> tripletes;
	private int total;

	private String error;

	public List<String> getTripletes() {
		return tripletes;
	}

	public void setTripletes(List<String> tripletes) {
		this.tripletes = tripletes;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TripletesOut [");
		if (tripletes != null) {
			builder.append("tripletes=");
			builder.append(tripletes);
			builder.append(", ");
		}
		builder.append("total=");
		builder.append(total);
		builder.append(", ");
		if (error != null) {
			builder.append("error=");
			builder.append(error);
		}
		builder.append("]");
		return builder.toString();
	}
}
