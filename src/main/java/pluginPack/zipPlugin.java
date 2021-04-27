package pluginPack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JOptionPane;

public class zipPlugin<T> implements Plugin<T> {

	@Override
	public void serialize(byte[] agency, String fileAddress) {
		try {
			ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(fileAddress));
            ZipEntry entry1=new ZipEntry(fileAddress+".txt");
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = agency;
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
            zout.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	@Override
	public byte[] deserialize(String fileAddress, @SuppressWarnings("rawtypes") Class clas) {
		try {
	    	ZipInputStream zin = new ZipInputStream(new FileInputStream(fileAddress));
            ZipEntry entry;
            String name;
            long size;
            byte[] res = null;
            while((entry=zin.getNextEntry())!=null){
                
                name = entry.getName(); // получим название файла
                size=entry.getSize();  // получим его размер в байтах
                System.out.printf("File name: %s \t File size: %d \n", name, size);
                 
                // распаковка
                res = zin.readAllBytes();
                zin.closeEntry();
            }
            zin.close();
            return res;
            
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}
	}

}
