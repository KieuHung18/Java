package JavaFile;

import java.io.File;

public class TestFile {
	public static final String PARENT_PATH="C:\\Users\\MioRiy\\Desktop\\Java";
public static void main(String[] args) {
	FileManagement fm=new FileManagement();
	for(File f: fm.find(PARENT_PATH,"org/springframework/ui/ModelMap")) {
			System.out.println(f.getName());
	}
//	fm.dirStat(PARENT_PATH);
}
}
