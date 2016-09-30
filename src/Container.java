import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Container{
	int size = 0;
	
	private Lock containerLock = new ReentrantLock();
	private Condition cond = containerLock.newCondition();
	
	public void pp(){
		;
	}
	
	public void get(){
		containerLock.lock();
		try{
			while(size == 0){
				try {
					cond.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			size--;
			System.out.println("----GET---- drinks left: " + size);
			cond.signal();
		}finally{
			containerLock.unlock();
		}
	}
	
	public void put(){
		containerLock.lock();
		try{
			while(size == 10){
				try {
					cond.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			size=3;
			System.out.println("----PUT---- drinks left: " + size);
			cond.signal();
		}finally{
			containerLock.unlock();
		}
	}
}