public class Entry{
	public static void main(String s[]){
		Container c = new Container();
		Thread p = new Producer(c);
		Thread cons = new Consumer(c);
		
		p.start();
		cons.start();
		c.pp();
	}
}