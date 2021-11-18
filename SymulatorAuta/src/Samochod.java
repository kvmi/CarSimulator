
public class Samochod {

	private int predkosc;
	private int bieg;
	private int obroty;
	private boolean silnik;
	private boolean gaz;
	private boolean hamulec;

	public Samochod(boolean silnik, int bieg, int obroty, int predkosc)
	{
		this.silnik = silnik;
		this.bieg = bieg;
		this.obroty = obroty;
		this.predkosc = predkosc;
	}

	public int getPredkosc()
	{
		return predkosc;
	}

	public int getBieg()
	{
		return bieg;
	}

	public int getObroty()
	{
		return obroty;
	}

	public boolean getSilnik()
	{
		return silnik;
	}

	public void setPredkosc(int predkosc)
	{
		this.predkosc = predkosc;
	}

	public void setObroty(int obroty)
	{
		this.obroty = obroty;
	}
	public void setBieg(int bieg)
	{
		this.bieg = bieg;
	}
	public void setSilnik(boolean silnik)
	{
		this.silnik = silnik;
	}

	public void przyspiesz()
	{
		this.predkosc++;
	}

	public void zwolnij()
	{
		//for(int i = obroty;)
	}
	}
