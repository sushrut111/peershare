import java.io.*;
import java.util.*;
import java.io.File;

public class FileList{
	public static String getList(){
		
	File folder = new File(".");
	File[] listOfFiles = folder.listFiles();
    String jsonText = "";
    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        // System.out.println("File " + listOfFiles[i].getName());
      	
    	    
        jsonText+="|"+listOfFiles[i].getName();
	      	
      


      } 
    }
    jsonText +="]";
    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isDirectory()) {
        // System.out.println("File " + listOfFiles[i].getName());
      	
    	    
        jsonText+="|"+listOfFiles[i].getName();
	      	
      


      } 
    }

    	// System.out.println(obj);

    	return jsonText;
	}

	public static ArrayList<String> getFileArray(String json){
		ArrayList<String> files = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(json,"]");

		// System.out.println(json);
		
			// while(st.hasMoreTokens()){
			// 	System.out.println(st.nextToken());
			// }
		if(st.countTokens()<1){
			files.add("no files found");
		System.out.println(st.countTokens());

			return files;
		}
		try{
			StringTokenizer stf = new StringTokenizer(st.nextToken(),"|");
			while(stf.hasMoreTokens()){
				files.add(stf.nextToken());
			}
		}
		catch(Exception e){
			//no files may be or something else

		}
		// for(int i=0;i<files.size();i++)
			// System.out.println(files.get(i));
		return files;



	}


	// public static void main(String [] args){
	// 	FileList fl  = new FileList();
	// 	String s = fl.getList();
	// 	// System.out.println(s);
	// 	fl.getFileArray(s);
	// } 
}





