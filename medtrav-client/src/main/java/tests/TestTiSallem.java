package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.GreetingsRemote;

public class TestTiSallem {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		GreetingsRemote greetingsRemote = (GreetingsRemote) context
				.lookup("/medtrav-ejb/Greetings!services.interfaces.GreetingsRemote");
		System.out.println(greetingsRemote.tiSallem("Anwar"));
	}

}