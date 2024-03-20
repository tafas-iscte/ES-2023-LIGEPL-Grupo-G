package pt.iscte.gestao_de_horarios;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       // LancaBrowser lancaBrowser = new LancaBrowser();
        try {
			LancaBrowser.main(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
