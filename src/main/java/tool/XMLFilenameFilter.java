package tool;

import java.io.File;
import java.io.FilenameFilter;

public class XMLFilenameFilter implements FilenameFilter {

	private String[] name = new String[1];
	
	public XMLFilenameFilter(){
		
		name[0] = ".xml";
	}
	
	public XMLFilenameFilter(String[] name){
		this.name = name;
	}
	
	public XMLFilenameFilter(String name){
		this.name[0] = name;
	}
	
	public boolean accept(File dir, String name) {		
		if(name != null && name.length() > 0){
			int T = 0;
			
			for(int i=0; i<this.name.length; i++){
              
				if(name.indexOf(this.name[i]) != -1){
					T++;
				}
			}
			return T == this.name.length;
			//return name.endsWith(this.name) || name.indexOf(this.name) != -1;
		}
		else
			return false;
	}
	


}
