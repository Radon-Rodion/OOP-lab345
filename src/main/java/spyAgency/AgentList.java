package spyAgency;

import java.io.Serializable;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class AgentList implements Iterable<Informator>, Serializable{
	
	private static final long serialVersionUID = -1L;

	private class Record implements Serializable{
		private static final long serialVersionUID = 0L;
		Informator person;
		Record next;
	}
	
	Record first, last;
	int size; private static AgentList instance;
	
	private AgentList(){
		first=new Record();
		last = first;
		size=0;
	}
	
	public static AgentList getInstance() {
		if(instance == null) {
			instance = new AgentList();
		}
		return instance;
	}
	
	public void addRecord(Informator person) {
		for(Informator i: instance) {
			if(i.getNumber()==person.getNumber()) {
				/*removeRecord(person.getNumber());
				size--;*/
				//JOptionPane.showMessageDialog(null, "***!\n(Record already exists!)", "Message",JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		Record newRecord = new Record();
		newRecord.person = person;
		instance.last.next=newRecord;
		instance.last = newRecord;
		instance.size++;
	}
	
	public Informator getRecord(int index) {
		Record cur = instance.first.next;
		for(int i=0;i<instance.size;i++) {
			if(index!=cur.person.getNumber()) {
				cur=cur.next;
			} else break;
		}
		/*System.out.println(size);
		System.out.println(this);*/
		if(cur!=null) return cur.person; else return null;
	}
	
	public void setRecord(int index, Informator person) {
		Record cur = instance.first.next;
		for(int i=0;i<instance.size;i++) {
			if(index!=cur.person.getNumber()) {
				cur=cur.next;
			} else break;
		}
		cur.person = person;
	}
	
	public Informator removeRecord(int index) {
		Record cur = instance.first.next; Record prev = instance.first;
		for(int i=0;i<instance.size;i++) {
			if(index!=cur.person.getNumber()) {
				cur=cur.next;
				prev = prev.next;
			} else break;
		}
		if(instance.size!=0&&cur!=instance.first) {
			prev.next = cur.next;
			if(cur==instance.last) {
				instance.last = prev;
			}
			instance.size--;
		}
		return cur.person;
	}
	
	private class ListIterator implements Iterator<Informator>{
		
		Record cur;
		{
			cur = instance.first;
		}
		public boolean hasNext() {
			return cur.next!=null;
		}

		public Informator next() {
			cur = cur.next;
			return cur.person;
		}
		
	}
	
	public Iterator<Informator> iterator() {
		return new ListIterator();
	}
	
	public void clear() {
		instance.first=new Record();
		instance.last=instance.first;
		instance.size=0;
	}
	
	@Override
	public String toString() {
		String res = "[";
		for(Iterator<Informator> iter = iterator();iter.hasNext();) {
			res+=iter.next().getNumber();
			res+=", ";
		}
		return res+']';
	}
	
	//public static String[] ����� ������ ���� ����� �������� ������
}
