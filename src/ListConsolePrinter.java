
public class ListConsolePrinter extends ListPrinter{
	public ListConsolePrinter(AbstractList lista) {
		// TODO Auto-generated constructor stub
		super.list=lista;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		Multinode aux=list.root;
		for(int i=0;i<list.size;i++) {
			System.out.println(aux.getData());
			aux=aux.getLink(Links.NEXT);
		}
	}
}
