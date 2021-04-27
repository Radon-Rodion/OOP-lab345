package Serialization;

import spyAgency.AgentList;

public interface Serializator {

	public void serialize(AgentList agency, String fileAddress);
	
    public AgentList deserialize(String fileAddress);
}
