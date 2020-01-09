package lengaburu;

public class Elephant implements Batallion{
	private BatallionType name;
	private int count;

	public Elephant(BatallionType name, int count) {
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

	@Override
	public String toString() {
		return "Elephant [name=" + name + ", count=" + count + "]";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
