package com.test.plugin.menu.dynamicmenus;

import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.common.IDfId;
import com.emc.common.java.bundles.MultiResourceBundle;
import com.emc.common.java.xml.XmlNode;
import com.emc.common.java.xml.XmlNodeImpl;
import com.emc.d2fs.dctm.menu.dynamicmenus.IDynamicMenuItem;
import com.emc.d2fs.dctm.ui.dynamicactions.actions.Generic;
import com.emc.d2fs.dctm.web.services.D2fsContext;

import java.util.HashMap;
import java.util.Map;

public class CustomMenu implements IDynamicMenuItem {

    private static MultiResourceBundle resourceBundle;

    @Override
    public XmlNode getXmlMenuItem(D2fsContext d2fsContext) throws Exception {

        IDfSysObject object = (IDfSysObject) d2fsContext.getFirstObject();

        IDfId[] idList = d2fsContext.getListId();
        resourceBundle = d2fsContext.getMenuBundle("CustomMenu");
        XmlNode result = new XmlNodeImpl();
        XmlNode location = result.appendChildNode("menuitem");
        location.setAttribute("id", "genid_0");
        location.setAttribute("label", resourceBundle.getString("customMenu1"));
        location.setAttribute("status", resourceBundle.getString("customMenu1"));
        location.setAttribute("action", resourceBundle.getString("customMenu1"));
        Map<String, Object> locationAttributes = getAttributes();
        location.setAttribute("action", new Generic().getAction(d2fsContext, locationAttributes));

        XmlNode location1 = result.appendChildNode("menuitem");
        location1.setAttribute("id", "genid_1");
        location1.setAttribute("label", resourceBundle.getString("customMenu2"));
        location1.setAttribute("status", resourceBundle.getString("customMenu2"));
        Map<String, Object> location1Attributes = getAttributes();
        location1.setAttribute("action", new Generic().getAction(d2fsContext, location1Attributes));


        return result;
    }

    protected Map<String, Object> getAttributes()
    {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put(Generic.SERVICE, "D2CustomService");
        attributes.put(Generic.METHOD, "copyGILinkToClipboard");
        attributes.put(Generic.MODE, "SINGLE");
        attributes.put(Generic.TYPE, "JS");
        attributes.put(Generic.ACTION, "pasteInClipboard(result)");
        return attributes;
    }
}
