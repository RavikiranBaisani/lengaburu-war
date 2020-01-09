package lengaburu;

public class ArmTank implements Batallion{
	@Override
	public String toString() {
		return "ArmTank [name=" + name + ", count=" + count + "]";
	}

	private BatallionType name;
	private int count;

	public ArmTank(BatallionType name, int count) {
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
