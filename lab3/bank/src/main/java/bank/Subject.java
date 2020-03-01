package bank;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;


public class Subject  {
  private Collection<IObserver> observerlist = new ArrayList<IObserver>();
  
  public void addObserver(IObserver observer){
	  observerlist.add(observer);
  }
  
  public void donotify(Account account){
	  for (IObserver observer: observerlist){
		  observer.update(account);
	  }
  }
  
}
