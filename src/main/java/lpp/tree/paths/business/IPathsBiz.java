package lpp.tree.paths.business;

import lpp.tree.paths.in.TripletesIn;
import lpp.tree.paths.out.TripletesOut;

public interface IPathsBiz {

	TripletesOut tripletes(TripletesIn in);
}