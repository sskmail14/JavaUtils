import java.util.Arrays;

public class Flute implements Instruments {

	@Override
	public MusicStatus validateInstrument(Object o) {
		FluteNotes pn = (FluteNotes) o;
		System.out.println(pn.getNotes());
		return new MusicStatus(Arrays.asList("Tested Flute!!!"), Boolean.TRUE);
	}

}
