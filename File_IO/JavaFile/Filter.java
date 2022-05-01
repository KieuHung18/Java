package JavaFile;

import java.io.File;
import java.io.FileFilter;

public class Filter implements FileFilter{
	private String filter;
	public Filter(String filter) {
		super();
		this.filter = filter;
	}
	@Override
	public boolean accept(File pathname) {
		 String search = pathname.getName();
	        String find = filter;
	        int searchLength = search.length();
	        int findLength = find.length();
	        boolean found = false;
	        for (int i = 0; 
	             i <= (searchLength - findLength);
	             i++) {
	           if (search.regionMatches(i, find, 0, findLength)) {
	              found = true;
	              break;
	           }
	        }
	     return found;
	}

}
