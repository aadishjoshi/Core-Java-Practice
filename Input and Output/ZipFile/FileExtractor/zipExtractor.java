/**********************************************************************************************************************
* Zip Extractor using java awt
* Written by Aadish Joshi
**********************************************************************************************************************/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.zip.*;

public class zipExtractor extends Frame implements ActionListener{
	
	Frame f1 = new Frame();;
	private List fileList = new List();
	private TextArea fileText = new TextArea();
	private String lastDir = "";
	private String zipname;
	
	/**********************************************************************************************************************
	* zipExtractor constructor function for frame creation and actionListener binding
	**********************************************************************************************************************/
	public zipExtractor()
	{

		f1.setTitle("Zip Extractor");
		f1.setSize(600,500);
		f1.setLayout(new FlowLayout());

		MenuBar menu= new MenuBar();
		
		Menu m = new Menu("File");

		MenuItem m1 = new MenuItem("Open");
		m1.addActionListener(this);
		m.add(m1);
		
		MenuItem m2 = new MenuItem("Exit");
		m2.addActionListener(this);
		m.add(m2);
		
		menu.add(m);
		f1.setMenuBar(menu);
		

		fileList.addActionListener(this);

		f1.add(fileList);
		f1.add(fileText);

		f1.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
        {
                System.exit(0);
             }
        });

		f1.setVisible(true);

	}

	/**********************************************************************************************************************
	* actionPerformed implemented method from ActionListener interface
	**********************************************************************************************************************/
	public void actionPerformed(ActionEvent ae){

		String arg = ae.getActionCommand();

		if(ae.getSource() == fileList){
			loadZipFile(arg);
		}
		else if(arg.equals("Open")){

			FileDialog d = new FileDialog(this, "Open File Zip", FileDialog.LOAD);

			d.setFile("*.zip");
			d.setDirectory(lastDir);
			d.setVisible(true);
			
			String f = d.getFile();
			lastDir = d.getDirectory();
			
			if(f!= null){
				zipname= lastDir +f;
				scanZipFile();
			}
		}else if(arg.equals("Exit")){
			System.exit(0);
		}

	}

	/**********************************************************************************************************************
	* scanZipFile method to read the files inside ZipFolder and setting titles in fileList 
	**********************************************************************************************************************/
	public void scanZipFile(){
		fileList.removeAll();
		try{
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
			ZipEntry entry;

			while((entry = zin.getNextEntry()) != null){
				fileList.add(entry.getName());
				zin.closeEntry();
			}
			zin.close();
		}catch(IOException e){

		}

	}

	/**********************************************************************************************************************
	* loadZipFile method to open particular file data and setting it to text area 
	**********************************************************************************************************************/
	public void loadZipFile(String name){
		try{
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipname));
			ZipEntry entry;

			fileText.setText("");

			while((entry = zin.getNextEntry()) != null){

				if(entry.getName().equals(name)){
					BufferedReader in = new BufferedReader(new InputStreamReader(zin));
					String s;
					while((s = in.readLine()) != null){
						fileText.append(s + "\n");
					}
				}
				zin.closeEntry();
			}

			zin.close();

		}catch(IOException e){}
	}

	/**********************************************************************************************************************
	* psvm to open zipExtractor constructor
	**********************************************************************************************************************/
	public static void main(String args[]){
		new zipExtractor();
	}

}