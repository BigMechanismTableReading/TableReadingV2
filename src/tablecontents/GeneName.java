package tablecontents;

public class GeneName extends Protein {

	 //TODO update this regEx Look at this
	private static GeneName gene = null;
	public static GeneName getInstance(){
		if(gene == null)
			gene = new GeneName();
		return gene;
	}
	
	private GeneName(){
		regEx = "((?<![A-Z])[A-Z]{1}[0-9[A-Z[a-z]]]{1,7})";//TODO change the gene regEx
		priority_number = 4;
		//Some sort of mutual exclusion check?
	}
	
	public String groundIdentity(String ungrounded) {
		if(ungrounded != null){
			ungrounded = ungrounded.toUpperCase();
			if(getT().genename.containsKey(ungrounded))
				return("Uniprot:" + getT().genename.get(ungrounded));
		}
		return null;
	}

	private int countUpper(String match){
		int count = 0;
		for(int i = 0; i < match.length(); i ++){
			if(Character.isUpperCase(match.charAt(i)))
				count++;
		}
		return count;
	}
	
	@Override
	public String cellMatch(String match) {
		match = match.replaceAll("-", "");
		
		if(match.toLowerCase().contains("yes") || countUpper(match) >= 15 )
			return null;
		String grounded = groundIdentity(super.matchesFormat(match, regEx,true));
		return grounded;
	}
}
