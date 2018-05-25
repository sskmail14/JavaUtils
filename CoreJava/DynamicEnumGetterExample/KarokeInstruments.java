public class KarokeInstruments {
	private Paino paino;
	private Flute flute;
	
	public Paino getPaino() {
		return paino;
	}
	public void setPaino(Paino paino) {
		this.paino = paino;
	}
	public Flute getFlute() {
		return flute;
	}
	public void setFlute(Flute flute) {
		this.flute = flute;
	}
	public KarokeInstruments(Instruments paino, Instruments flute) {
		super();
		this.paino = (Paino) paino;
		this.flute = (Flute) flute;
	}
	
}
