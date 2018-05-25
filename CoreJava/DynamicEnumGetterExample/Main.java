public class Main {

	public static void main(String[] args) {
		Instruments p = new Paino();
		PainoNotes pn = new PainoNotes();
		pn.setNotes("Paino Notes....");
		
		Instruments f = new Flute();
		FluteNotes fn = new FluteNotes();
		fn.setNotes("Flute Notes....");
		
		KarokeInstruments ki = new KarokeInstruments(p, f);
		
		Instruments i = InstrumentsProperty.valueOf("PIANO").getInstruments(ki);
		MusicStatus ms = i.validateInstrument(pn);
		
		System.out.println(ms.getStatus());
		
		i = InstrumentsProperty.valueOf("FLUTE").getInstruments(ki);
		ms = i.validateInstrument(fn);
		
		System.out.println(ms.getStatus());
	}

}
