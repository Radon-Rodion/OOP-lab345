package pluginPack;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import spyAgency.AgentList;

public class jsonPlugin<T> implements Plugin<T> {

	public void serialize(byte[] agency, String address) {
		try {
			PipedOutputStream writeStream = new PipedOutputStream();
			PipedInputStream relocateStream = new PipedInputStream(writeStream);
			writeStream.write(agency);
			
			ObjectInputStream objectInputStream = new ObjectInputStream(relocateStream);
			
		    T saved = (T) objectInputStream.readObject();
		    
		  //��������� ����� � ����������� �������
		    objectInputStream.close();
		    relocateStream.close();
		    writeStream.close();
		    
			//������ ����, ���� �����
			File res = new File(address);
			res.createNewFile();
			
			//������� ����� ��� ���������� ������� � ����
			FileWriter writer = new FileWriter(res);
			  // конвертируем наш JAVA объект в JSON
		     Gson gson = new Gson();
		 
		     String json = gson.toJson(saved);
		     // и выводим результат
		     System.out.println(json);
		     writer.write(json);
		     
			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public byte[] deserialize(String address, Class<T> clas) {
		try {
			
			File fil = new File(address);
			Gson gson = new Gson();
			 //������� ����� ��� ������ ������� �� �����
			FileInputStream inputStream = new FileInputStream(fil);
			
			// конвертируем из JSON обратно в JAVA объект
		     T saved = null;
		     
		     saved = gson.fromJson(new String(inputStream.readAllBytes()), clas);
		     
			inputStream.close();
		    
			PipedInputStream input = new PipedInputStream();
			PipedOutputStream relocate = new PipedOutputStream(input);
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(relocate);

		    objectOutputStream.writeObject(saved);
		    byte[] binData = new byte[input.available()];
		    input.read(binData,0,input.available());
			
		    objectOutputStream.close();
		    relocate.close();
		    input.close();
		    
		    return binData;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
	}
	
}
