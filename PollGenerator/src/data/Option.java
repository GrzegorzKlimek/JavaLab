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

}
