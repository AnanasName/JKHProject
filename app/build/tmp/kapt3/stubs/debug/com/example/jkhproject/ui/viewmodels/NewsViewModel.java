package com.example.jkhproject.ui.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\rR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/jkhproject/ui/viewmodels/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "newsRepository", "Lcom/example/jkhproject/data/repositories/NewsRepository;", "(Lcom/example/jkhproject/data/repositories/NewsRepository;)V", "_news", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/jkhproject/data/models/network/NewsNetModel;", "news", "Lkotlinx/coroutines/flow/StateFlow;", "getNews", "()Lkotlinx/coroutines/flow/StateFlow;", "", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.jkhproject.data.repositories.NewsRepository newsRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.jkhproject.data.models.network.NewsNetModel>> _news = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.jkhproject.data.models.network.NewsNetModel>> news = null;
    
    @javax.inject.Inject()
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.jkhproject.data.repositories.NewsRepository newsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.jkhproject.data.models.network.NewsNetModel>> getNews() {
        return null;
    }
    
    public final void getNews() {
    }
}