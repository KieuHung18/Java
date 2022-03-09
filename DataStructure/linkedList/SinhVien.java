package linkedList;

import java.util.Random;

public class SinhVien {
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

	public String toString() {
		return "Mssv: "+String.valueOf(mssv)+"\tTen: "+ten+"\n";
		
	}
	public static void main(String[] args) {
		SinhVien[] svList=initRandom(10);
		DoublyLinkedList<SinhVien> dllSv=new DoublyLinkedList<>();
		for(int i=0;i<svList.length;i++) {
			dllSv.addLast(svList[i]);
		}
		System.out.println("ADD-REMOVE\n");
		dllSv.Set(1, new SinhVien("newsv1", 123456));
		dllSv.Set(2, new SinhVien("newsv2", 654321));
		System.out.println(dllSv.toString());
		System.out.println("remove: "+removeSinhVien(dllSv, svList[5].getMssv()));
		System.out.println(dllSv.toString());
		
		System.out.println("SORT\n");
		SinhVienComparator svc=new SinhVienComparator();
		dllSv=dllSv.Sort(svc);
		System.out.println(dllSv.toString());;
		
	}
	public static SinhVien removeSinhVien(DoublyLinkedList<SinhVien>svList, int Mssv) {
		for(int i=0;i<svList.size();i++) {
			if(svList.get(i).getMssv()==Mssv) {return svList.removeIndex(i);}
		}
		return null;
	}
	public static SinhVien[] initRandom(int n) {
		Random r =new Random();
		int mssv;
		String name;
		SinhVien[] svList=new SinhVien[n];
		for(int i=0;i<n;i++) {
			mssv=r.nextInt(899999)+100000;
			name="";
			for(int c=0;c<10;c++) {name+=(char)(r.nextInt(25)+97);}
			svList[i]=new SinhVien(name,mssv);
		}
		return svList;
	}
}
