package tablecontents;

public class PhosphoAmino extends Amino {

	private String cellRegEx = "^[SYT]$|\\bser\\b|\\btyr\\b|\\bthr\\b";
	private static PhosphoAmino phosAmino = null;
	public static PhosphoAmino getInstance(){
		if(phosAmino == null)
			phosAmino = new PhosphoAmino();
		return phosAmino;
	}
	private PhosphoAmino(){
		
	}

	@Override
	public String cellMatch(String match) {
		return super.cellMatch(match, cellRegEx);
	}
}
