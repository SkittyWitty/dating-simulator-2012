import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Girls{
ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
String code;
public Girls(String code, String name){
this.code=code;
for(int i=0;i<8;i++){
	insert(name+"\\"+name+i+".jpg");
}
}
private void insert(String filename) {
File file = new File(filename);
try{
images.add(ImageIO.read(file));
}
catch(IOException e){
JOptionPane.showMessageDialog(null,"file "+filename+" not found");
}
}
public BufferedImage getFirstImpression(){
return images.get(0);
}
public BufferedImage getNeutral(){
return images.get(1);
}
public BufferedImage getHappy(){
return images.get(2);
}
public BufferedImage getSad(){
return images.get(3);
}
public BufferedImage getAngry(){
return images.get(4);
}
public BufferedImage getJosh(){
return images.get(5);
}
public BufferedImage getDanny(){
return images.get(6);
}
public BufferedImage getTyler(){
return images.get(7);
}
public String getCode(){
return code;
}
}