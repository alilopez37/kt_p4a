package com.upchiapas.kt_template.quiz.data.repository

import com.upchiapas.kt_template.quiz.data.Question
import com.upchiapas.kt_template.quiz.data.datasource.QuizLocalDataSource

class InMemoryRepository(
    private val dataSource: QuizLocalDataSource
) : QuizRepository {

    override fun getQuestions(): List<Question> {
        return dataSource.getQuestions()
    }
}