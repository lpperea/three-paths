package lpp.tree.paths.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lpp.tree.paths.business.IPathsBiz;
import lpp.tree.paths.in.TripletesIn;
import lpp.tree.paths.out.TripletesOut;
import lpp.tree.paths.test.TestService.TestPathsConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {TestService.class, TestPathsConfig.class})
public class TestService {
	
	@Configuration
	@ComponentScan(basePackages = {"lpp.tree.paths"})
	class TestPathsConfig {
		
	}

	@Autowired private IPathsBiz iPathsBiz;

	@Test
	public void test_tripletes() {

		TripletesIn in = new TripletesIn();
		
		in.setEntrada(Arrays.asList("5", "1 2 b", "2 3 r", "3 4 r", "4 5 b"));

		TripletesOut out = this.iPathsBiz.tripletes(in);
		List<String> spected = Arrays.asList("134", "135", "234", "235");
		assertTrue(out.getTotal() == 4 && out.getTripletes().containsAll(spected) && spected.containsAll(out.getTripletes()));
	}
}	