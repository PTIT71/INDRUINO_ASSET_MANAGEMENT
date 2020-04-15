package MODEL;

public class UserModel {
	private	String name;
	private String pass;
	private String old;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public UserModel(String name, String pass, String old) {
		super();
		this.name = name;
		this.pass = pass;
		this.old = old;
	}
	public UserModel() {
		super();
	}
}
