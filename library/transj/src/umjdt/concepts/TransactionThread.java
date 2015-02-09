package umjdt.concepts;

import java.util.*;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;
import umjdt.Events.Event;
import umjdt.Events.OperationEvent;
import umjdt.Events.TransactionEvent;

public class TransactionThread implements Runnable{

	private List<Event> events = new ArrayList<Event>();
	// create multimap to store transaction's thread with its operation (values)
	private MultiMap multiMap = new MultiValueMap();
	private Thread thisThread;
	private String threadName;
	
	public TransactionThread(){
	
	}
	public TransactionThread(String _name){
		setThreadName(_name);
	}
	
	public TransactionThread(String _name, Thread t){
		setThreadName(_name);
		setThisThread(new Thread());
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public Timestamp getTimestamp(){
		return new Timestamp();
	}
	public void setEvents(List<Event> events) {
		this.events = events;	
	}
	
	public void addEvent(TransactionEvent event){
		events.add(event);
	}
	public void addEvent(TransactionThread _transactionThread, OperationEvent _operationEvent){
		multiMap.put(_transactionThread, _operationEvent);
	}
	public void removeEvent(TransactionEvent event){
		events.remove(event);
	}
	
	public boolean contains(Event e) {
		return events.contains(e);
	}
	
	@Override
	public void run() {		
	}
	
	public Thread getThisThread() {
		return thisThread;
	}
	
	public void setThisThread(Thread thisThread) {
		this.thisThread = thisThread;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public MultiMap getMultiMap() {
		return multiMap;
	}
	public void setMultiMap(MultiMap multiMap) {
		this.multiMap = multiMap;
	}
}