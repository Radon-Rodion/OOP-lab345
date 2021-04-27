package Serialization;

import java.io.IOException;

import javax.swing.JOptionPane;

import pluginPack.PluginFactory;
import spyAgency.AgentList;

public class Automatic implements Serializator {
	
	private Serializator serializator;
	
	private void defineFormat(String fileAddress) throws InvalidFormatException {
		switch(fileAddress.substring(fileAddress.lastIndexOf('.'))) {
		case ".bin":
			serializator = new Binary();
			break;
		case ".xml":
			serializator = new Xml();
			break;
		case ".json":
			serializator = new PluginAdapter("plugins\\jsonPlugin.jar");
			break;
		case ".zip":
			serializator = new PluginAdapter("plugins\\zipPlugin.jar");
			break;
		default:
			throw new InvalidFormatException();
		}
	}
	
	@Override
	public void serialize(AgentList agency, String fileAddress) {
		try {
			defineFormat(fileAddress);
			serializator.serialize(agency,fileAddress);
		} catch(InvalidFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid format: can not open dimension "+fileAddress.substring(fileAddress.lastIndexOf('.'))+"!\n Select serialization type on your own.");
			return;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return;
		}
		
	}

	@Override
	public AgentList deserialize(String fileAddress) {
		try {
			defineFormat(fileAddress);
			AgentList res = serializator.deserialize(fileAddress);
			return res;
		} catch(InvalidFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid format: can not open dimension "+fileAddress.substring(fileAddress.lastIndexOf('.'))+"!\n Select serialization type on your own.");
			return null;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
	}
	
	public class InvalidFormatException extends Exception{}
}
