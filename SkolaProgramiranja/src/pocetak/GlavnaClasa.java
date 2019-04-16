package pocetak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import Model.Entuzijasta;


public class GlavnaClasa {

	public static void main(String[] args) {
		      
        

        
         Scanner scanner = new Scanner(System.in);
		
		System.out.println("Unesite id: ");
		int id = scanner.nextInt();
		
		List <String> imena = MetodeJdbc.dajImenaEntuzijasta(id);
		System.out.println("Imena su: ");
            for(int i=0;i<imena.size();i++) {
			
			System.out.println(imena.get(i));
		}
		
	
		/*System.out.println("Unesite svoj id: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Unesite vase prezime: ");
		String prezime=scanner.nextLine();
		MetodeJdbc.azurirajPoPrezimenu(prezime, id);
		scanner.close();*/  
        
        
       
        //Kada trazis iz tabele 1 korisnika
    	/*System.out.println("id: ");
		int id = scanner.nextInt();		
		String ime = MetodeJdbc.dajImeEntuzijaste(id);
		System.out.println(ime);*/
	
            
            
		/*System.out.println("Unesite ime: ");
		String ime = scanner.nextLine();
		
		System.out.println("Unesite prezime: ");
		String prezime = scanner.nextLine();
		
		System.out.println("Unesite mail: ");
		String mail = scanner.nextLine();
		
		System.out.println("Unesite poziciju: ");
		int pozicija = Integer.parseInt(scanner.nextLine());
		
		MetodeJdbc.ubaciUTabeluEntuzijasti(ime, prezime, mail, pozicija);*/
		
		
        
		
		
		

	}

}
