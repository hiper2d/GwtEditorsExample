package com.hiper2d.client.resourcebundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * Created by nodi on 23.01.16.
 */
public interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source("gss/basic.gss")
    BasicGss basic();
}
