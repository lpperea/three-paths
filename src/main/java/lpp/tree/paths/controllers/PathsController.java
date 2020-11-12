package lpp.tree.paths.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lpp.tree.paths.business.IPathsBiz;
import lpp.tree.paths.in.TripletesIn;
import lpp.tree.paths.out.TripletesOut;

@RestController
public class PathsController {
	
	@Autowired private IPathsBiz iPathsBiz;
	
	@PostMapping("/tripletes")
	public @ResponseBody TripletesOut tripletes(@RequestBody TripletesIn in) {
		return this.iPathsBiz.tripletes(in);
	}
}