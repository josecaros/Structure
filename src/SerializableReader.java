import java.io.*;

public class SerializableReader extends ListReader {

	@Override
	public AbstractList reader(String _name) {
		// TODO Auto-generated method stub
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		AbstractList<String> lista= new SList<>();
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("D:\\"+_name+".txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			linea = br.readLine();
			if(linea.equals("DList"))
				lista= new DList<>();
			else if(linea.equals("CList"))
				lista=new CList<>();
			while ((linea = br.readLine()) != null) {
				lista.insert(linea);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
					System.out.println("Lectura completada...");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				return null;
			}
		}
		return lista;
	}

}
