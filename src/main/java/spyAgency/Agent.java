package spyAgency;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "agentClass")
@XmlRootElement
public class Agent extends Spy {
	
	private static final long serialVersionUID = 5L;
	String stab;
	
	public Agent() {
		super();
	}
	
	public Agent(int number, Director curator, String subordinatesNums, int authority, String stab) {
		super(number, curator, subordinatesNums, authority);
		this.stab=stab;
	}

	@Override
	public String getStab() {
		return stab;
	}

	@Override
	public void setStab(String stab) {
		this.stab = stab;
	}

	@Override
	public String toString() {
		return super.toString()+";"+stab+"|";
	}
	
}
