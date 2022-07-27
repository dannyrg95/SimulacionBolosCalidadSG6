import static org.junit.Assert.*;
import org.junit.Test;


public class JuegoDeBolosTest{
	public JuegoDeBolos juego = new JuegoDeBolos();	
	
	private void tiros(int pinos, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++)
		{
			juego.lanzar(pinos);
		}
	}
	
	@Test
	//El Puntaje Deberia Ser Cero Si Todos Los Lanzamientos Van Al Canal
	public void Test01() throws Exception{		
		tiros(0,20);
		assertEquals(0,juego.score());
	}
	
	@Test
	//El Puntaje Deberia Ser 20 Si Todos Los Lanzamientos Derriban Uno
	public void Test02() throws Exception{

		tiros(1,20);
		assertEquals(20,juego.score());
	}
		
	
	@Test
	//Si Los dos Primeros Lanzamientos Son 4y6 La Jugada Es Un Spare
	public void Test03(){
	juego.lanzar(4);
	juego.lanzar(6);		
	tiros(0,18);
	assertTrue(juego.esSpare(0));
	}
	
	@Test
	//Si Los dos Primeros Tiros Derriban 4y3 Pinos La Jugada No Es Un Spare
	public void Test04(){
	juego.lanzar(4);
	juego.lanzar(3);		
	tiros(0,18);
	assertFalse(juego.esSpare(0));
	}
	
	@Test
	//Si El Primer Tiro Derriban 10 Pinos Es Un Strike
	public void Test05() 
	{		
		juego.lanzar(10);			
		tiros(0,19);
		assertTrue(juego.esStrike(0));
	}
	
	@Test
	//Si El Primer Tiro No Derriban 10 Pinos No Es Un Strike
	public void Test06() 
	{		
		juego.lanzar(2);			
		tiros(0,19);
		assertFalse(juego.esStrike(0));
	}
	
	@Test
	//Si En La Primera Jugada Deriban 5 Pinos Y Los Demas Tiros Van Al Canal El Score Final Es 5
	public void Test07()
	{
		juego.lanzar(5);	
		tiros(0,19);
		assertEquals(5,juego.score());
	}
}