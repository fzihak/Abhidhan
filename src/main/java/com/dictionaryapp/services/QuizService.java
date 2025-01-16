package com.dictionaryapp.services;

import com.dictionaryapp.models.Word;
import java.util.*;
import java.util.stream.Collectors;

public class QuizService {
    private final WordService wordService;
    private List<Word> quizWords;
    private int currentQuestionIndex;
    private int score;
    private static final int QUESTIONS_PER_QUIZ = 10;

    public QuizService(WordService wordService) {
        this.wordService = wordService;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void startNewQuiz() {
        quizWords = wordService.getFavorites();
        if (quizWords.size() < QUESTIONS_PER_QUIZ) {
            quizWords.addAll(wordService.getRandomWords(QUESTIONS_PER_QUIZ - quizWords.size()));
        }
        Collections.shuffle(quizWords);
        quizWords = quizWords.subList(0, QUESTIONS_PER_QUIZ);
        currentQuestionIndex = 0;
        score = 0;
    }

    public QuizQuestion getNextQuestion() {
        if (currentQuestionIndex >= quizWords.size()) {
            return null;
        }

        Word currentWord = quizWords.get(currentQuestionIndex);
        List<String> options = generateOptions(currentWord);
        
        return new QuizQuestion(
            currentWord.getTerm(),
            options,
            options.indexOf(currentWord.getDefinition())
        );
    }

    private List<String> generateOptions(Word correctWord) {
        List<String> options = new ArrayList<>();
        options.add(correctWord.getDefinition());

        // Get 3 random wrong options
        List<Word> wrongOptions = wordService.getRandomWords(3);
        options.addAll(wrongOptions.stream()
            .map(Word::getDefinition)
            .collect(Collectors.toList()));

        Collections.shuffle(options);
        return options;
    }

    public boolean submitAnswer(int selectedOptionIndex) {
        QuizQuestion currentQuestion = getNextQuestion();
        if (currentQuestion == null) {
            return false;
        }

        boolean isCorrect = selectedOptionIndex == currentQuestion.getCorrectOptionIndex();
        if (isCorrect) {
            score++;
        }
        currentQuestionIndex++;
        return isCorrect;
    }

    public int getScore() {
        return score;
    }

    public boolean isQuizComplete() {
        return currentQuestionIndex >= QUESTIONS_PER_QUIZ;
    }

    public static class QuizQuestion {
        private final String word;
        private final List<String> options;
        private final int correctOptionIndex;

        public QuizQuestion(String word, List<String> options, int correctOptionIndex) {
            this.word = word;
            this.options = options;
            this.correctOptionIndex = correctOptionIndex;
        }

        public String getWord() { return word; }
        public List<String> getOptions() { return options; }
        public int getCorrectOptionIndex() { return correctOptionIndex; }
    }
}