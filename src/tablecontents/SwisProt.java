package tablecontents;

public class SwisProt extends Protein{
	private static SwisProt swis = null;
	public static SwisProt getInstance(){
		if(swis == null)
			swis = new SwisProt();
		return swis;
	}
	private SwisProt(){
		 regEx = "([A-Z[0-9]]{1,4}_[A-Z]{0,10})";
		 priority_number = 2;
	}
	public String groundIdentity(String ungrounded) {
		if(ungrounded != null){
			if(getT().swisprot.containsKey(ungrounded))
				return("Uniprot:" + getT().swisprot.get(ungrounded));
		}
		return null;
	}
	@Override
	public String cellMatch(String match) {
		String grounded = groundIdentity(super.matchesFormat(match, regEx,false));
		return grounded;
	}
	

}
