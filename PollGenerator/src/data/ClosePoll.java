package data;

import java.util.List;

public class ClosePoll extends Poll {
	
	private List <Option> options;

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
