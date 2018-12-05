
public class Main {
	public static void main(String[]args) {
		AbstractList<Integer> lista= new SList<Integer>();
		lista.insert(4);
		lista.insert(3);
		lista.insert(2);
		lista.insert(1);
		
		ListPrinter printer= new ListGraphVizPrinter(lista);
		ListPrinter print=new ListConsolePrinter(lista);
		print.print();
		Writer guardar = new SerializableWriter(lista);
		guardar.write("Lista1");
		Reader leer = new SerializableReader();
		AbstractList nuevo= (AbstractList) leer.reader("Lista1");
		print.setList(nuevo);
		print.print();
		printer.print();
	}
}
