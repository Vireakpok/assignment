package com.khalibre.publish.event.mvc.web.portlet;

import com.khalibre.publish.event.mvc.web.constants.PublishMVCPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;
import org.osgi.service.component.annotations.Component;

@Component (
    immediate = true,
    property = {
        "javax.portlet.name=" + PublishMVCPortletKeys.PUBLISHMVC,
        "mvc.command.name=publisher"
    },
    service = MVCActionCommand.class
)

public class ActionMVCPortlet implements MVCActionCommand {

  @Override
  public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
      throws PortletException {
      handlePublisherEvent(actionRequest,actionResponse);
    return true;
  }
  public void handlePublisherEvent(ActionRequest actionRequest,ActionResponse actionResponse) {
    String name = ParamUtil.getString(actionRequest, "name");
    String gender = ParamUtil.getString(actionRequest, "gender");
    String age = ParamUtil.getString(actionRequest,"age");

    JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    jsonObject.put("name",name);
    jsonObject.put("gender",gender);
    jsonObject.put("age",age);

    QName qName = new QName("http://www.liferay.com","name");

    actionResponse.setEvent(qName,jsonObject.toString());

    actionResponse.setRenderParameter("name", name);
    actionResponse.setRenderParameter("gender",gender);
    actionResponse.setRenderParameter("age",age);

    actionResponse.setRenderParameter("mvcPath","/html/Demo.jsp");
  }
}
