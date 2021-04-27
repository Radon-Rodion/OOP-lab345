package spyAgency;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "scoutClass")
@XmlRootElement
public class Scout extends Informator {
	
	private static final long serialVersionUID = 2L;
	
	String subordinatesNums;
	
	public Scout() {
		super();
	}

	public Scout(int number, Spy curator, String subordinatesNums) {
		super(number, curator);
		this.subordinatesNums = subordinatesNums;
	}
	
	@Override
	public String getSubordinatesNums() {
		return subordinatesNums;
	}
	
	@Override
	public void setSubordinates(String subordinatesNums) {
		this.subordinatesNums = subordinatesNums;
	}

	@Override
	public String toString() {
		return super.toString()+";["+subordinatesNums+"]";
	}
	
}
