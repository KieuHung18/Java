package linkedList;

import java.util.Comparator;

public class SinhVienComparator implements Comparator<SinhVien>{
	@Override
	public int compare(SinhVien o1, SinhVien o2) {
		if(o1.getMssv()>o2.getMssv()) {
			return 1;
		}
		return -1;
	}
	
}
