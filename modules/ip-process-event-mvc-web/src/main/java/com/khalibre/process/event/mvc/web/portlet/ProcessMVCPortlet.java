package com.khalibre.process.event.mvc.web.portlet;

import com.khalibre.process.event.mvc.web.constants.ProcessMVCPortletKeys;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;

import javax.portlet.ProcessEvent;
import org.osgi.service.component.annotations.Component;

/**
 * @author vireakp
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProcessMVC",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProcessMVCPortletKeys.PROCESSMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-processing-event=name;http://www.liferay.com"
	},
	service = Portlet.class
)
public class ProcessMVCPortlet extends MVCPortlet {
	@ProcessEvent(qname = "{http://www.liferay.com}name")
	public void processHandleEvent(EventRequest eventRequest, EventResponse eventResponse)
			throws JSONException {
		Event event = eventRequest.getEvent();
		String name = (String) event.getValue();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(name);

		for (String keys: jsonObject.keySet()
		) {
			Object values = jsonObject.get(keys);
			eventResponse.setRenderParameter(keys,values.toString());
		}
	}
}