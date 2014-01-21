package com.sam;

import javax.faces.bean.*;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@ManagedBean
@ApplicationScoped
public class UserBean{  
  
    private int count;  
  
    public int getCount() {  
        return count;  
    }  
  
    public void setCount(int count) {  
        this.count = count;  
    }  
      
    public synchronized void increment() {  
        count++;  
          
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();  
        pushContext.push("/counter", String.valueOf(count));  
    }  
}

