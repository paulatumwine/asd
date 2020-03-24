package counter;

import java.util.ArrayList;
import java.util.Collection;


public class Subject  {
  private Collection<IObserver> observerlist = new ArrayList<IObserver>();
  
  public void addObserver(IObserver observer){
	  observerlist.add(observer);
  }
  
  public void donotify(Integer count){
	  for (IObserver observer: observerlist){
		  observer.update(count);
	  }
  }
  
}
