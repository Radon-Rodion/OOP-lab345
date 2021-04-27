package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import spyAgency.AgentList;
import spyAgency.Informator;

public class Xml implements Serializator {

	@Override
	public void serialize(AgentList agency, String fileAddress) {
		try {
			//������ ����, ���� �����
			File res = new File(fileAddress);
			res.createNewFile();
			
			//������� ����� ��� ���������� ������� � ����
			FileOutputStream outputStream = new FileOutputStream(res);
			
			//писать результат сериализации будем в Writer(StringWriter)
			 StringWriter writer = new StringWriter();
			 
			JAXBContext context = JAXBContext.newInstance(Informator.class);
			 Marshaller marshaller = context.createMarshaller();
			 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			 
			// сама сериализация
			 for(Iterator<Informator> itr = agency.iterator();itr.hasNext();) {
				marshaller.marshal(itr.next(), outputStream);
			}
			
			 outputStream.flush();
			 
			outputStream.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	@Override
	public AgentList deserialize(String fileAddress) {
		try {
			File fil = new File(fileAddress);
			//������� ����� ��� ������ ������� �� �����
			FileInputStream inputStream = new FileInputStream(fil);
			String[] objects = new String(inputStream.readAllBytes()).split("<\\?xml version=\"1\\.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>");
			
			for(String s: objects) {
				System.out.println(s);
			}
			
			 JAXBContext context = JAXBContext.newInstance(Informator.class);
			 Unmarshaller unmarshaller = context.createUnmarshaller();
			 
			AgentList saved = AgentList.getInstance();
			try {
				for(int i=1;i<objects.length;i++) {
					StringReader reader = new StringReader(objects[i]);
					Informator informator = (Informator) unmarshaller.unmarshal(reader);
					saved.addRecord(informator);
				}
			}catch (ArrayIndexOutOfBoundsException e){
				// e.printStackTrace();
			}
			//����������� �������
			inputStream.close();
		    System.out.println("Deser finished!");
		    return saved;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
	}

}
