
public class Main {
	public static void main(String[]args) {
		AbstractList<Integer> lista= new SList<Integer>();
		lista.insert(4);
		lista.insert(3);
		lista.insert(2);
		lista.insert(1);
		
		Printer print=new ListConsolePrinter(lista);
		print.print();
	}
}
