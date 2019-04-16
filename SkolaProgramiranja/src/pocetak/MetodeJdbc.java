package pocetak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Entuzijasta;




public class MetodeJdbc {
	
	 public static Connection konektujSe(String imeBaze) throws SQLException {
		 String url = "jdbc:mysql://localhost:3306/" + imeBaze+ "?useSSL=false";
		 String user="root";
		 String password="nikola1996";
		 
		 return DriverManager.getConnection(url, user, password);
		 
		 
	 }
	 
	 
	 


		public static void azurirajPoPrezimenu(String prezime, int id) {
			
			Connection konekcija = null;
			PreparedStatement pst = null;
			
			try {
				konekcija = konektujSe("skola_programiranja");
				System.out.println("Uspesna konekcija!");
				
				String query = "UPDATE entuzijasti SET prezime = ? WHERE id_entuzijasti= ?";
				pst = konekcija.prepareStatement(query);
					pst.setString(1, prezime);
					pst.setInt(2, id);
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Neuspesna konekcija!");
			} finally {
				
				if(pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(konekcija != null) {
					
					try {
						konekcija.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			}	
		}	
		 
	 
    public static void ubaciUTabeluEntuzijasti(String ime, String prezime, String mail, int pozicija) {
	
	Connection konekcija = null;
	PreparedStatement pst = null;
	
	try {
		konekcija = konektujSe("skola_programiranja");
		String query = "INSERT INTO entuzijasti VALUES(NULL,?,?,?,?)";
		pst = konekcija.prepareStatement(query);
			pst.setString(1, ime);
			pst.setString(2, prezime);
			pst.setString(3, mail);
			pst.setInt(4, pozicija);
		pst.execute();
		System.out.println("Uspesno ste uneli podatak u tabelu!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(konekcija!=null) {
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
		
}


public static String dajImeEntuzijaste(int id) {
	
	Connection konekcija = null;
	PreparedStatement pst = null;
	ResultSet res = null;
	String vracenoIme = null;
	try {
		konekcija = konektujSe("skola_programiranja");
		String query = "SELECT ime FROM entuzijasti WHERE id_entuzijasti = ?";
		pst = konekcija.prepareStatement(query);
			pst.setInt(1, id);
		res = pst.executeQuery();
				
		while(res.next()) {
			
			vracenoIme = res.getString("ime");
		}
		return vracenoIme;		
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		
		try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			konekcija.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}

public static List<String> dajImenaEntuzijasta(int id){
	 
    Connection konekcija=null;
    PreparedStatement pst=null;	 
    ResultSet res=null;
    List <String> vracenaImena= new ArrayList<>();
    
    
    try {
		konekcija=konektujSe("skola_programiranja");
		String query="SELECT ime FROM entuzijasti where id_entuzijasti> ?";
		pst=konekcija.prepareStatement(query);
		pst.setInt(1, id);
		res=pst.executeQuery();
		while(res.next()) {
			vracenaImena.add(res.getString("ime"));
			
		}
		return vracenaImena;
	} catch (SQLException e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally {
		try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			konekcija.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	





}















}





















