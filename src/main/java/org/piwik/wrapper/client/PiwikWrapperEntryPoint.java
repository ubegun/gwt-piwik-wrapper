package org.piwik.wrapper.client;

/*
 * #%L
 * GwtPiwikWrapper
 * %%
 * Copyright (C) 2013 - 2016 Ubegun
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.user.client.ui.*;

/**
 * Created by ubegun on 7/4/2016.
 */
public class PiwikWrapperEntryPoint implements EntryPoint {
    public void onModuleLoad() {
        ScriptInjector.fromString("var _paq = _paq || [];").setWindow(ScriptInjector.TOP_WINDOW).inject();
    }
}
