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

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		String newLine = System.lineSeparator();
		stringBuilder.append(super.toString());
		stringBuilder.append(newLine);
		int i = 1;
		for (Option option : options) {
			stringBuilder.append(i).append(") ") .append(option);
			i++;
		}
		return stringBuilder.toString();
	}

}
