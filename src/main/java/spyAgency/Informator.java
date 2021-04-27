package spyAgency;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "informatorClass")
@XmlRootElement
public class Informator implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected int number;
	protected Scout curator;
	
	public Informator() {
		super();
	}
	
	public Informator(int number, Scout curator) {
		super();
		this.number = number;
		this.curator = curator;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Scout getCurator() {
		return curator;
	}

	public void setCurator(Scout curator) {
		this.curator = curator;
	}

	@Override
	public String toString() {
		return ""+number+";{"+curator+"}";
	}
	
	public void setSubordinates(String subordinates) {}
	public void setAuthority(int authority)  {}
	public void setNationality(String nationality) {}
	public void setStab(String stab) {}
	public void setZam(Agent zam) {}
	
	public String getSubordinatesNums() {return null;}
	public int getAuthority() {return 0;}
	public String getNationality() {return null;}
	public String getStab() {return null;}
	public Agent getZam() {return null;}
	
	public static Informator fromString(String[] fields) throws NumberFormatException{
		Informator res = new Informator();
		res.number = Integer.parseInt(fields[0]);
		
		//res.curator = Scout.fromString(); �� ������� �������� ������
		//TODO
		return null;
	}
}
