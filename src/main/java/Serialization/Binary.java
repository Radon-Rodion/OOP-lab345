package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import spyAgency.AgentList;

public class Binary implements Serializator {

	@Override
	public void serialize(AgentList agency, String fileAddress) {
		try {
			//������ ����, ���� �����
			File res = new File(fileAddress);
			res.createNewFile();
			
			//������� 2 ������ ��� ������������ ������� � ���������� ��� � ����
		       FileOutputStream outputStream = new FileOutputStream(res);
		       ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

		    // ��������� � ����
		    objectOutputStream.writeObject(agency);
		    
		    //��������� ����� � ����������� �������
		    objectOutputStream.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	@Override
	public AgentList deserialize(String fileAddress) {
		try {
			File fil = new File(fileAddress);
			
			//������� 2 ������ ��� �������������� ������� � ������ ��� �� �����
			FileInputStream fileInputStream = new FileInputStream(fil);
		    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		    AgentList saved = (AgentList) objectInputStream.readObject();
		    
		  //��������� ����� � ����������� �������
		    objectInputStream.close();
		    
		    return saved;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
	}

}
