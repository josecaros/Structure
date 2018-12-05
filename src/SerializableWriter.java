import java.io.*;

public class SerializableWriter extends ListWriter {
	
	public SerializableWriter( AbstractList lista) {
		// TODO Auto-generated constructor stub
		list=lista;
	}

	@Override
	public void write(String _name) {
		// TODO Auto-generated method stub
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("D:/"+_name+".txt");
            pw = new PrintWriter(fichero);
            Multinode aux = list.root;
            pw.println(list.descripcion());
            for (int i = 0; i < list.size; i++) {
            	pw.println(""+aux.getData());
            	aux=aux.getLink(Links.NEXT);
            }
                

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero) {
              fichero.close();
              System.out.println("Lista tipo "+list.descripcion()+" guardada satisfactoriamente...");
              Printer print=new ListConsolePrinter(list);
      		  print.print();
           }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }

		
	}
	
}
