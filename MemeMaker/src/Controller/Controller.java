package Controller;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;

import View.GUI;
public class Controller implements ActionListener {
private GUI MemeView ;
private ArrayList<String>FavoriteMemePath;

public Controller() {
MemeView = new GUI(this);	
MemeView.getSave().addActionListener(this);
MemeView.getFeaturedMemes().addActionListener(this);
MemeView.getSelectImage().addActionListener(this);
MemeView.getDraw().addActionListener(this);
MemeView.getFavorite().addActionListener(this);
MemeView.getShareIt().addActionListener(this);
MemeView.getSelectImage().addActionListener(this);
MemeView.getFavoriteMemes().addActionListener(this);
MemeView.getFeaturedMemes().addActionListener(this);
FavoriteMemePath = new ArrayList<String>();
}
public static void main(String[]args) {
new Controller();
}
@Override
/* get the path of the Meme which is selected*/
public void actionPerformed(ActionEvent e) {
String path = "";
if(MemeView.getSelectImage() == e.getSource()) {
JFileChooser JFOpen = new JFileChooser("");
FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif","png",
		"jpeg");
int Bool = JFOpen.showOpenDialog(MemeView);
if(Bool == JFileChooser.APPROVE_OPTION) {
	File f = JFOpen.getSelectedFile();
	path = f.getPath();
	try 
	{
	BufferedImage img = ImageIO.read(new File(path));
	Image dimg = img.getScaledInstance(MemeView.getMemePanel().getWidth(),
			MemeView.getMemePanel().getHeight(),
			Image.SCALE_SMOOTH);	
	MemeView.getMemePanel().setIcon(new ImageIcon(dimg));
	MemeView.setCurrentPath(path);
	}
	catch(Exception ImageException) 
	{
		ImageException.printStackTrace();	
	}
}
}
else {
if(MemeView.getSave() == e.getSource()) {
JFileChooser JFSave = new JFileChooser("Save As");
int i = JFSave.showSaveDialog(MemeView);
if(i == JFileChooser.APPROVE_OPTION) {
SaveMeme(JFSave.getSelectedFile());
}
}
else {
if(MemeView.getFavorite() == e.getSource()) {
FavoriteMeme(MemeView.getCurrentPath());
}
}
}
}
//Method to Save Meme After Editing It 
public void SaveMeme(File MemeFile) {
	BufferedImage updatememe = null;
	try {
	MemeView.setBounds(0, 0, MemeView.getWidth(), MemeView.getHeight());
	updatememe = new Robot().createScreenCapture(MemeView.getMemePanel().getBounds());	
	}
	catch(Exception ImageErrorException) {
	ImageErrorException.printStackTrace();	
	}
	try {
		ImageIO.write(updatememe,"jpeg", MemeFile);
	}
	catch(Exception ImageErrorException) {
	ImageErrorException.printStackTrace();	
	}
}
//Method to Favorite a meme
public void FavoriteMeme(String MemePath) {
if(MemePath != null) {
FavoriteMemePath.add(MemePath);
System.out.println(MemePath + "b");
}
else {
System.out.println(FavoriteMemePath.toString());
}
}
}
