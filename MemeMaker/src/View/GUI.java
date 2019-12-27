package View;
import Model.Meme;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
private JPanel Controls;
//private JTextField TopText;
private JEditorPane TopText;
private JTextField BottomText;
private JButton FavoriteMemes;
private JButton AddTextUpper;
private JButton AddTextbelow;
private JPopupMenu SaveAs;
private String CurrentPath;
private Controller c;
private Meme meme; 
public GUI(Controller c) {
	super("Meme Maker");
	this.c = c;
	Text = new JPanel();
	MemePanel = new JLabel();
	MemePanel.setPreferredSize(new Dimension(400,10));
	Controls = new JPanel();
	Save = new JButton();
	SaveAs = new JPopupMenu("Save As Window");
	JMenuItem SaveItem = new JMenuItem("Select");
	SaveAs.add(SaveItem);
	FavoriteMemes = new JButton("FavoriteMemes");
	AddTextUpper = new JButton("Add upperText");
	AddTextbelow = new JButton("Add belowtext");
	SelectImage = new JButton("");
	Draw = new JButton("");
	Write= new JButton("Write");
	FeaturedMemes = new JButton("Featured Memes");
	Favorite = new JButton("");
	ShareIt = new JButton("");
	TopText = new JEditorPane();
	BottomText = new JTextField();
	Text.setLayout(new GridLayout(1,1));
	Text.add(TopText);
	Text.add(BottomText);
	Controls.add(Draw);
	Controls.add(Favorite);
	Controls.add(ShareIt);
	Controls.add(Save);	
	Controls.add(FavoriteMemes);
	Controls.add(FeaturedMemes);
	Controls.add(SelectImage);
	Save.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/save.png"));
	Draw.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/pen.png"));
	Favorite.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/love.png"));
	ShareIt.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/share.jpg"));
	SelectImage.setIcon(new ImageIcon("/Users/mohanedmashaly/eclipse-workspace/MemeMaker/src/View/cursor.png"));
	this.setLayout(new BorderLayout());
	this.add(Controls,BorderLayout.NORTH);
	this.add(MemePanel,BorderLayout.WEST);
	this.add(Text,BorderLayout.EAST);
	this.setSize(new Dimension(1200,1200));
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setVisible(true);
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
public JPopupMenu getSaveAs() {
	return SaveAs;
}
public JEditorPane getTopText() {
	return TopText;
}
public void setTopText(JEditorPane topText) {
	TopText = topText;
}
public JTextField getBottomText() {
	return BottomText;
}
public void setBottomText(JTextField bottomText) {
	BottomText = bottomText;
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
}