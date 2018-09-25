package com.joaquimley.transporteta.presentation.home.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.joaquimley.transporteta.domain.interactor.favorites.ClearAllTransportsAsFavoriteUseCase
import com.joaquimley.transporteta.domain.interactor.favorites.GetFavoritesUseCase
import com.joaquimley.transporteta.domain.interactor.favorites.MarkTransportAsFavoriteUseCase
import com.joaquimley.transporteta.domain.interactor.favorites.MarkTransportAsNoFavoriteUseCase
import com.joaquimley.transporteta.domain.interactor.transport.CancelEtaRequestUseCase
import com.joaquimley.transporteta.domain.interactor.transport.RequestEtaUseCase
import com.joaquimley.transporteta.presentation.data.Resource
import com.joaquimley.transporteta.presentation.mapper.TransportMapper
import com.joaquimley.transporteta.presentation.model.TransportView

abstract class FavoritesViewModel(protected val getFavoritesUseCase: GetFavoritesUseCase,
                                  protected val markTransportAsFavoriteUseCase: MarkTransportAsFavoriteUseCase,
                                  protected val markTransportAsNoFavoriteUseCase: MarkTransportAsNoFavoriteUseCase,
                                  protected val clearAllTransportsAsFavoriteUseCase: ClearAllTransportsAsFavoriteUseCase,
                                  protected val requestEtaUseCase: RequestEtaUseCase,
                                  protected val cancelEtaRequestUseCase: CancelEtaRequestUseCase,
                                  protected val mapper: TransportMapper) : ViewModel() {

    abstract fun getFavorites(): LiveData<Resource<List<TransportView>>>

    abstract fun onRefresh()

    abstract fun onEtaRequested(transportView: TransportView)

    abstract fun onEtaRequestCanceled()

    abstract fun isAcceptingRequests(): LiveData<Boolean>

    abstract fun markAsFavorite(transportView: TransportView, isFavorite: Boolean)

    abstract fun removeAllFavorites()
}