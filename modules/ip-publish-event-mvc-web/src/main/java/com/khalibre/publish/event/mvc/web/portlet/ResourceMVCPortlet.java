package com.khalibre.publish.event.mvc.web.portlet;

import com.khalibre.publish.event.mvc.web.constants.PublishMVCPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + PublishMVCPortletKeys.PUBLISHMVC,
        "mvc.command.name=resourceEvent"
    },
    service = MVCResourceCommand.class
)

public class ResourceMVCPortlet implements MVCResourceCommand {

  @Override
  public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
      throws PortletException {
    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    jsonObject.put("name","vireak");
    jsonObject.put("gender","male");
    jsonObject.put("age","20");
    try {
      JSONPortletResponseUtil.writeJSON(resourceRequest,resourceResponse,jsonObject);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }
}
