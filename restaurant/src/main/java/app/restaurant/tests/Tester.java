package app.restaurant.tests;

public class Tester {
	
	public static void runTest() {
		/* ====================================================================================================
		//IstoricComenzi
		
		IstoricComenziDao istoricDao = new IstoricComenziDaoImpl();
		IstoricComenzi istoric = new IstoricComenzi();
		
		//==================== JOIN ================================================
				Produs produs = new Produs();
				
				produs.setId(4);
				istoric.setProdusId(4);
				List<Object[]> result = istoricDao.simpleQuery(istoric, produs);				
				
				System.out.print(result.get(0)[0] + " ");
				System.out.print(result.get(0)[1] + " ");
				System.out.print(result.get(0)[2]);
				
				
		//===========================================================================
		
		//istoric.setComandaId(1);
		//istoric.setProdusId(3);
		//istoricDao.addIstoricComenzi(istoric);
		
		//istoric.setId(2);
		//istoricDao.removeIstoricComenzi(istoric);
		 ====================================================================================================*/
		
		/* ====================================================================================================
		//NotaDePlata
		  
		NotaDePlataDao notaDao = new NotaDePlataDaoImpl();
		NotaDePlata nota = new NotaDePlata();		
		
		//==================== JOIN ================================================
				//Masa masa = new Masa();
				
				//masa.setId(2);
				//nota.setNrMasa(2);
				//List<Object[]> result = notaDao.simpleQuery(nota, masa);			
				//System.out.print(result.get(0)[0] + " ");
				//System.out.print(result.get(0)[1] + " ");
				//System.out.print(result.get(0)[2]);
				
				
		//===========================================================================
		 
		//==================== COMPLEX QUERY ================================================
		  //Comanda comanda = new Comanda();
		
		  //comanda.setData("2017-01-01 02:20:00");
		  //List<Object[]> result = notaDao.complexQuery(comanda);
		  //System.out.print(result.get(0)[0] + " ");
		  //System.out.print(result.get(0)[1] + " ");
		  //System.out.print(result.get(0)[2] + " ");
		  
		//====================================================================================
		
		//nota.setGramajTotal(600);
		//nota.setNrMasa(2);
		//nota.setPretTotal(150);
		//notaDao.addNota(nota);
		
		//nota.setId(1);
		//nota.setGramajTotal(1000);
		//nota.setPretTotal(200);
		//notaDao.updateNota(nota);
		
		//notaDao.removeNota(nota);
	     ====================================================================================================*/
		
		/* ====================================================================================================
		//Produs
		 
		ProdusDao produsDao = new ProdusDaoImpl();
		Produs produs = new Produs();
		
		//==================== COMPLEX QUERY ================================================
		  //Categorie categorie = new Categorie();
		  
		  //categorie.setDenumire("Preparate reci");
		  //List<Object[]> result = produsDao.complexQuery(categorie);
		  //System.out.print(result.get(0)[0] + " ");
		  //System.out.print(result.get(0)[1] + " ");
		  
		//====================================================================================
		
		//produs.setCategorieId(3);
		//produs.setNume("Ceafa de porc");
		//produs.setPret(15);
		//produs.setGramaj(300);
		//produsDao.addProdus(produs);
		
		//produs.setPret(6);
		//produs.setId(1);
		//produs.setGramaj(250);
		//produs.setNume("Kaiser");
		//produsDao.updateProdus(produs);
		
		//produsDao.removeProdus(produs);
		
		//List<Produs> produse = produsDao.getProduse();
		//produse.stream().map(p -> p.getNume()).forEach(System.out::println);
		
		//====================================================================================================*/
		
		/* ====================================================================================================
		//Comanda
		
		ComandaDao comandaDao = new ComandaDaoImpl();
		Comanda comanda = new Comanda();
		
		//==================== JOIN ================================================
				IstoricComenzi istoric = new IstoricComenzi();
				
				comanda.setId(1);
				istoric.setComandaId(1);
				List<Object[]> result = comandaDao.simpleQuery(comanda, istoric); 				
				
				System.out.print(result.get(0));
			
				
				
		//=========================================================================
		
		//comanda.setClientId(2);
		//comanda.setData("2016-09-23 13:54:25");
		//comandaDao.addComanda(comanda);
		
		//comanda.setId(1);
		//comanda.setData("2016-09-23 15:44:04");
		//comandaDao.updateComanda(comanda);
		
		//comandaDao.removeComanda(comanda);
		 
		====================================================================================================*/
		
		/*====================================================================================================
		// Categorie
			
				CategorieDao categorieDao = new CategorieDaoImpl();
				Categorie categorie = new Categorie();
				
				
				//==================== JOIN ================================================
				
				//categorie.setId(2);
				//produs.setCategorieId(2);
				//List<Object[]> result = categorieDao.simpleQuery(categorie, produs);			
				
				//System.out.print(result.get(0)[0] + ": ");
				//System.out.print(result.get(0)[1]);
				//System.out.println(result.get(1)[0]);
				//System.out.println(result.get(1)[1]);
				
				//==========================================================================
				
				//==================== COMPLEX QUERY ================================================
				  //Produs produs = new Produs();
				  
				  //produs.setGramaj(500);				  
				  //List<Object[]> result = categorieDao.complexQuery(produs);
				  //System.out.print(result.get(0) + " ");
				  
				
				//==========================================================================
				
				//categorie.setDenumire("Gratar");
				//categorieDao.addCategorie(categorie);
				
				//categorie.setDenumire("Bauturi");
				//categorie.setId(3); 
				//categorieDao.updateCategorie(categorie);
				
				//categorieDao.removeCategorie(categorie);
				
				//List<Categorie> categorii = categorieDao.getCategorie();				
				//categorii.stream().map(m -> m.getDenumire()).forEach(System.out::println);
		
		   ====================================================================================================*/
				  
		/* ====================================================================================================
		// Masa
				MasaDao masaDao = new MasaDaoImpl();
				Masa masa = new Masa();
				
				//==================== COMPLEX QUERY ================================================
				  
				  masa.setId(2);
				  List<Object[]> result = masaDao.complexQuery(masa);
				  System.out.print(result.get(0)[0] + " ");
				  System.out.print(result.get(0)[1] + " ");
				  System.out.println(result.get(0)[2] + " ");
				  System.out.print(result.get(1)[0] + " ");
				  System.out.print(result.get(1)[1] + " ");
				  System.out.print(result.get(1)[2] + " ");
				
				//==========================================================================
				 
				//masa.setNrLocuri(10);
				//masaDao.addTable(masa);
				
				
				//masa.setId(3);
				//masa.setNrLocuri(5);
				//masaDao.updateTable(masa);
				
				//masa.setId(2);
				//masaDao.removeTable(masa);
				
				
				//newTable.setNrLocuri(7);
				//masaDao.updateTable(newTable);
				//List<Masa> mese = masaDao.getTables();

				//mese.stream().map(m -> m.getNrLocuri()).forEach(System.out::println);
			====================================================================================================*/	
			
		/* ====================================================================================================
		 
		// Clienti
				
				CustomerDao clientDao = new CustomerDaoImpl();				
				Customer newClient = new Customer();
				Masa masa = new Masa();
				
				//==================== JOIN ================================================
				//masa.setId(2);
				//newClient.setNrMasa(2);
				//List<Object[]> cl = clientDao.simpleQuery(newClient, masa);
				//cl.forEach(c -> System.out.println(c.getNume()));
				//System.out.println(cl.size());
				//cl.stream().map(c -> c.getNume()).forEach(System.out::println);
				//System.out.println(cl.get(0)[0]);
				//System.out.println(cl.get(0)[1]);
				//System.out.println(cl.get(1)[0]);
				//System.out.println(cl.get(1)[1]);
				
				//==========================================================================
				
				//==================== JOIN 2 ================================================
				//Comanda comanda = new Comanda();
				//newClient.setId(1);
				//comanda.setClientId(1);
				//List<Object[]> cl = clientDao.simpleQuery2(newClient,comanda);
				//System.out.print(cl.get(0)[0] + " ");
				//System.out.print(cl.get(0)[1] + ": ");
				//System.out.print(cl.get(0)[2]);				
				
				//==========================================================================
				 
			    //==================== COMPLEX QUERY ================================================
				  //Comanda comanda = new Comanda();				  
				  //comanda.setData("2017-01-01 02:20:00");
				  //List<Object[]> result = clientDao.complexQuery(newClient, comanda);
				  //System.out.print(result.get(0)[0] + " ");
				  //System.out.print(result.get(0)[1] + " ");				
				
				//==========================================================================
				
				//newClient.setNume("Hamilton");
				//newClient.setPrenume("John");
				//newClient.setNrMasa(1);
				//clientDao.addCustomer(newClient);
				
				//newClient.setId(1);
				//newClient.setNume("Carol");
				//newClient.setPrenume("Alfred");
				//newClient.setNrMasa(2);
				//clientDao.updateCustomer(newClient);			
				
				//newClient.setId(1);
			    //clientDao.removeCustomer(newClient);		    
				
				//List<Customer> clienti = clientDao.getCustomersByName("Carol", "Alfred");
				
				//clienti.stream().map(c -> c.getNume()).forEach(System.out::println);
		==================================================================================================== */
		
	}
}
