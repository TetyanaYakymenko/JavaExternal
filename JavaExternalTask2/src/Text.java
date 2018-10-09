import java.util.ArrayList;

public class Text {

	private ArrayList<Sentence> sentences;

	public Text() {
		sentences = new ArrayList<>();
	}

	public Text(ArrayList<Sentence> sentences) {
		this.sentences = sentences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (Sentence sent : sentences) {
			result += prime * result + ((sent == null) ? 0 : sent.hashCode());
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
		Text other = (Text) obj;
		if (sentences == null) {
			if (other.sentences != null)
				return false;
		} else if (sentences.size() != other.sentences.size()) {
			return false;
		} else {
			for (int i = 1; i < sentences.size(); i++) {
				if (!sentences.get(i).equals(other.sentences.get(i)))
					return false;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Sentence sent : sentences) {
			result.append(sent.toString() + " ");
		}
		return result.toString();
	}

	public void addSentence(Sentence sent) {
		if (null != sent)
			sentences.add(sent);
	}

	public void addSentences(ArrayList<Sentence> sents) {
		for (Sentence sent : sents) {
			addSentence(sent);
		}
	}

	public void printText() {
		System.out.println(sentences);
	}

	public void printHead() {
		System.out.println(sentences.get(0));
	}

}
