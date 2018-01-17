package data;

public class Option {
	String content;
	int votes;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getVotes() {
		return votes;
	}
	
	public void vote () {
		votes ++;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String newLine = System.lineSeparator();
		stringBuilder.append(" option: ");
		stringBuilder.append(content).append(". ").append(" votes: ").append(votes);
		stringBuilder.append(newLine);
		return  stringBuilder.toString();
	}

}
