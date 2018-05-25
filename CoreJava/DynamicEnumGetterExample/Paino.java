import java.util.Arrays;

public class Paino implements Instruments {
	private Notes notes;
	
	@Override
	public MusicStatus validateInstrument(Object o) {
		notes = (PainoNotes) o;
		System.out.println(notes.getNotes());
		return new MusicStatus(Arrays.asList("Tested Paino!!!"), Boolean.TRUE);
	}

}
