
public class Multinode<T> {
	protected T data;
	protected int links;
	protected Multinode[] nodes;

	public Multinode(T data, int link) {
		this.data = data;
		links = link;
		nodes = new Multinode[links];
		for (int i = 0; i < links; ++i) {
			nodes[i] = null;
		}
	}

	public void setLink(Multinode<T> _node, int _pos) {
		if (_pos < links) {
			nodes[_pos] = _node;
		}
	}

	public Multinode<T> getLink(int _pos) {
		if (_pos < links) {
			return nodes[_pos];
		}
		return null;
	}

	public T getData() {
		return data;
	}

	public void setData(T _data) {
		data = _data;
	}

	public int getSizeLinks() {
		return links;
	}
}
