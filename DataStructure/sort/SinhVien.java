package sort;

import java.util.Random;

public class SinhVien implements Comparable<SinhVien>{
	private String ten;
	private int mssv;
	public SinhVien(String ten, int mssv) {
		super();
		this.ten = ten;
		this.mssv = mssv;
	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int CompareTo(SinhVien sv2) {
		if(this.mssv>sv2.getMssv()) {
			return 1;
		}
	return 0;
	}
	public String toString() {
		return "Mssv: "+String.valueOf(mssv)+"\tTen: "+ten;
		
	}
	
	public static void main(String[] args) {
		SinhVien[] svList= initRandom(10);
		printList(svList);
		
		System.out.println();
		
		Sort sort=new Sort();
		sort.InterchangeSort(svList);
		printList(svList);
		
	}
	public static SinhVien[] initRandom(int n) {
		Random r =new Random();
		int mssv;
		StringBuffer name;
		SinhVien[] svList=new SinhVien[n];
		for(int i=0;i<n;i++) {
			mssv=r.nextInt(899999)+100000;
			name=new StringBuffer("");
			for(int c=0;c<10;c++) {name.append((char)(r.nextInt(25)+97));}
			svList[i]=new SinhVien(name.toString(),mssv);
		}
		return svList;
		}
	public static void printList(SinhVien[]list) {
		for(SinhVien sv:list) {System.out.println(sv.toString());}
	}
	@Override
	public int compareTo(SinhVien o) {
		if(this.mssv>o.getMssv()) {
			return 1;
		}
		return -1;
	}
}
