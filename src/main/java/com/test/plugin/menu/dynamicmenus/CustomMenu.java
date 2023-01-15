package com.test.plugin.menu.dynamicmenus;

import com.emc.common.java.bundles.MultiResourceBundle;
import com.emc.common.java.xml.XmlNode;
import com.emc.common.java.xml.XmlNodeImpl;
import com.emc.d2fs.dctm.menu.dynamicmenus.IDynamicMenuItem;
import com.emc.d2fs.dctm.web.services.D2fsContext;

public class CustomMenu implements IDynamicMenuItem {

    private static MultiResourceBundle resourceBundle;

    @Override
    public XmlNode getXmlMenuItem(D2fsContext d2fsContext) throws Exception {

        resourceBundle = d2fsContext.getMenuBundle("CustomMenu");
        XmlNode result = new XmlNodeImpl();
        XmlNode location = result.appendChildNode("menuitem");
        location.setAttribute("id", "genid_0");
        location.setAttribute("label", resourceBundle.getString("customMenu1"));
        location.setAttribute("status", resourceBundle.getString("customMenu1"));
        XmlNode location1 = result.appendChildNode("menuitem");
        location1.setAttribute("id", "genid_1");
        location1.setAttribute("label", resourceBundle.getString("customMenu2"));
        location1.setAttribute("status", resourceBundle.getString("customMenu2"));
        return result;
    }
}
