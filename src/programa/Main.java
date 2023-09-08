package programa;

import java.util.Scanner;

import entidades.Produto;
import entidades.VetProduto;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		VetProduto vetProd;
		
		System.out.println("Quantos produtos no estoque:");
		int quant = sc.nextInt();
		sc.nextLine(); 
		
		vetProd = new VetProduto(quant);
		
		Produto[] prod = vetProd.getProdutos();
			
	
		
	System.out.println("MENU:\n Inserção de produto no estoque: 1\n Venda: 2\n Sair: 3");
	int numero = sc.nextInt();
 
	
	while(numero == 1 || numero == 2 ) 
	{
	switch (numero) 
	{
		case 1:
			
			System.out.println("Digite os dados do produto:\n");
			sc.nextLine();
			System.out.println("Codigo do produto " + ":");
			String codigo2 = sc.nextLine();
			
			System.out.println("Descricao:");
			String descricao2 = sc.nextLine();
			
			System.out.println("Quantidade do produto:");
			int quantidade2 = sc.nextInt();
			sc.nextLine();  
			
			System.out.println("Custo do produto:");
			double custo2 = sc.nextDouble();
			sc.nextLine(); 
			
			System.out.println("Preço de venda do produto:");
			double venda2 = sc.nextDouble();
			sc.nextLine(); 
			vetProd.insercao(codigo2, descricao2, quantidade2, custo2, venda2);
		
			
			break;
			
		case 2:
			
		//vendas	
			System.out.println("Quantas vendas: ");
			int n = sc.nextInt();
			sc.nextLine();
		
			String[] vendaCodigo = new String[n];
			double lucro=0;
		
			System.out.println("Digite o codigo dos produtos que vai vender:");
			for(int i = 0; i < n; i++) {
				String idC = sc.nextLine();
				if(vetProd.pCodigo(idC) != -1) {
					vendaCodigo[i] = idC;
					lucro += vetProd.lucro(i);
				}else {
					System.out.println("Não existe esse codigo");
				}
			}
		
			System.out.println("DADOS DOS PRODUTOS:");
		
			for(int i = 0; i < vendaCodigo.length; i++) {
				if(vetProd.pCodigo(vendaCodigo[i]) != -1) {
				
					System.out.println("Produto #" + (i+1) +" :\n" + prod[i]);
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
