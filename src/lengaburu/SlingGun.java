package lengaburu;

public class SlingGun implements Batallion{
	@Override
	public String toString() {
		return "SlingGun [name=" + name + ", count=" + count + "]";
	}

	private BatallionType name;
	private int count;

	public SlingGun(BatallionType name, int count) {
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
