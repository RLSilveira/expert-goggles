import java.rmi.Naming;

public class UnoClient {
	public static void main (String[] args) {
		int n;

		if	(args.length != 2)  {
			System.out.println("Uso: java NotasClient <maquina> <nome>");
			System.exit(1);
		}
		try {
			JogadorInterface jogador = (JogadorInterface) Naming.lookup ("//"+args[0]+"/Jogador");
			n = jogador.registraJogador(args[1]);
			System.out.println ("Nome de Usu�rio: "+args[1]);
			if	(n == -1)
				System.out.println ("Erro: Usu�rio j� cadastrado.\n");
			else if (n == -2)
				System.out.println ("Erro: N�mero m�ximo de jogadores j� alcan�ado.");
			else
				System.out.println("Jogador " + args[1] + " cadastrado!");
		} catch (Exception e) {
			System.out.println ("UnoClient failed.");
			e.printStackTrace();
		}
	}
}
