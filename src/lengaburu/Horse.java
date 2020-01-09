package lengaburu;

public class Horse implements Batallion{
	@Override
	public String toString() {
		return "Horse [name=" + name + ", count=" + count + "]";
	}

	private BatallionType name;
	private int count;

	public Horse(BatallionType name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public BatallionType getName() {
		return name;
	}

	public void setName(BatallionType name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
