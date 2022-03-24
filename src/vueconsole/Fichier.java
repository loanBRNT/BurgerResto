package vueconsole;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichier {
	public static void ecrire(String texte) {
		try {
			File f = new File("./ecranCuisinier.txt");
			f.createNewFile();
			FileWriter fw = new FileWriter(f, true);
			fw.write(texte+"\n");
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void effacer() {
		try {
			File f = new File("./ecranCuisinier.txt");
			f.createNewFile();
			FileWriter fw = new FileWriter(f, false);
			fw.write("");
			fw.flush();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
