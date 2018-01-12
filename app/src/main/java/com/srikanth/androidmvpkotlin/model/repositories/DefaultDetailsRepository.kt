package com.srikanth.androidmvpkotlin.model.repositories

import com.srikanth.androidmvpkotlin.model.entities.Answer
import com.srikanth.androidmvpkotlin.model.entities.Question
import com.srikanth.androidmvpkotlin.model.persistence.dao.AnswerDao
import com.srikanth.androidmvpkotlin.model.persistence.dao.FavoritedByUserDao
import com.srikanth.androidmvpkotlin.model.persistence.dao.QuestionDao
import com.srikanth.androidmvpkotlin.model.services.QuestionService
import com.srikanth.androidmvpkotlin.model.services.UserService
import com.srikanth.androidmvpkotlin.utils.CalendarWrapper
import com.srikanth.androidmvpkotlin.utils.ConnectionHelper
import com.srikanth.androidmvpkotlin.utils.PreferencesHelper
import io.reactivex.Single


class DefaultDetailsRepository(private val userService: UserService,
                               private val questionService: QuestionService,
                               private val questionDao: QuestionDao,
                               private val answerDao: AnswerDao,
                               private val favoritedByUserDao: FavoritedByUserDao,
                               private val connectionHelper: ConnectionHelper,
                               private val preferencesHelper: PreferencesHelper,
                               private val calendarWrapper: CalendarWrapper) : DetailsRepository {
    override fun getQuestionsByUser(userId: Long, forced: Boolean): Single<List<Question>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAnswersByUser(userId: Long, forced: Boolean): Single<List<Answer>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoritesByUser(userId: Long, forced: Boolean): Single<List<Question>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getQuestionsById(ids: List<Long>, userId: Long, forced: Boolean): Single<List<Question>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}