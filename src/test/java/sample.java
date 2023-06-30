import java.io.IOException;
import java.util.ArrayList;

public class sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Datadriven data = new Datadriven();
		ArrayList para = data.getData("Delete Profile");
		System.out.println(para.get(0));
		System.out.println(para.get(1));
		System.out.println(para.get(2));
		System.out.println(para.get(3));
	}
}
