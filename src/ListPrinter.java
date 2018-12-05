
public abstract class ListPrinter implements Printer{
	public AbstractList list;
	public abstract void print();
	public void setList(AbstractList lista) {
		this.list=lista;
	}

}
