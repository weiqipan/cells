package code;

public class Main {
	public static void main(String args[]){
		Cell cell=new Cell();
		int i=0;
		cell.print();
		System.out.println("�����ǳ�ʼ����ϸ��ͼ====================");
		while(i<10){
			cell.nextWorld();			
			cell.print();
			System.out.println("========================================");
			i++;
		}
	}

}
