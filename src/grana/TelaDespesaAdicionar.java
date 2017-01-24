package grana;

import java.util.InputMismatchException;

public class TelaDespesaAdicionar implements Tela {

	private Tela anterior;

	public TelaDespesaAdicionar(Tela anterior) {
		this.anterior = anterior;
	}

	@Override
	public Tela mostra() {
		System.out.println(">>> " + this.getNome() + " <<<");
		System.out.println();

		System.out.print("Digite o nome: ");
		String nome = Grana.getEntrada().next();

		double valor = -1;
		while (valor < 0) {
			System.out.println("Digite o valor: ");

			try {
				valor = Grana.getEntrada().nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Valor incorreto");
				continue;
			}

			if (valor < 0) {
				System.out.println("Valor incorreto");
			}
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
