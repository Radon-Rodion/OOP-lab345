package pluginPack;

import spyAgency.AgentList;

public interface Plugin<T> {

	public void serialize(byte[] agency, String fileAddress);
	
    public byte[] deserialize(String fileAddress, Class<T> clas);
    
}
