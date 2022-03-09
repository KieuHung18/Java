package array;

import java.util.Random;
import java.util.Scanner;

import iterator.MyIterator;

public class SinhVien {
private String ten,mssv;
private MyArray<Double> diem;
public static final int N_SCORE=3;
public SinhVien(String ten, String mssv) {
	this.ten = ten;
	this.mssv = mssv;
	this.diem= new MyArray<>(N_SCORE);
}

public double avgScore() {
	double result=0;
	MyIterator<Double> score =getDiemIterator();
	while(score.hasNext()) {result+=score.next();}
	return result/N_SCORE;
}

public void printScore() {
	MyIterator<Double> score =getDiemIterator();
	int i=0;
	while(score.hasNext()) {
		i++;
		System.out.println("Diem mon "+i+":"+score.next());
		}
	System.out.println("Diem tb mon: "+avgScore());
}

public void insertScore(int monHocIndex, double score) {
	diem.set(monHocIndex, score);
}
@Override
public String toString() {
	return "Mssv: "+mssv+"\tTen: "+ten
			+"\nDiem: "+diem.toString()
			+"\nDiem Trung Binh: "+(double)((int)((avgScore()*100)))/100;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getMssv() {
	return mssv;
}
public void setMssv(String mssv) {
	this.mssv = mssv;
}
public MyArray<Double> getDiem() {
	return diem;
}

public void setDiem(double[]scores) {
	this.diem= new MyArray<>(N_SCORE);
	for(int i=0;i<scores.length;i++) {
		diem.addLast(scores[i]);
	}
}
public MyIterator<Double> getDiemIterator() {
	return diem.iterator();
}
public static void main(String[] args) {
	SinhVien[] list=initRandom(10);
	printList(list);
//	SinhVien sv1 =new SinhVien("abc", "123");
//	SinhVien sv2 =new SinhVien("abc", "123");
//	System.out.println(sv1.equals(sv2));
	
}
public static void printList(SinhVien[]list) {
	for(int i=0;i<list.length;i++) {
		System.out.println(list[i].toString()+"\n");
	}
}

public static SinhVien[] initRandom(int nStudent) {
	SinhVien[] svList= new SinhVien[nStudent];
	Random r =new Random();
	int mssv;
	String name;
	for(int i=0;i<nStudent;i++) {
		mssv=r.nextInt(899999)+100000;
		name="";
		for(int c=0;c<10;c++) {name+=(char)(r.nextInt(25)+97);}
		svList[i]=new SinhVien(name, String.valueOf(mssv));
		svList[i].setDiem(new double[] {scoreGen(r),
										scoreGen(r),
										scoreGen(r)}
							);
	}
	return svList;
}
public static double scoreGen(Random r) {
	return (double)((int)((r.nextDouble()*10)*100))/100;
}
public static SinhVien insertInfo() {
	System.out.println("Nhap ten,Msss");
	try {
		return new SinhVien(new Scanner(System.in).nextLine(), new Scanner(System.in).nextLine());
		} catch (Exception e) {
		insertInfo();
		System.out.println("Sai Du Lieu");
	}
	return null;
}

public static SinhVien highestScore(SinhVien[]sv) {
	SinhVien result=sv[0];
	
	for(int i=1;i<sv.length;i++) {
		if(sv[i].avgScore()>=result.avgScore()) {result=sv[i];}
	}
	
	System.out.println("Sinh vien co diem cao nhat la: "+result.getTen()+" | Mssv:"+result.getMssv()+" | Diem: "+result.avgScore());
	return result;
}
}
