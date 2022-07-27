public class JuegoDeBolos {

	private int[] tiros = new int[21];
	private int tiroActual=0;
	
	public void lanzar(int palitroque)
	{
		tiros[tiroActual]=palitroque;
		tiroActual++;
		
	}
	
	//Puntaje
	public int score() { 
		int total=0;
		int jugadaIndex=0;
		for(int jugada=0;jugada<10;jugada++)
		{			
			if(esStrike(jugadaIndex))
			{
				//Es Strike, entonces bonus
				total+=10+ultimoTiroStrike(jugadaIndex);
				jugadaIndex++;
			}
			else
			{
				//SPARE
				if(esSpare(jugadaIndex))
				{
					total+=10+tiros[jugadaIndex+2];
				}
				else
				{
					total+=sumaDeLosLanzamientos(jugadaIndex);
				}
				jugadaIndex+=2;
			}
		}
		return total;
	}

	private int sumaDeLosLanzamientos(int frameIndex) {		
		return tiros[frameIndex]+tiros[frameIndex+1];
	}


	//Voltear todos los palos con la segunda bola que se lanza
	public boolean esSpare(int frameIndex) {
		if(tiros[frameIndex]+tiros[frameIndex+1]==10)
			return true;
		else
			return false;
	}
	
	public int ultimoTiroStrike(int frameIndex) {		
		return tiros[frameIndex+1]+tiros[frameIndex+2];
	}

	//Significa voltear todos los palos con la primera bola que se lanza.
	//Probar caso de Falla
	public boolean esStrike(int frameIndex) {
		if(tiros[frameIndex]==10)
			return true;
		else
			return false;
	}
}