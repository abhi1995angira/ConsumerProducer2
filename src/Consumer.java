public class Consumer extends Thread{
	private Container c;
	Consumer(Container c){
		this.c = c;
	}
	@Override
	public void run(){
		while(true){
			try {
				Thread.sleep((long) (Math.random()*100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.get();
		}
	}
}