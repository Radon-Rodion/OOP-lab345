package OOP.Lab3_4;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;

import Serialization.Serializator;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import pluginPack.Plugin;
import pluginPack.PluginFactory;
import spyAgency.Agent;
import spyAgency.AgentList;
import spyAgency.Director;
import spyAgency.Informator;
import spyAgency.Scout;
import spyAgency.Spy;
import spyAgency.SuperSpy;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField num;

    @FXML
    private TextField cur;

    @FXML
    private TextField sub;

    @FXML
    private TextField aut;

    @FXML
    private TextField nat;

    @FXML
    private TextField stab;

    @FXML
    private TextField zam;
    
    @FXML
    private ComboBox<Integer> agency;
    

    @FXML
    private RadioButton RBbin;

    @FXML
    private RadioButton RBxml;

    @FXML
    private RadioButton RBplug;
    
    @FXML
    private RadioButton RBAuto;
    
    @FXML
    private RadioButton RBinf;

    @FXML
    private RadioButton RBsc;

    @FXML
    private RadioButton RBsp;

    @FXML
    private RadioButton RBssp;

    @FXML
    private RadioButton RBage;

    @FXML
    private RadioButton RBdir;
    
    
    @FXML
    private Button stats;

    @FXML
    private Button add;

    @FXML
    private Button remove;
    
    @FXML
    private Button ser;

    @FXML
    private Button deser;

    @FXML
    private TextField adr;
    
    @FXML
    private Button findPlug;

    @FXML
    private Button findAdr;

    @FXML
    private TextField plug;
    
    @FXML
    void initialize() {
        assert num != null : "fx:id=\"num\" was not injected: check your FXML file 'Sample.fxml'.";
        assert cur != null : "fx:id=\"cur\" was not injected: check your FXML file 'Sample.fxml'.";
        assert sub != null : "fx:id=\"sub\" was not injected: check your FXML file 'Sample.fxml'.";
        assert aut != null : "fx:id=\"aut\" was not injected: check your FXML file 'Sample.fxml'.";
        assert nat != null : "fx:id=\"nat\" was not injected: check your FXML file 'Sample.fxml'.";
        assert stab != null : "fx:id=\"stab\" was not injected: check your FXML file 'Sample.fxml'.";
        assert zam != null : "fx:id=\"zam\" was not injected: check your FXML file 'Sample.fxml'.";
        assert stats != null : "fx:id=\"stats\" was not injected: check your FXML file 'Sample.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'Sample.fxml'.";
        assert remove != null : "fx:id=\"remove\" was not injected: check your FXML file 'Sample.fxml'.";
        assert ser != null : "fx:id=\"ser\" was not injected: check your FXML file 'Sample.fxml'.";
        assert deser != null : "fx:id=\"deser\" was not injected: check your FXML file 'Sample.fxml'.";
        assert adr != null : "fx:id=\"adr\" was not injected: check your FXML file 'Sample.fxml'.";
        
        assert RBinf != null : "fx:id=\"RBinf\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBsc != null : "fx:id=\"RBsc\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBsp != null : "fx:id=\"RBsp\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBssp != null : "fx:id=\"RBssp\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBage != null : "fx:id=\"RBage\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBdir != null : "fx:id=\"RBdir\" was not injected: check your FXML file 'Sample.fxml'.";
        
        assert RBbin != null : "fx:id=\"RBbin\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBxml != null : "fx:id=\"RBxml\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBplug != null : "fx:id=\"RBtex\" was not injected: check your FXML file 'Sample.fxml'.";
        assert RBAuto != null : "fx:id=\"RBAuto\" was not injected: check your FXML file 'Sample.fxml'.";
        
        assert findPlug != null : "fx:id=\"findPlug\" was not injected: check your FXML file 'Sample.fxml'.";
        assert findAdr != null : "fx:id=\"findAdr\" was not injected: check your FXML file 'Sample.fxml'.";
        assert plug != null : "fx:id=\"plug\" was not injected: check your FXML file 'Sample.fxml'.";
        
        ToggleGroup classes = new ToggleGroup();
        RBinf.setToggleGroup(classes);
        RBsc.setToggleGroup(classes);
        RBsp.setToggleGroup(classes);
        RBssp.setToggleGroup(classes);
        RBage.setToggleGroup(classes);
        RBdir.setToggleGroup(classes);
        
        ToggleGroup serial = new ToggleGroup();
        RBbin.setToggleGroup(serial);
        RBxml.setToggleGroup(serial);
        RBplug.setToggleGroup(serial);
        RBAuto.setToggleGroup(serial);
        
        final FileChooser fileChooser = new FileChooser();
        
        findAdr.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				adr.clear();
			    File file = fileChooser.showOpenDialog(null);
			    if (file != null) {
			    	adr.setText(file.getAbsolutePath());
			    }
			}
		});
        
        findPlug.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				plug.clear();
			    File file = fileChooser.showOpenDialog(null);
			    if (file != null) {
			    	plug.setText(file.getAbsolutePath());
			    }
			}
		});
        
        stats.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stats();
			}
		});
        add.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				addEdit();
			}
		});
        remove.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				remove();
			}
		});
        ser.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				(new SerialProxy()).serial(adr.getText());
			}
		});
        deser.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				(new SerialProxy()).deserial(adr.getText());
			}
		});
    }
    private void stats() {
    	Informator i = findInfo();
    	num.setText(Integer.toString(i.getNumber()));
    	if(i.getCurator()!=null) cur.setText(Integer.toString(i.getCurator().getNumber())); else cur.setText("");
    	sub.setText(i.getSubordinatesNums());
    	aut.setText(Integer.toString(i.getAuthority()));
    	nat.setText(i.getNationality());
    	stab.setText(i.getStab());
    	if(i.getZam()!=null) zam.setText(Integer.toString(i.getZam().getNumber())); else zam.setText("");
    }
    
    private void addEdit() {
    	Informator i = createInformator();
    	try {
    		i.setNumber(Integer.parseInt(num.getText()));
        	if(cur.getLength()!=0) i.setCurator((Scout)AgentList.getInstance().getRecord(Integer.parseInt(cur.getText())));
        	if(sub.getLength()!=0) i.setSubordinates(sub.getText());
        	if(aut.getLength()!=0) i.setAuthority(Integer.parseInt(aut.getText()));
        	if(nat.getLength()!=0) i.setNationality(nat.getText());
        	if(stab.getLength()!=0) i.setStab(stab.getText());
        	if(zam.getLength()!=0) i.setZam((Agent)AgentList.getInstance().getRecord(Integer.parseInt(zam.getText())));
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "You've entered invalid parameters!", "Message",JOptionPane.ERROR_MESSAGE);
    	}
    	
    	//TODO
    	if(AgentList.getInstance().getRecord(i.getNumber())==null) {
    		AgentList.getInstance().addRecord(i);
    	} else {
    		AgentList.getInstance().setRecord(i.getNumber(), i);
    	}
    	
    	updateList();

    }
    
    private void remove() {
    	int selectedNum = agency.getValue();
    	Informator i = AgentList.getInstance().removeRecord(selectedNum);
    	
    	num.setText(Integer.toString(i.getNumber()));
    	if(i.getCurator()!=null) cur.setText(Integer.toString(i.getCurator().getNumber()));
    	sub.setText(i.getSubordinatesNums());
    	aut.setText(Integer.toString(i.getAuthority()));
    	nat.setText(i.getNationality());
    	stab.setText(i.getStab());
    	if(i.getZam()!=null) zam.setText(Integer.toString(i.getZam().getNumber()));
    	
    	updateList();
    }
    
    
    private Informator createInformator() {
    	if(RBinf.isSelected()) {
    		return new Informator();
    	}
    	if(RBsc.isSelected()) {
    		return new Scout();
    	}
    	if(RBsp.isSelected()) {
    		return new Spy();
    	}
    	if(RBssp.isSelected()) {
    		return new SuperSpy();
    	}
    	if(RBage.isSelected()) {
    		return new Agent();
    	} else {
    		return new Director();
    	}
    }
    
    private Informator findInfo() {
    	int selectedNum = agency.getValue();
    	return AgentList.getInstance().getRecord(selectedNum);
    }
    
    private void updateList() {
    	ObservableList<Integer> ls = agency.getItems();
    	ls.clear();
		for(Informator i: AgentList.getInstance()) {
			ls.add(i.getNumber());
			//System.out.println(i);
			//agency.setValue(i.getNumber());
		}
		//System.out.println("for finished!");
		agency.setItems(ls);
    }
    
    private class SerialProxy {
    	Serializator serial; AgentList list;
    	public SerialProxy() {
    		if(RBbin.isSelected()) {
    			serial = new Serialization.Binary();
    		}
    		if(RBxml.isSelected()) {
    			serial = new Serialization.Xml();
    		}
    		if(RBplug.isSelected()) {
    			serial = new Serialization.PluginAdapter(plug.getText());
    		}
    		if(RBAuto.isSelected()) {
    			serial = new Serialization.Automatic();
    		}
    		
    		list = AgentList.getInstance();
    	}
    	public void serial(String address) {
        	try {
        		serial.serialize(list, address);
        		
        	} catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e.getMessage(), "Message",JOptionPane.ERROR_MESSAGE);
        	}
        }
        public void deserial(String address) {
        	try {
        		list = serial.deserialize(address);
        		//System.out.println("Deser 2 fifnished");
        		for(Informator i: list) {
        			AgentList.getInstance().addRecord(i);
        			//System.out.println(i);
        			//agency.setValue(i.getNumber());
        		}
        		updateList();
        	} catch(Exception e) {
        		JOptionPane.showMessageDialog(null, e.getMessage(), "Message",JOptionPane.ERROR_MESSAGE);
        		
        	}
        }
    }
}
