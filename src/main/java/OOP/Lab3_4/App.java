package OOP.Lab3_4;

import spyAgency.*;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBException;

import pluginPack.Plugin;
import javafx.application.Application;
import javafx.stage.Stage;
import pluginPack.PluginFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class App extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
		
		
		
		
		
		
        
        
		
		
		/*AgentList agency;
		Scout sc1 = new Scout(1,null,"12, 18, 17");
		Informator i1 = new Informator(0,sc1);
		agency = AgentList.getInstance();
		agency.addRecord(i1);
		agency.addRecord(sc1);
		
	    (new Serialization.Binary()).serialize(agency,"res333.txt");
	    AgentList saved = (new Serialization.Binary()).deserialize("res333.txt");
	    System.out.println("Bin seralized");
	    for(Iterator<Informator> itr = agency.iterator();itr.hasNext();) {
			Informator cur = itr.next();
		       // сохраняем в файл
		       System.out.println(cur);

		}
	    
	    /*(new Serialization.Xml()).serialize(agency,"res2.txt");
	    AgentList saved2 = (new Serialization.Xml()).deserialize("res2.txt");
	    
	    (new Serialization.Automatic()).serialize(agency,"res3.zip");
	    AgentList saved3 = (new Serialization.Automatic()).deserialize("res3.zip");
	    
	    /*for(Iterator<Informator> itr = saved2.iterator();itr.hasNext();) {
			Informator cur = itr.next();
		       // сохраняем в файл
		       System.out.println(cur);

		}
	    System.out.println("-------------------------------------------------------");
		for(Iterator<Informator> itr = saved2.iterator();itr.hasNext();) {
			Informator cur = itr.next();
		       // сохраняем в файл
		       System.out.println(cur);

		}
		System.out.println("-------------------------------------------------------");
		for(Iterator<Informator> itr = saved3.iterator();itr.hasNext();) {
			Informator cur = itr.next();
		       // сохраняем в файл
		       System.out.println(cur);

		}*/
	       
		
		
		
		
		
		
		
		launch(args);
	}
}
