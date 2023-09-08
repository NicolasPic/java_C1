package programa;

import java.util.Scanner;

import entidades.Produto;
import entidades.VetProduto;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		VetProduto estoque;

		System.out.println("Quantos produtos no estoque:");
		int quant = sc.nextInt();
		sc.nextLine();

		estoque = new VetProduto(quant);

		Produto[] prod = estoque.getProdutos();
		
		
		System.out.println("MENU:\n Inserção de produto no estoque: 1\n Venda: 2\n Sair: 3");
		int numero = sc.nextInt();

		while (numero == 1 || numero == 2) {
			switch (numero) {
			case 1:

				System.out.println("Digite os dados do produto:\n");
				sc.nextLine();
				System.out.println("Codigo do produto " + ":");
				String codigo = sc.nextLine();

				System.out.println("Descricao:");
				String descricao = sc.nextLine();

				System.out.println("Quantidade do produto:");
				int quantidade = sc.nextInt();
				sc.nextLine();

				System.out.println("Custo do produto:");
				double custo = sc.nextDouble();
				sc.nextLine();

				System.out.println("Preço de venda do produto:");
				double venda = sc.nextDouble();
				sc.nextLine();
				estoque.insercao(codigo, descricao, quantidade, custo, venda);

				break;

			case 2:

				// vendas
				System.out.println("Quantas vendas: ");
				int n = sc.nextInt();
				sc.nextLine();

				VetProduto vendaCodigo = new VetProduto(n);
				Produto[] venda2 = vendaCodigo.getProdutos();
				
				double lucro = 0;
				System.out.println("Digite o codigo dos produtos que vai vender:");
				for (int i = 0; i < n; i++) {
					String idC = sc.nextLine();
					int pos = estoque.pCodigo(idC);
					if (estoque.pCodigo(idC) != -1) {
						
						venda2[i] = prod[pos];
				        
						lucro += estoque.lucro(i);
					} else {
						System.out.println("Não existe esse codigo");
					}
				}

				System.out.println("DADOS DOS PRODUTOS:");

				for (int i = 0; i < venda2.length; i++) {
					if (venda2[i] != null) {

						System.out.println("Produto #" + (i + 1) + " :\n" + venda2[i]);
					}
				}

				System.out.println("\nLucro total da venda: ");
				System.out.println(lucro + "\n");

				break;
			default:
				System.out.println("Entra do estoque: 1\\n Venda: 2\\n Sair: 3");

			}
			System.out.println("MENU:\n Entra do estoque: 1\n Venda: 2\n Sair: 3");
			numero = sc.nextInt();
		}
		sc.close();

	}

}
