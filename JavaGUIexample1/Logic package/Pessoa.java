package Logic;

public class Pessoa {
	//class properties 
	private String name = "";
	private String sex = "";
	private String address = "";
	private UF objUF = null;
	
	//constructors 
	public Pessoa() {

	}

	public Pessoa(String name, String sex, String address, UF objUF) {
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.objUF = objUF;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UF getObjUF() {
		return objUF;
	}

	public void setObjUF(UF objUF) {
		this.objUF = objUF;
	}
	

	

}
