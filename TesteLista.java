public class TesteLista {
	
	public static void main(String[] args) {
		ListaVetor<String> lista = new ListaVetor<>();
		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		lista.add("4");
		lista.add("5");
		lista.add("6");
		lista.add("7");
		
		lista.remove(4);
//		lista.remove(0);
//		lista.remove(0);
		
		System.out.println(lista);
		System.out.println("Valor 5 : "+lista.get(5));
		System.out.println("Valor tamanho : "+lista.size());
	}
}