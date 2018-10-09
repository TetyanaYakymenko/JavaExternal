import java.util.ArrayList;

public class Sentence {

	private ArrayList<String> words;

	public Sentence() {
		words = new ArrayList<>();
	}

	public Sentence(ArrayList<String> listOfWords) {
		words = listOfWords;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (String word : words) {
			result += prime * result + ((word == null) ? 0 : words.hashCode());
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sentence other = (Sentence) obj;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (words.size() != other.words.size()) {
			return false;
		} else {
			for (int i = 1; i < words.size(); i++) {
				if (!words.get(i).equals(other.words.get(i)))
					return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			result.append(word + " ");
		}
		return result.toString();
	}

}
