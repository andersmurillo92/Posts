package com.andersmurillo92.posts.di

import com.andersmurillo92.posts.data.network.PostsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val baseUrl = "https://jsonplaceholder.typicode.com/"

        val authInterceptor = Interceptor { chain ->
            val url = chain.request().url.newBuilder()
                .build()
            val newRequest = chain.request()
                .newBuilder()
                .url(url)
                .build()
            chain.proceed(newRequest)
        }

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePostsApiClient(retrofit: Retrofit): PostsApiClient
            = retrofit.create(PostsApiClient::class.java)
}