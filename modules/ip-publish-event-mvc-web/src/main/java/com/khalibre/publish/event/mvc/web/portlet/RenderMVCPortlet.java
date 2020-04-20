package com.khalibre.publish.event.mvc.web.portlet;

import com.khalibre.publish.event.mvc.web.constants.PublishMVCPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + PublishMVCPortletKeys.PUBLISHMVC,
        "mvc.command.name=/html/Demo"
    },
    service = MVCRenderCommand.class
)

public class RenderMVCPortlet implements MVCRenderCommand {

  @Override
  public String render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws PortletException {
    return "/html/Demo.jsp";
  }
}
