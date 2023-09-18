package entidades;

public class Produto {

	private Integer quantidade;
	private Double custo,venda;
	private String descricao, codigo;
	
	public Produto() {
		
	}
	
	public Produto(String codigo,String descricao,Integer quantidade,Double custo,Double venda) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.custo = custo;
		this.venda = venda;						
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public Double getVenda() {
		return venda;
	}

	public void setVenda(Double venda) {
		this.venda = venda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public String toString() {
		return "Codigo: " + codigo + "\nDescrição: " + descricao + "\nPreço: " + venda +" Reais" + "\n" + "Quantidade: " + quantidade;
	}
	
	
}
