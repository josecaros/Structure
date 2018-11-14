
public abstract class AbstractList<T> implements AbstractLinkedStructures<T>{
	Multinode root;
	int size;
	@Override
	public abstract void insert(T _data);
	@Override
	public abstract void clear() ;
	@Override
	public abstract void remove(T _data) ;
	
}
