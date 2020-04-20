<%@ include file="/init.jsp" %>

<%
  String name = renderRequest.getParameter("name");
  String gender = renderRequest.getParameter("gender");
  String age = renderRequest.getParameter("age");
%>

<h1>Module 1 Publisher Events</h1>
<h3 class="text-primary"><%= name %></h3>
<h3 class="text-primary"><%= gender %></h3>
<h3 class="text-primary"><%= age %></h3>