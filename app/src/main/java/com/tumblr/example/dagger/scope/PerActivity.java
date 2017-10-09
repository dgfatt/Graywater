package com.tumblr.example.dagger.scope;

import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ericleong on 10/9/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
