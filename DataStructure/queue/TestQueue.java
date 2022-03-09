package queue;

public class TestQueue {
	//move index n to the front
	public static <E> E[] moveNthToFront(E[]list,int index){
		LinkedQueue<E> lnkQueue =new LinkedQueue<>();
		for(int i=0;i<index;i++) {
			lnkQueue.enqueue(list[i]);
		}
		list[0]=list[index];
		int i=1;
		while(!lnkQueue.isEmpty()) {
			list[i]=lnkQueue.dequeue();
			i++;
		}
		return list;
		
	}
public static void main(String[] args) {
	System.out.println("CIRCULAR ARRAY QUEUE");
	CircularArrayQueue<Integer> arrQueue=new CircularArrayQueue<>(3);
	arrQueue.enqueue(1);arrQueue.enqueue(3);arrQueue.enqueue(2);
	System.out.println("Queue: "+arrQueue.toString());
	System.out.println("Dequeue: "+arrQueue.dequeue());
	System.out.println("Dequeue: "+arrQueue.dequeue());
	System.out.println("Enqueue: 5");arrQueue.enqueue(5);
	System.out.println("Enqueue: 6");arrQueue.enqueue(6);
	System.out.println("New Queue: "+arrQueue.toString());
	
	System.out.println("\nLINKED QUEUE");
	LinkedQueue<Integer> lnkQueue =new LinkedQueue<>();
	lnkQueue.enqueue(1);lnkQueue.enqueue(3);lnkQueue.enqueue(2);
	System.out.println("Queue: "+lnkQueue.toString());
	
	System.out.println("Dequeue: "+lnkQueue.dequeue());
	System.out.println("New Queue: "+lnkQueue.toString());
	lnkQueue.clear();
	System.out.println("Clear Queue"+lnkQueue.toString());
	System.out.println("Enqueue 1");lnkQueue.enqueue(1);
	System.out.println("Enqueue 3");lnkQueue.enqueue(3);
	System.out.println("Enqueue 2");lnkQueue.enqueue(2);
	System.out.println("Queue"+lnkQueue.toString());
	
	System.out.println("\nMOVE Nth FRONT");
	Integer[] i={1,2,3,4,6,5};
	moveNthToFront(i, 2);
	for(int n=0;n<i.length;n++) {
		System.out.print(i[n]+" | ");
	}
}
}
