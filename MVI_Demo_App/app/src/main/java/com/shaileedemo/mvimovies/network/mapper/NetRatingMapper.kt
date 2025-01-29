package com.shaileedemo.mvimovies.network.mapper

import com.shaileedemo.mvimovies.domain.valueobj.DomainRating
import com.shaileedemo.mvimovies.network.model.RemoteRating
import javax.inject.Inject

class NetRatingMapper @Inject constructor() {

    fun List<RemoteRating>.fromRemoteToDomain() = map { remoteRating ->
        remoteRating.fromRemoteToDomain()
    }

    fun RemoteRating.fromRemoteToDomain() = DomainRating(
        source = source,
        value = value
    )
}
