package testUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Client;
import service.ServiceActor;

public class client {

	@Test
	public void test() {
		
		Client cl = ServiceActor.getClientById(0);
		
		
	}

}
