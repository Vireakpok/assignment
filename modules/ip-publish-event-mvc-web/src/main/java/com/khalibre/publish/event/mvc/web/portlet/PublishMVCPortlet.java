package com.khalibre.publish.event.mvc.web.portlet;

import com.khalibre.publish.event.mvc.web.constants.PublishMVCPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

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
		"javax.portlet.display-name=PublishMVC",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PublishMVCPortletKeys.PUBLISHMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-publishing-event=name;http://www.liferay.com"
	},
	service = Portlet.class
)
public class PublishMVCPortlet extends MVCPortlet {
}