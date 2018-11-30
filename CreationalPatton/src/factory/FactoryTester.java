package factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryTester {

	public static void main(String[] args) throws IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String read=reader.readLine();
		Frute bulder=FruteBulder.getFrute(read);
		bulder.displayMyName();
	}

}
