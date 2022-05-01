package object;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class DataBase {
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private static final String PATH ="HandWritingDataBase\\";
	//path co dau "\\" o cuoi
	public static final File WEIGHT_1=new File(PATH+"weight_1.bin");
	public static final File WEIGHT_2=new File(PATH+"weight_2.bin");
	private double[][]weight;
	public DataBase() {
		try {
			if(!WEIGHT_1.exists()) {WEIGHT_1.createNewFile();}
			if(!WEIGHT_2.exists()) {WEIGHT_2.createNewFile();}
		 }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double [][] pixel,tkpixel;
	public int[]label,tklabel;
	public void loadData(int numberData) {
		pixel=new double[numberData][28*28];
		label(numberData);
		File file =new File(PATH+"train-images-idx3-ubyte\\train-images.idx3-ubyte");
		try {
			fis =new FileInputStream(file);
			for(int i=0;i<4;i++) {new DataInputStream(fis).readInt();}
			for(int n=0;n<numberData;n++) {
			for(int i=0;i<28*28;i++) {
				pixel[n][i]=(double)fis.read()/255;
			}
			}
			fis.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void label(int numberData) {
		label=new int[numberData];
		File file =new File(PATH+"train-labels-idx1-ubyte\\train-labels.idx1-ubyte");
		try {
			fis =new FileInputStream(file);
			for(int i=0;i<2;i++) {new DataInputStream(fis).readInt();}
			for(int n=0;n<numberData;n++) {
				label[n]=(int)fis.read();
			}
			fis.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadDatatk(int numberData) {
		tkpixel=new double[numberData][28*28];
		labeltk(numberData);
		File file =new File(PATH+"t10k-images-idx3-ubyte\\t10k-images.idx3-ubyte");
		try {
			fis =new FileInputStream(file);
			for(int i=0;i<4;i++) {new DataInputStream(fis).readInt();}
			for(int n=0;n<numberData;n++) {
			for(int i=0;i<28*28;i++) {
				tkpixel[n][i]=(double)fis.read()/255;
			}
			}
			fis.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void labeltk(int numberData) {
		tklabel=new int[numberData];
		File file =new File(PATH+"t10k-labels-idx1-ubyte\\t10k-labels.idx1-ubyte");
		try {
			fis =new FileInputStream(file);
			for(int i=0;i<2;i++) {new DataInputStream(fis).readInt();}
			for(int n=0;n<numberData;n++) {
				tklabel[n]=(int)fis.read();
			}
			fis.close();
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
//	public double[] loadData() {
//		double []result=new double[28*28];
//		File file =new File("E:\\HandWritingDataBase\\train-images-idx3-ubyte\\train-images.idx3-ubyte");
//		try {int temp;
//			fis =new FileInputStream(file);
//			for(int i=0;i<4;i++) {System.out.println(new DataInputStream(fis).readInt());}
//			for(int i=0;i<28*28;i++) {
//				if(i%28==0) {System.out.println();}
//				if((temp=fis.read())==0) {System.out.print(0+" ");}else {System.out.print("* ");}
//				result[i]=(double)temp/255;
//			}
//			
//			fis.close();
//		}  catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
	public double[][] getTkpixel() {
		return tkpixel;
	}
	public int[] getTklabel() {
		return tklabel;
	}
	public void resetData() {
		double [][]weight=new double[10][28*28];
		double []bias=new double[10];
		for(int i=0;i<weight.length;i++) {
			for(int j=0;j<weight[i].length;j++) {
				weight[i][j]=new Random().nextDouble();
			}
		}
		for(int i=0;i<bias.length;i++) {
			bias[i]=0;
		}
		setWeight(weight, WEIGHT_1);
	}
	public void reset() {
		double [][]weight=new double[16][28*28];
		for(int i=0;i<weight.length;i++) {
			for(int j=0;j<weight[i].length;j++) {
				weight[i][j]=new Random().nextDouble()*(new Random().nextInt(3)-1);
			}
		}
		setWeight(weight, WEIGHT_1);
		
		weight=new double[10][16];
		for(int i=0;i<weight.length;i++) {
			for(int j=0;j<weight[i].length;j++) {
				weight[i][j]=new Random().nextDouble()*(new Random().nextInt(3)-1);
			}
		}
		setWeight(weight, WEIGHT_2);
		
	}
	public void setBias(double[] bias,File file) {
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(bias);
			fos.close();oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double[][] getWeight(File file) {
		try {
			fis =new FileInputStream(file);
			ois=new ObjectInputStream(fis);
			weight=(double[][])ois.readObject();
			fis.close();ois.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weight;
	}

	public void setWeight(double[][] weight,File file) {
//		this.weight = weight;
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(weight);
			fos.close();oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public double[][] getPixel() {
		return pixel;
	}
	public int[] getLabel() {
		return label;
	}
	
	

}
