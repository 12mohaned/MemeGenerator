package View;
import Model.Meme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;
import Controller.Controller;
public class GUI  extends JFrame{
private JButton Save;
private JButton FeaturedMemes;
private JButton SelectImage;
private JButton Draw;
private JButton Write;
private JButton Favorite;
private JButton ShareIt;
private JPanel Text;
private JLabel MemePanel;
private JPanel Buttons;
private JPanel MemeControls;
private JTextArea AllText;
private JButton FavoriteMemes;
private JButton AddTextUpper;
private JPopupMenu ShareVia;
private String CurrentPath;
private JButton AddTopText;
private Controller c;
private Meme meme; 
private JButton increaseSign;
private JButton MinusSign;
private ArrayList<JLabel>MemeText;
private JPanel AddSigns;
private JColorChooser MemeColor;
private Color choosenColor;
public GUI(Controller c) {
	super("Meme Maker");
	this.c = c;
	Text = new JPanel();
	increaseSign = new JButton();
	MinusSign = new JButton();
	MemePanel = new JLabel();
	MemePanel.setPreferredSize(new Dimension(400,10));
	Buttons = new JPanel();
	Save = new JButton();
	MemeText = new ArrayList<JLabel>();
	ShareVia = new JPopupMenu("Share on social Media");
	JMenuItem Facebook = new JMenuItem("Share on Facebook");
	JMenuItem Twitter = new JMenuItem("Share on Twitter");
	ShareVia.setPreferredSize(new Dimension(500,500));
	FavoriteMemes = new JButton("FavoriteMemes");
	AddTextUpper = new JButton("Add Text on Meme");
	SelectImage = new JButton("");
	Draw = new JButton("");
	Write= new JButton("Write");
	FeaturedMemes = new JButton("Featured Memes");
	Favorite = new JButton("");
	ShareIt = new JButton("");
	AllText = new JTextArea(5,20);
	MemeControls = new JPanel();
	MemeColor = new JColorChooser();
	MemeColor.setPreferredSize(new Dimension(450,50));
	increaseSign.setPreferredSize(new Dimension(100,100));
	MinusSign.setPreferredSize(new Dimension(80,50));
	AllText.setSize(new Dimension(50,50));
	Save.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/save.png"));
	Draw.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/pen.png"));
	Favorite.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/love.png"));
	ShareIt.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/share.jpg"));
	SelectImage.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/cursor.png"));
	increaseSign.setIcon(new ImageIcon("/Users/mohanedmashaly/MemeGenerator/MemeMaker/src/View/plus.png"));
	MinusSign.setIcon(new ImageIcon("/Users/mohanedmashaly/MemeGenerator/MemeMaker/src/View/minus.png"));
	AddTextUpper.setSize(new Dimension(100,100));
	AddTextUpper.setLocation(300, 300);
	Text.add(AddTextUpper);
	MemeControls.add(MinusSign);
	MemeControls.add(increaseSign);
	MemeControls.add(AllText);
	Buttons.add(Draw);
	Buttons.add(Favorite);
	Buttons.add(ShareIt);
	Buttons.add(Save);	
	Buttons.add(FavoriteMemes);
	Buttons.add(FeaturedMemes);
	Buttons.add(SelectImage);
	ShareVia.add(Facebook);
	ShareVia.add(Twitter);
	choosenColor = MemeColor.getColor();
	this.add(ShareVia);
	this.setLayout(new BorderLayout());
	this.add(Buttons,BorderLayout.NORTH);
	this.add(MemePanel,BorderLayout.WEST);
	this.add(MemeControls,BorderLayout.SOUTH);
	this.add(Text,BorderLayout.CENTER);
	this.add(MemeColor,BorderLayout.EAST);
	this.setSize(new Dimension(1200,1200));
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
}
public JColorChooser getMemeColor() {
	return MemeColor;
}
public void setMemeColor(JColorChooser memeColor) {
	MemeColor = memeColor;
}
public ArrayList<JLabel> getMemeText() {
	return MemeText;
}
public void setMemeText(ArrayList<JLabel> memeText) {
	MemeText = memeText;
}

public JButton getAddTopText() {
	return AddTextUpper;
}
public Meme getMeme() {
	return meme;
}
public void setMeme(Meme meme) {
	this.meme = meme;
}
public void setMemePanel(JLabel memePanel) {
	MemePanel = memePanel;
}
public JLabel getMemePanel() {
	return MemePanel;
}

public String getCurrentPath() {
	return CurrentPath;
}
public void setCurrentPath(String currentPath) {
	CurrentPath = currentPath;
}

public JPopupMenu getShareVia() {
	return ShareVia;
}
public void setAllText(JTextArea AllText) {
	this.AllText = AllText;
}

public JButton getSave() {
	return Save;
}
public JButton getFeaturedMemes() {
	return FeaturedMemes;
}
public JButton getSelectImage() {
	return SelectImage;
}
public JButton getDraw() {
	return Draw;
}
public JButton getWrite() {
	return Write;
}
public JButton getFavorite() {
	return Favorite;
}
public JButton getShareIt() {
	return ShareIt;
}
public JButton getFavoriteMemes() {
	return FavoriteMemes;
}
public JTextArea getAllText() {
	return AllText;
}
public JPanel getMemeControls() {
	return MemeControls;
}
public void setMemeControls(JPanel memeControls) {
	MemeControls = memeControls;
}
public JButton getIncreaseSign() {
	return increaseSign;
}
public JButton getMinusSign() {
	return MinusSign;
}
}
