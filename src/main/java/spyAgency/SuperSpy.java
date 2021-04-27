package spyAgency;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "superSpyClass")
@XmlRootElement
public class SuperSpy extends Spy {
	
	private static final long serialVersionUID = 4L;
	String nationality;
	
	public SuperSpy() {
		super();
	}
	
	public SuperSpy(int number, Director curator, String subordinatesNums, int authority, String nationality) {
		super(number, curator, subordinatesNums, authority);
		this.nationality = nationality;
	}

	@Override
	public String getNationality() {
		return nationality;
	}

	@Override
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return super.toString()+";|"+nationality;
	}
	
	
}
