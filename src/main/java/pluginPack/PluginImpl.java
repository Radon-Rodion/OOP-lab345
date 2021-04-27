package pluginPack;


import spyAgency.AgentList;

public class PluginImpl implements Plugin {

@Override
public void serialize(byte[] agency, String fileAddress) {
	// TODO Auto-generated method stub
	System.out.println("Test good");
}

@Override
public byte[] deserialize(String fileAddress, Class clas) {
	// TODO Auto-generated method stub
	System.out.println("Test good2");
	return null;
}
}
