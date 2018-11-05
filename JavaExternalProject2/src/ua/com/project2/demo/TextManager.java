package ua.com.project2.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ua.com.project2.Word;
import ua.com.project2.Sentence;

public class TextManager {
	private String text;
	private List<Sentence> sentences;
	private Set<Word> words;

	private Map<Word, List<Sentence>> wordsInSentences;

	public TextManager() {
		text = new String();
	}

	public TextManager(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public Set<Word> getWords() {
		if (words == null) {
			words = new HashSet<Word>();
			String[] values = text.split("\\W+");
			for (String word : values) {
				words.add(new Word(word.toLowerCase()));
			}
		}
		return words;
	}

	public List<Sentence> getSentences() {
		if (sentences == null) {
			sentences = new ArrayList<>();
			String[] values = text.split("\\.+|\\?+|\\!+");
			for (String sentence : values) {
				sentences.add(new Sentence(sentence));
			}
		}
		return sentences;
	}

	public Map<Word, List<Sentence>> getWordsInSentences() {
		if (wordsInSentences == null) {
			wordsInSentences = new HashMap<Word, List<Sentence>>();
			List<Sentence> inSentences;
			if (words == null) {
				getWords();
			}
			if (sentences == null) {
				getSentences();
			}
			for (Word word : words) {
				inSentences = new ArrayList<>();
				for (Sentence sentence : sentences) {
					List<Word> listWords = sentence.getWords();
					if (listWords.contains(word)) {
						inSentences.add(sentence);
					}
				}
				wordsInSentences.put(word, inSentences);
			}
		}
		return wordsInSentences;
	}

	public int getMaxEntriesWord() {
		if (wordsInSentences == null) {
			getWordsInSentences();
		}
		int result = 0;
		for (List<Sentence> sents : wordsInSentences.values()) {
			result = Math.max(result, sents.size());
		}
		return result;
	}

	public List<Sentence> getMaxEntriesSentencesWithTheSameWord() {
		List<Sentence> result = new ArrayList<>();
		int maxEntries = getMaxEntriesWord();
		for (List<Sentence> sents : wordsInSentences.values()) {
			if (sents.size() == maxEntries) {
				result.addAll(sents);
			}
		}
		return result;
	}

}
