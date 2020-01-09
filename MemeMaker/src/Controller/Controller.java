package Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
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
import javax.swing.OverlayLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;

import View.GUI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class Controller implements ActionListener, javax.swing.event.ChangeListener {
private GUI MemeView ;
private ArrayList<String>FavoriteMemePath;

public Controller() 
{
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
MemeView.getAddTopText().addActionListener(this);
MemeView.getMinusSign().addActionListener(this);
MemeView.getIncreaseSign().addActionListener(this);
MemeView.getMemeColor().getSelectionModel().addChangeListener(this);
FavoriteMemePath = new ArrayList<String>();
}
public static void main(String[]args) {
new Controller();
}
@SuppressWarnings("deprecation")
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
	MemeView.getMemePanel().setText("Hello");
	}
	catch(Exception ImageException) 
	{
		ImageException.printStackTrace();	
	}
}
}
else 
{
if(MemeView.getSave() == e.getSource()) {
JFileChooser JFSave = new JFileChooser("Save As");
int i = JFSave.showSaveDialog(MemeView);
if(i == JFileChooser.APPROVE_OPTION) {
SaveMeme(JFSave.getSelectedFile());
}
}
else 
{
if(MemeView.getFavorite() == e.getSource())
{
//FavoriteMeme(MemeView.getCurrentPath());
}
else {
if(MemeView.getShareIt() == e.getSource()) {
MemeView.getShareVia().setVisible(true);
MemeView.add(MemeView.getShareVia());	
}
else {
if(MemeView.getAddTopText() == e.getSource()) {
	System.out.println(MemeView.getChoosenColor());
	AddonMemePanel();
}
else {
if(MemeView.getIncreaseSign() == e.getSource()) {
	increasetextsize();
}	
else {
if(MemeView.getMinusSign() == e.getSource()) {
	decreasetextsize();
}	
}
}
}
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


//Method Which add on MemePanel Text(s)
public void AddonMemePanel() {	
	LayoutManager overlay = new OverlayLayout(MemeView.getMemePanel());
	MemeView.getMemePanel().setLayout(overlay);
	JLabel TextonMeme = new JLabel();
	if(MemeView.getMemeText().size() == 0) 
	{
	TextonMeme.setText(MemeView.getAllText().getText());
	TextonMeme.setForeground(Color.WHITE);
	TextonMeme.setFont(new Font("SanSerif",Font.BOLD,20));
	TextonMeme.setAlignmentX(1f);
	TextonMeme.setAlignmentY(1f);
	MemeView.getMemePanel().add(TextonMeme);
	MemeView.getMemePanel().add(TextonMeme);
	if(! TextonMeme.getText().isEmpty()) {
	MemeView.getMemeText().add(TextonMeme);
	}
	}
	else 
	{
	TextonMeme.setText(MemeView.getAllText().getText());
	TextonMeme.setForeground(Color.WHITE);
	TextonMeme.setFont(new Font("SanSerif",Font.BOLD,20));
	TextonMeme.setAlignmentX(0.1f);
	TextonMeme.setAlignmentY(0.1f);
	MemeView.getMemePanel().add(TextonMeme);
	MemeView.getMemePanel().add(TextonMeme);
	if(!TextonMeme.getText().isEmpty()) {
	MemeView.getMemeText().add(TextonMeme);
	}
	}
}
//increasetextsize increase the size of Text
public void increasetextsize() {
	ArrayList<JLabel>MemeResize = MemeView.getMemeText();
	for(int i=0; i < MemeResize.size();i++) {
	if(MemeResize.get(i).getText().equals(MemeView.getAllText().getText()) && 
	!MemeView.getAllText().getText().isEmpty()) {
		try {
	int fontsize = MemeResize.get(i).getFont().getSize();
	if(fontsize < 43) {
	fontsize+=3;
	MemeResize.get(i).setFont(new Font("SanSerif",Font.BOLD,fontsize));
	}
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
		
	}	
	}	
}
public void decreasetextsize() {
	ArrayList<JLabel>MemeResize = MemeView.getMemeText();
	for(int i=0; i < MemeResize.size();i++) {
	if(MemeResize.get(i).getText().equals(MemeView.getAllText().getText()) && 
	!MemeView.getAllText().getText().isEmpty()) {
		try {
	int fontsize = MemeResize.get(i).getFont().getSize();	
	fontsize-=3;
	if(fontsize >=17) {
	MemeResize.get(i).setFont(new Font("SanSerif",Font.BOLD,fontsize));
		}
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
		
	}	
	}	
}
//Method to Favorite a meme
//public void FavoriteMeme(String MemePath) {
//if(MemePath != null) {
//FavoriteMemePath.add(MemePath);
//System.out.println(MemePath + "b");
//}
//else {
//}
//}

@Override
public void stateChanged(ChangeEvent e) {
	
if(!MemeView.getAllText().getText().isEmpty())
{
	ArrayList<JLabel>MemeResize = MemeView.getMemeText();
	for(int i=0; i < MemeResize.size();i++) {
	if(MemeResize.get(i).getText().equals(MemeView.getAllText().getText()) && !MemeView.getAllText().getText().isEmpty()) {
		try 
		{
		MemeResize.get(i).setForeground(new Color(MemeView.getMemeColor().getColor().getRGB()));
		}
		catch(Exception colorexception) {
		colorexception.printStackTrace();	
		}		
    }	
  }	
     }
   }
    }