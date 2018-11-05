package ua.com.project2;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
	private String sentence;
	private List<Word> words;

	public Sentence() {
		sentence = new String();
		words = new ArrayList<>();
	}

	public Sentence(String sent) {
		this.sentence = sent;
		
	}

	public List<Word> getWords() {
		if(words == null) {
			words = new ArrayList<>();
			String[] values = sentence.split("\\W+");
			for(String word : values) {
				words.add(new Word(word.toLowerCase()));
			}
		}
		return words;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sentence == null) ? 0 : sentence.hashCode());
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
		if (sentence == null) {
			if (other.sentence != null)
				return false;
		} else if (!sentence.equals(other.sentence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return sentence;
	}

}
