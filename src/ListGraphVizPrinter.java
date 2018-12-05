import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListGraphVizPrinter extends ListPrinter{
	String pathGraphViz= "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
	String pathDocSource ="D:\\execute.dot";
	String pathDocResult= "D:\\execute.jpg";
	String param1="-Tjpg";
	String param2="-o";
	public ListGraphVizPrinter(AbstractList lista) {
		// TODO Auto-generated constructor stub
		list=lista;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		try {
            File archivo = new File("D:\\execute.dot");
            BufferedWriter bw = null;

            //escribimos en el archivo .dot
            if (archivo.exists()) {
                bw.write("digraph G { \n");
                bw.write("nodesed = .05;\n");
                //bw.write("rankdir=LR;\n");
                bw.write("node [shape=record, width=\"0.8\", height=\".1\"];\n");
                
                Multinode aux = list.root;
               
                int cont = 0;
                while (aux != null) {
                    bw.write("node"+cont+"[label = \"<n> |<p> "+aux.getData()+" \"];\n");
                    //bw.write("A -- B [label="+aux.data+"]\n");
                    //System.out.print(aux.data);
                    aux = aux.getLink(Links.NEXT);
                    cont++;
                }
                
                aux = list.root;
                int cont2 = 0;
                while (aux != null) {
                    bw.write("node"+cont2+":p -> node"+ (++cont2) +" :n;\n");
                    //bw.write("A -- B [label="+aux.data+"]\n");
                    //System.out.print(aux.data);
                    aux = aux.getLink(Links.NEXT);
                }
                
                bw.write("}");
            } else {
                
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("digraph G { \n");
                bw.write("nodesed = .05;\n");
                //bw.write("rankdir=LR;\n");
                bw.write("node [shape=record, width=\"0.8\", height=\".1\"];\n");
                Multinode aux = list.root;
                int cont = 0;
                while (aux != null) {
                    bw.write("node"+cont+"[label = \"<n> |<p> "+aux.getData()+" \"];\n");
                    //bw.write("A -- B [label="+aux.data+"]\n");
                    //System.out.print(aux.data);
                    aux = aux.getLink(Links.NEXT);
                    cont++;
                }
                
                aux = list.root;
                int cont2 = 0;
                while (aux != null) {
                    bw.write("node"+cont2+":p -> node"+ (++cont2) +" :n;\n");
                    //bw.write("A -- B [label="+aux.data+"]\n");
                    //System.out.print(aux.data);
                    aux = aux.getLink(Links.NEXT);
                }
                //bw.write("A -- B [label=12]\n");
                bw.write("}");
                /*
                bw.write("graph G { \n");
                bw.write("\tA -- B [label=12];\n");
                bw.write("}");*/
            }
            bw.close();
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Error"+e.getMessage());
        }
		
		String[] exec= new String [5];
		exec[0]=pathGraphViz;
		exec[1]=param1;
		exec[2]=pathDocSource;
		exec[3]=param2;
		exec[4]=pathDocResult;
		try {
			Runtime rt = Runtime.getRuntime();
			rt.exec(exec);
			Thread.sleep (5000);
			File objetofile = new File (pathDocResult);
            Desktop.getDesktop().open(objetofile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
	}

}
