package com.example.jkhproject;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = JkhApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface JkhApplication_GeneratedInjector {
  void injectJkhApplication(JkhApplication jkhApplication);
}
