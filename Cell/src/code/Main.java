package code;

public class Main {
	public static void main(String args[]){
		Cell cell=new Cell();
		int i=0;
		cell.print();
		System.out.println("以上是初始化的细胞图====================");
		while(i<10){
			cell.nextWorld();			
			cell.print();
			System.out.println("========================================");
			i++;
		}
	}

}
