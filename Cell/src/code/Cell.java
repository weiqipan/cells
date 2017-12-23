package code;

public class Cell {
	private final int HEIGHT=15;//��ά��Ϸ����Ĵ�С��HEIGHT*WIDTH ���ַ�  
    private final int WIDTH =60;  
    private char[][] world = new char[HEIGHT][WIDTH];  
    private final char Y ='*'; //���ַ�*����һ��ϸ��  
    private final char No = ' ';  
    /** 
     * ��������ʹ��Ԥ��������ݳ�ʼ��world.  
     */  
    public Cell(){  
        world[3][4] = world[3][5] = world[3][6] =Y;  
        //glider  
        world[10][4] =  world[10][5] =  world[10][6] =  world[11][6] =  world[12][5] = Y;  
    }  
    /** 
     * �ڿ���̨�����world���� 
     */  
    public void print(){  
        for (int height = 0; height < HEIGHT; height++) {  
            for (int width = 0;width < WIDTH; width++) {  
                char c = ( world[height][width] == Y) ?  Y: No ;  
                System.out.print(c);  
            }  
            System.out.println("");  
        }  
        System.out.println("");  
    }     
/** 
 * Helper Method�� 
 * ��ȡָ������(x,y)��col,row��������ϸ��״��ֵ,���Ƿ����ϸ����ע����������߽������ 
 * @���� y y���꣬��row  ���������� 
 * @���� x x���꣬��col  ���������У� 
 * @����ֵ ���������߽���߸���Ϊ�գ�����0�����򷵻�1�� 
 */  
    public int cellState(int y,int x) {  
    	boolean isEmpty = (y < 0 || y >= HEIGHT || x < 0 || x >= WIDTH || world[y][x] != Y ) ;  
    	return isEmpty ?   0 : 1 ;  
    }  
  
  
/** 
 * ��ȡָ������(x,y)��col,row�����ӵ��ھӣ�neighbor���� 
 * @���� y y���꣬��row  ���������� 
 * @���� x x���꣬��col  ���������У� 
 * @����ֵ �ھ���Ŀ. 
 */  
    public int getNeighbors(int y,int x) {  
    	int n = 0; //neighbor  
    	n += cellState( y - 1, x - 1);  
    	n += cellState( y - 1, x);  
    	n += cellState( y - 1, x + 1);  
    	n += cellState( y, x - 1);  
    	n += cellState( y, x + 1);  
    	n += cellState( y + 1, x - 1);  
    	n += cellState( y + 1, x);  
    	n += cellState( y + 1, x + 1);  
    	return n;  
  
  
}  
/** 
 * �������档 
 * ������Ϸ�ĺ������ڵ�ǰworld���ݻ����ϼ������һ����world���ݣ��Ա��ӡ��һ���Ķ�ά���硣 
 * Ϊ�ˣ���ɨ�赱��world��ÿһ�����ӣ��������ھӵ�����������������������ݻ������趨��һ��world�����ݡ� 
 * ��Ϊ�����еĸ��Ӽ�����֮ǰ��world�����ݲ��ñ仯�� 
 * ���ʹ����Ӧ����ʱ��temp���ݴ��ά��������ݡ� 
 * ��calculate() 
 * @return 
 */  
    public  char[][] nextWorld() {  
    	char[][] temp = new char[HEIGHT][WIDTH];  
    	int y=0;//����λ��(x,y)  
    	for (char[] rowArr : world){  
    		int x=0;  
    		for(char colData :rowArr ){  
    			int neighbor = getNeighbors(y, x);//ϰ��(y, x)  
    			if (neighbor==3) {  
    				temp[y][x] = Y;  
    			}
    			else if (neighbor == 2 && colData == Y){  
    				temp[y][x] = Y;  
    			}
    			else{  
    				temp[y][x] = No;   
    			}  
    			x++;  
    		}  
    		y++;  
    	}
    	world = temp; 
    	return world;
}  
	

}
