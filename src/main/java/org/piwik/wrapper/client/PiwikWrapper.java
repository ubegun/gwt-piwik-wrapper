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


import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Timer;

/**
 * Created by ubegun on 7/4/2016.
 */
public class PiwikWrapper {

    private final static String DEFAULT_SERVER_URL = "//127.0.0.1/";

    interface PiwikWrapperUiBinder extends UiBinder<ScriptElement, PiwikWrapper> {
    }

    private static PiwikWrapperUiBinder ourUiBinder = GWT.create(PiwikWrapperUiBinder.class);

    private PiwikWrapper() {
    }

    public static PiwikWrapper instance = new PiwikWrapper();


    public PiwikConfig getConfig(String piwikUrl, int siteId) {
        initLoader(piwikUrl, siteId);
        return new PiwikConfig() {

            @Override
            public native void enableLinkTracking() /*-{
                $wnd._paq.push(['enableLinkTracking']);
            }-*/;

            @Override
            public native void setDocumentTitle(String title) /*-{
                $wnd._paq.push(['setDocumentTitle', title]);
            }-*/;

            @Override
            public native void trackPageView() /*-{
                $wnd._paq.push(['trackPageView']);
            }-*/;

        };
    }

    private native void initLoader(String piwikUrl, int siteId) /*-{
        $wnd.rootUrl = piwikUrl || "//127.0.0.1/";
        $wnd.thisSiteId = siteId || 1;
        $wnd.piwikLoader = function () {
            $wnd._paq.push(['setTrackerUrl', $wnd.rootUrl + 'piwik.php']);
            $wnd._paq.push(['setSiteId', $wnd.thisSiteId]);
            var thisDoc = $doc, thisScript = thisDoc.createElement('script'), firstScript = thisDoc.getElementsByTagName('script')[0];
            thisScript.type = 'text/javascript';
            thisScript.async = true;
            thisScript.defer = true;
            thisScript.src = $wnd.rootUrl + 'piwik.js';
            firstScript.parentNode.insertBefore(thisScript, firstScript);
        };
    }-*/;

    public void execute() {
        Timer t = new Timer() {

            @Override
            public native void run() /*-{
                $wnd.piwikLoader();
            }-*/;
        };
        t.schedule(0);
    }

}