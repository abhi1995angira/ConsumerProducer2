public class Producer extends Thread{
	private Container c;
	Producer(Container c){
		this.c = c;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep((long) (Math.random()*300));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.put();
		}
	}
}