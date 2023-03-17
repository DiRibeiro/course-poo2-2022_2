public class ListaVetor<E> implements Lista<E> {
	private E[] valor;
	private int tamanho;
	private int passo;

	public ListaVetor() {
		this.passo = 10;
		@SuppressWarnings("unchecked")
		E[] e = (E[]) new Object[this.passo];
		this.valor = e;
		this.tamanho = 0;
	}

	public void add(E valor) {
		if (this.cheio()) {
			this.alteraVet();
		}
		this.valor[this.tamanho] = valor;
		this.tamanho++;
	}

	@Override
	public void add(E elemento, int pos) {
		if(pos<0 || pos>this.tamanho)
			throw new IllegalArgumentException(msgPosInv());
		if (this.cheio())
			this.alteraVet();
		for(int i = this.tamanho;i>pos;i--)
			this.valor[i]=this.valor[i-1];
	}

	public E remove(int index) {
		if (index < 0 || index >= this.tamanho)
			throw new IllegalArgumentException(msgPosInv());
		E elemento = this.valor[index];

		for (int i = index; i < this.tamanho; i++) {
			this.valor[i] = this.valor[i + 1];
		}
		this.tamanho--;
		return elemento;
	}
	private String msgPosInv() {
		return "Posição da lista inválida. Deve ser de de 0 até "
				+ (this.tamanho - 1);
	}
	@Override
	public boolean remove(E elemento) {
		if (elemento == null)
			return false;
		for (E item : this.valor)
			if (item.equals(elemento))
				return true;
		return false;
	}

	public int size() {
		return this.tamanho;
	}

	public E get(int index) {
		if (index >= 0 && index < this.tamanho) {
			return this.valor[index];
		}
		if (index < 0)
			return this.valor[0];
		else
			return this.valor[this.tamanho];
	}

	private boolean cheio() {
		return this.tamanho == this.valor.length;
	}

	private void alteraVet() {
		int novoTamanho = this.valor.length + this.passo;
		@SuppressWarnings("unchecked")
		E[] vetNovo = (E[]) new Object[novoTamanho];
		for (int i = 0; i < this.tamanho; i++) {
			vetNovo[i] = this.valor[i];
		}
		this.valor = vetNovo;
	}

	@Override
	public String toString() {
		String retorno = "Tamanho: " + this.tamanho + " - Tamanho físico: " + this.valor.length + " --> [ ";
		for (int i = 0; i < this.tamanho; i++) {
			retorno += this.valor[i] + " ";
		}
		retorno += "]";
		return retorno;
	}
}
