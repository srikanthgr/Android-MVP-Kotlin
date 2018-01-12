package com.srikanth.androidmvpkotlin.domain

import com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels.AnswerViewModel
import com.example.tamaskozmer.kotlinrxexample.presentation.view.viewmodels.QuestionViewModel
import com.srikanth.androidmvpkotlin.model.entities.Answer
import com.srikanth.androidmvpkotlin.model.entities.Question
import com.srikanth.androidmvpkotlin.model.repositories.DetailsRepository
import com.srikanth.androidmvpkotlin.presentation.views.viewmodels.DetailsViewModel
import io.reactivex.Single
import io.reactivex.functions.Function3


class GetDetails(private val detailsRepository: DetailsRepository) {

    fun execute(userId: Long, forced: Boolean): Single<DetailsViewModel> {
        return Single.zip(detailsRepository.getQuestionsByUser(userId, forced), getTitlesForAnswers(userId, forced), detailsRepository.getFavoritesByUser(userId, forced), Function3 { questions, answers, favorites -> createDetailsModel(questions, answers, favorites) });
    }

    private fun getTitlesForAnswers(userId: Long, forced: Boolean): Single<List<AnswerViewModel>> {
        return detailsRepository.getAnswersByUser(userId, forced)
                .flatMap { answers: List<Answer> ->
                    mapAnswersToAnswerModels(answers, userId, forced)
                }
    }

    private fun mapAnswersToAnswerModels(answers: List<Answer>, userId: Long, forced: Boolean): Single<List<AnswerViewModel>> {
        val ids = answers.map { it.questionId }

        val questionById = detailsRepository.getQuestionsById(ids, userId, forced)

        return questionById.map { questions: List<Question> -> createAnswerViewModels(answers, questions) }
    }

    private fun createAnswerViewModels(answers: List<Answer>, questions: List<Question>): List<AnswerViewModel> {
        return answers.map { (answerId, questionId, score, accepted) ->
            val question = questions.find { it.questionId == questionId }
            AnswerViewModel(answerId, score, accepted, question?.title ?: "unknown")
        }

    }

    private fun createDetailsModel(questions: List<Question>, answers: List<AnswerViewModel>, favorites: List<Question>): DetailsViewModel {
        val questionViewModels = questions.map { QuestionViewModel(it.viewCount, it.score, it.title, it.link, it.questionId) }
        val favoritesViewModels = favorites.map { QuestionViewModel(it.viewCount, it.score, it.title, it.link, it.questionId) }
        return DetailsViewModel(questionViewModels, answers, favoritesViewModels)
    }

}