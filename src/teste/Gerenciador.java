package teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Gerenciador {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
	//	for (String string : args) {
			Properties properties = new Properties();
			String path = "/home/rodrigo/workspace/TAP/bin/teste/";
			String argx = "framework.properties";
			properties.load(new FileInputStream(path + argx));
			try{
		       Class c = Class.forName((String) properties.get("classe"));
		       c.newInstance();
		       if(properties.get("alvo")!=null){
		    	   properties.load(new FileInputStream("C:\\Documents and Settings\\ffreitas\\Desktop\\workspace\\ReflectionExemplo\\bin\\teste\\"+properties.get("alvo")));
		    	   c = Class.forName((String) properties.get("classe"));
			       Object plugin1 =  c.newInstance(); 
			       if(properties.get("funcionalidade")!=null){
			    	   Method meth = c.getMethod((String) properties.get("funcionalidade"), null);
			    	   meth.invoke(plugin1);
			       }
		       }
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		

	//}

}
