<%@ include file="/init.jsp" %>

<%
  String name = renderRequest.getParameter("name");
  String gender = renderRequest.getParameter("gender");
  String age = renderRequest.getParameter("age");
  if( name == null || gender == null || age ==null) {
    name = gender = age = "" ;
  }
%>

<h1>Module 1 Process Event</h1>

<h3 class="text-danger"><%= name %></h3>
<h3 class="text-danger"><%= gender %></h3>
<h3 class="text-danger"><%= age %></h3>

<aui:button onClick="getData()" value="Request data to fill in form"/>
<h5 class="text-primary" id="name"></h5>
<h5 class="text-primary" id="gender"></h5>
<h5 class="text-primary" id="age"></h5>

<portlet:actionURL name="publisher" var="publisherUrl" />
<h1 class="text-primary">Module 1 Publisher Events</h1>
<aui:form action="<%= publisherUrl %>" name="frm">
   <aui:input name="name" label="name" />
   <aui:select name="gender">
    <aui:option label="male" />
    <aui:option label="female" />
   </aui:select>
   <aui:input name="age" label="age" />
   <aui:button type="submit" value="send" />
</aui:form>

<portlet:resourceURL id="resourceEvent" var="resourceUrl" />
<aui:script>
  function getData() {
      AUI().use('aui-io-request', function(A) {
          A.io.request('<%= resourceUrl %>' , {
              method: 'get',
              on: {
                 success: function() {
                  var data = this.get('responseData');
                  var obj = JSON.parse(data);
                  document.getElementById("name").innerHTML = obj.name;
                  document.getElementById("gender").innerHTML = obj.gender;
                  document.getElementById("age").innerHTML = obj.age;
                 }
              }
          });
        });
  }
</aui:script>