<%@ include file="/init.jsp" %>

<%
  String name = renderRequest.getParameter("name");
  String gender = renderRequest.getParameter("gender");
  String age = renderRequest.getParameter("age");
  if( name == null || gender == null || age ==null) {
    name = gender = age = "" ;
  }
%>

<h1>Module 2 Process Event</h1>
<h3 class="text-danger"><%= name %></h3>
<h3 class="text-danger"><%= gender %></h3>
<h3 class="text-danger"><%= age %></h3>