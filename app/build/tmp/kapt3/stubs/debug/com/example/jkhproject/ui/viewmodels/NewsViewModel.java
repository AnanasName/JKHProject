package com.example.jkhproject.ui.viewmodels;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/jkhproject/ui/viewmodels/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "newsRepository", "Lcom/example/jkhproject/data/repositories/NewsRepository;", "(Lcom/example/jkhproject/data/repositories/NewsRepository;)V", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.jkhproject.data.repositories.NewsRepository newsRepository = null;
    
    @javax.inject.Inject()
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.jkhproject.data.repositories.NewsRepository newsRepository) {
        super();
    }
}