package ru.summary.mysummaryproject.di.global.user

import dagger.Binds
import dagger.Module
import ru.summary.mysummaryproject.data.users.UsersRepositoryImpl
import ru.summary.mysummaryproject.di.UserScope
import ru.summary.mysummaryproject.domain.repositories.UsersRepository
import javax.inject.Singleton

@Module
abstract class UserModule {
    @Binds
    @Singleton
    abstract fun provideUserRepository(repository: UsersRepositoryImpl): UsersRepository
}