package generic;

import java.util.Random;


public class RaditionalMatrix {
	private RaditionalNumber[][] matrix;
	public RaditionalMatrix(int rows,int cols) {
		this.matrix = new RaditionalNumber[rows][cols];
	}
	public RaditionalMatrix mutiplyMatrix(RaditionalMatrix second) {
		if(getWidth()!=second.getHeight()) {
			throw new IncorrectDimention("matrix 1 cols not match with matrix 2 rows");
		}
		RaditionalMatrix output =new RaditionalMatrix(getHeight(), second.getWidth());
		RaditionalMatrix tranPosSec = second.transposition(second);
		for(int r=0;r<output.getHeight();r++) {
			for(int c=0;c<output.getWidth();c++) {
				output.getMatrix()[r][c]=multiplyRowVector(matrix[r], tranPosSec.getMatrix()[c]);
			}
		}
		return output;
	}
	public RaditionalMatrix transposition(RaditionalMatrix input) {
		RaditionalMatrix output=new RaditionalMatrix(input.getWidth(), input.getHeight());
		for(int r=0;r<output.getHeight();r++) {
			for(int c=0;c<output.getWidth();c++) {
				output.getMatrix()[r][c]=input.getMatrix()[c][r];
			}
		}
		return output;
	}
	public RaditionalNumber multiplyRowVector(RaditionalNumber[] first,RaditionalNumber[] second) {
		RaditionalNumber output = first[0].multiply(second[0]);
		for(int i=1;i<first.length;i++) {
			output=output.add(first[0].multiply(second[0]));
		}
		return output;
	}
	public RaditionalMatrix addMatrix(RaditionalMatrix second) {
		if(getWidth()!=second.getWidth()||getHeight()!=second.getHeight()) {
			throw new IncorrectDimention("matrix 1 demention not match with matrix 2 dimention");
		}
		RaditionalMatrix output =new RaditionalMatrix(getHeight(), getWidth());
		for(int r=0;r<output.getHeight();r++) {
			for(int c=0;c<output.getWidth();c++) {
				output.getMatrix()[r][c]=matrix[r][c].add(second.getMatrix()[r][c]);
			}
		}
		return output;
	}
	public void initRandom(int min,int max) {
		Random random=new Random();
		for(int r=0;r<getHeight();r++) {
			for(int c=0;c<getWidth();c++) {
				matrix[r][c]=new RaditionalNumber(random.nextInt(max-min+1)+min, random.nextInt(max-min+1)+min);
			}
		}
	}
	public RaditionalNumber[][] getMatrix() {
		return matrix;
	}
	public int getWidth() {
		return this.matrix[0].length;
	}
	public int getHeight() {
		return this.matrix.length;
	}
	public void visualize() {
		for(int r=0;r<getHeight();r++) {
			for(int c=0;c<getWidth();c++) {
				System.out.print(matrix[r][c]+" | ");
			}
			System.out.println();
		}System.out.println();
	}
	public void setMatrix(RaditionalNumber[][] matrix) {
		this.matrix = matrix;
	}
	public static void main(String[] args) {
		RaditionalMatrix m=new RaditionalMatrix(5, 10);
		m.initRandom(5, 10);
		m.visualize();
		RaditionalMatrix m2=new RaditionalMatrix(10, 5);
		m2.initRandom(5, 10);
		m2.visualize();
		m2.transposition(m2).visualize();
		m.mutiplyMatrix(m2).visualize();
	}
}

