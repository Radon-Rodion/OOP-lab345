package Serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.JOptionPane;

import pluginPack.Plugin;
import pluginPack.PluginFactory;
import spyAgency.AgentList;

public class PluginAdapter implements Serializator {
	
	private Plugin<AgentList> adaptive;
	
	public PluginAdapter(String pluginAddr) {
		adaptive = PluginFactory.getPlugin(pluginAddr);
	}
	
	@Override
	public void serialize(AgentList agency, String fileAddress) {
		try {
			PipedInputStream input = new PipedInputStream();
			PipedOutputStream relocate = new PipedOutputStream(input);
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(relocate);

		    objectOutputStream.writeObject(agency);
		    byte[] binData = new byte[input.available()];
		    input.read(binData,0,input.available());
			
		    objectOutputStream.close();
		    relocate.close();
		    input.close();
		    
		    adaptive.serialize(binData, fileAddress);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	@Override
	public AgentList deserialize(String fileAddress) {
		try {
			byte[] agency = adaptive.deserialize(fileAddress, AgentList.class);
			
			PipedOutputStream writeStream = new PipedOutputStream();
			PipedInputStream relocateStream = new PipedInputStream(writeStream);
			writeStream.write(agency);

			ObjectInputStream objectInputStream = new ObjectInputStream(relocateStream);
			
		    AgentList saved = (AgentList) objectInputStream.readObject();
		    
		  //��������� ����� � ����������� �������
		    objectInputStream.close();
		    relocateStream.close();
		    writeStream.close();
		    
		    return saved;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
	}

}
