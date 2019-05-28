package caquita;



public class LogIn extends Usuario{

	public LogIn(String u, String c) {
		super(u, c);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyUser(String u, String c) {
		boolean correcto = false;
		
		if((u==getUser())&&(c==getPass())) {
			correcto=true;
		}
		return  correcto;
	}
}
