
public class SList<T> extends AbstractList<T> {
	public SList() {
		this.root = null;
		this.size = 0;
		System.out.println("Constructor SList");
	}

	@Override
	public void insert(T _data) {
		// TODO Auto-generated method stub
		if (this.root == null) {
			this.root = new Multinode<T>(_data, 1);
		} else {
			Multinode aux = this.root;
			while (aux.getLink(Links.NEXT) != null) {
				aux = aux.getLink(Links.NEXT);
			}
			aux.setLink(new Multinode<T>(_data, 1), Links.NEXT);
		}
		this.size++;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root=null;
	}

	@Override
	public void remove(T _data) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		} else if (this.root.getData() == _data) {
			Multinode<T> aux = this.root;
			this.root = this.root.getLink(Links.NEXT);
		} else {
			Multinode<T> aux = this.root;
			while (aux.getLink(Links.NEXT) != null) {
				if (aux.getLink(Links.NEXT).getData() == _data) {
					Multinode<T> del = aux.getLink(Links.NEXT);
					if (aux.getLink(Links.NEXT).getLink(Links.NEXT) == null) {
						aux.setLink(null, Links.NEXT);
						return;
					}
					aux.setLink(aux.getLink(Links.NEXT).getLink(Links.NEXT), Links.NEXT);
					return;
				}
				aux = aux.getLink(Links.NEXT);
			}
		}
		this.size--;
	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "SList";
	}

}
