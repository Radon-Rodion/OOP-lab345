package spyAgency;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "directorClass")
@XmlRootElement
public class Director extends Agent {

	private static final long serialVersionUID = 6L;
	Agent zam;
	
	public Director() {
		super();
	}
	
	public Director(int number, Director curator, String subordinatesNums, int authority, String stab, Agent zam) {
		super(number, curator, subordinatesNums, authority, stab);
		this.zam = zam;
	}

	@Override
	public Agent getZam() {
		return zam;
	}

	@Override
	public void setZam(Agent zam) {
		this.zam = zam;
	}

	@Override
	public String toString() {
		return super.toString()+";{"+zam+"}";
	}
	
}
