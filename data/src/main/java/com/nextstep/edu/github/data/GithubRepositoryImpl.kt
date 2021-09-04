package com.nextstep.edu.github.data

import com.nextstep.edu.github.data.entity.RepositoryItem
import com.nextstep.edu.github.data.remote.GithubRemoteDataSource
import com.nextstep.edu.github.domain.GithubRepository
import com.nextstep.edu.github.domain.dto.RepositoryItemDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class GithubRepositoryImpl(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : GithubRepository {

    override suspend fun fetchRepositories(): List<RepositoryItemDto> = withContext(Dispatchers.IO) {
        githubRemoteDataSource
            .fetchRepositories()
            .map(RepositoryItem::toDto)
    }
}