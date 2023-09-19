package entidades;

public class VetProduto {

	private Integer quant;
	private Produto[] produtos;


	public VetProduto() {

	}

	public VetProduto(Integer quant) {
		this.quant = quant;
		produtos = new Produto[quant];
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public Integer getQuant() {
		return quant;
	}

	public Produto getPos(int pos) {
		if (pos >= 0 && pos < produtos.length) {
			return produtos[pos];

		}
		return null;
	}

	public int pCodigo(String codigo) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null && produtos[i].getCodigo().equals(codigo) ) {
				return i;
			}
		}
		return -1;
	}

	
	public int pDescricao(String descricao) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i].getDescricao().equals(descricao)) {
				return i;
			}
		}
		return -1;
	}

	public boolean insercao(String codigo, String descricao, int quantidade, double custo, double venda) {
	    int som;

	    // Verificar se o vetor está vazio
	    boolean vetorVazio = true;
	    for (int i = 0; i < produtos.length; i++) {
	        if (produtos[i] != null) {
	            vetorVazio = false;
	            break; // Se encontrarmos um elemento não nulo, o vetor não está vazio
	        }
	    }

	    for (int i = 0; i < produtos.length; i++) {
	        if (vetorVazio == true) {
	            // Se o vetor estiver vazio, podemos criar o primeiro elemento
	            produtos[0] = new Produto(codigo, descricao, quantidade, custo, venda);
	            return true;
	        } else if (produtos[i] != null && produtos[i].getCodigo() != null && produtos[i].getCodigo().equals(codigo)) {
	            som = produtos[i].getQuantidade();
	            som += quantidade;
	            produtos[i].setDescricao(descricao);
	            produtos[i].setQuantidade(som);
	            produtos[i].setCusto(custo);
	            produtos[i].setVenda(venda);
	            return true;
	        } else if (produtos[i] == null && !codigo.equals("")) {
	            produtos[i] = new Produto(codigo, descricao, quantidade, custo, venda);
	            return true;
	        }
	    }
	    return false;
	}


	public int venda(String codigo, int venda) {
		int rem;
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i].getCodigo().equals(codigo) && venda <= produtos[i].getQuantidade()) {
				rem = produtos[i].getQuantidade();
				rem -= venda;
				produtos[i].setQuantidade(rem);

				return 0;
			} else if (produtos[i].getCodigo().equals(codigo) && venda > produtos[i].getQuantidade()) {
				return -2;
			}

		}

		return -1;
	}

	public int remocao(String codigo) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i].getCodigo().equals(codigo) && produtos[i].getQuantidade() == 0) {

				produtos[i] = null;

				return 0;
			} else if (produtos[i].getCodigo().equals(codigo) && produtos[i].getQuantidade() > 0) {

							return -1;
			}

		}
		return -2;
	}

	public double lucro(int i) {

		return (produtos[i].getVenda() - produtos[i].getCusto());
	}

}
