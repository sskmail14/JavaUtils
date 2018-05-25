import java.util.function.Function;

public enum InstrumentsProperty {
	PIANO(KarokeInstruments::getPaino),
	FLUTE(KarokeInstruments::getFlute);
	
	final Function<KarokeInstruments,?> getter;

	
	private InstrumentsProperty(Function<KarokeInstruments, ?> f) {
        getter = f;
    }
	
	public Instruments getInstruments(KarokeInstruments k) {
		return (Instruments) getter.apply(k);
	}
}
