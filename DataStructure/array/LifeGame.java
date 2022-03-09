package array;

import java.util.Random;

public class LifeGame {
	/* Một ma trận các ô gọi là các tế bào. 
	Mỗi tế bào có 2 trạng thái sống hoặc chết, nó có 8 ô xung quanh (tế bào lân cận). Quá 
	trình tiến hoá áp dụng cho một trạng thái hiện tại. Một tế bào đang sống là sẽ sống ở thế
	hệ kế nếu có 2 hoặc 3 tế bào sống lân cận và chết trong trường hợp khác. Một tế bào đang 
	chết sẽ sống ở thế hệ kế nếu nó có chính xác 3 tế bào sống lân cận, nếu không nó vẫn chết 
	tiếp. Tất cả các tế bào được kiểm chứng cùng một lúc để quyết định trạng thái sống, chết 
	ở thế hệ kế
	*/
	private int[][] map;
	public LifeGame(int width,int height) {
		this.map = new int[width][height];
	}
	public void init() {
		Random random=new Random();
		for(int r=0;r<map.length;r++) {
			for(int c=0;c<map.length;c++) {
				map[r][c]=random.nextInt(2);
			}
		}
	}
	public void startGame(int ntime,long sleepTime) {
		init();
		for(int i=0;i<ntime;i++) {
			visualize(map);
			this.map=padding(map);
			this.map=evolution(map);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void visualize(int[][]map) {
		for(int r=0;r<map.length;r++) {
			for(int c=0;c<map.length;c++) {
				System.out.print(map[r][c]+" | ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public int[][] evolution(int[][]input) {
		int[][]output=new int[input[0].length-2][input[1].length-2];
		for(int r=0;r<output.length;r++) {
			for(int c=0;c<output.length;c++) {
				output[r][c]=convolutionRule(new int[] {input[r+0][c+0],input[r+0][c+1],input[r+0][c+2],
														input[r+1][c+0],input[r+1][c+1],input[r+1][c+2],
														input[r+2][c+0],input[r+2][c+1],input[r+2][c+2], 
														});
			}
		}
		return output;
	}
	public int convolutionRule(int[] input) {
		int result=0;
		if(input[4]==1) {
			input[4]=0;
			for(int i:input) {result+=i;}
			if(result==2||result==3) {return 1;}else{return 0;}
		}
		else {
			for(int i:input) {result+=i;}
			if(result==3) {return 1;}else{return 0;}
		}
	}
	public int[][] padding(int[][] input) {
		int[][]output=new int[input[0].length+2][input[1].length+2];
		for(int r=0;r<input.length;r++) {
			for(int c=0;c<input.length;c++) {
				output[r+1][c+1]=input[r][c];
			}
		}
		return output;
	}
	public int[][] getMap() {
		return map;
	}
	public void setMap(int[][] map) {
		this.map = map;
	}
	public static void main(String[] args) {
		LifeGame lifeGame=new LifeGame(10, 10);
		lifeGame.startGame(10, 1000);
	}
}
