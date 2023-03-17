public class ListaEncadeada<T> {
	private int tamanho;
	private No inicio;
	private No fim;
	
	public ListaEncadeada(){
		this.tamanho =0;
		this.inicio=null;
		this.fim=null;
	}
	//add no final
	public void add(T valor) {
		No nodo = new No(valor);
		if(this.inicio==null) {
			this.inicio = nodo;
			this.fim = nodo;
		}
		else {
			this.fim.prox = nodo;
			this.fim = nodo;
		}
		this.tamanho++;
	}
	//retorna elemento na Pos
	public T get(int pos) {
		int aux=0;
		No nodoAux= this.inicio;
		while(aux!=pos && nodoAux!=null) {
			aux++;
			nodoAux = nodoAux.prox;
		}
		if(aux!=pos) throw new IllegalArgumentException("posição inválida");
		return nodoAux.info;
	}
	
	//remove na pos
	public T remove(int pos) {
		No ant, atual = this.inicio;
		ant = null;
		int c = 0;
		
		while(atual!= null && c != pos) {
			ant = atual;
			atual = atual.prox;
			c++;
		}
		return remover(ant, atual);
	}
	
	//remove a primeira posicao
	public boolean remove(T elemento) {
		No ant, atual = this.inicio;
		ant =null;	
		while(atual!= null && !atual.info.equals(elemento)) {
			ant = atual;
			atual = atual.prox;
		}
		if(atual==null) return false;
		else {
			remover(ant, atual);
			return true;
		}
	}
	
	private T remover(No ant, No atual) {
		if( ant == null ) this.inicio = atual.prox;
		else ant.prox = atual.prox;
		if(this.fim == atual) this.fim = ant;
		
		T aux = atual.info;
		atual = null;
		return aux;
	}
	
	
	public int size() {
		return this.tamanho;
	}
	
	//classe interna
	private class No  {
		T info;
		No prox;
		No(T informacao){
			this.info = informacao;
			this.prox = null;
		}
	}
}
