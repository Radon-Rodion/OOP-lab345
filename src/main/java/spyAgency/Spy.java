package spyAgency;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "spyClass")
@XmlRootElement
public class Spy extends Scout {

	private static final long serialVersionUID = 3L;
	
	int authority;
	
	public Spy() {
		super();
	}
	
	public Spy(int number, Agent curator, String subordinatesNums, int authority) {
		super(number, curator, subordinatesNums);
		this.authority = authority;
	}

	@Override
	public int getAuthority() {
		return authority;
	}
	
	@Override
	public void setAuthority(int authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return super.toString()+";"+authority;
	}
	
}
