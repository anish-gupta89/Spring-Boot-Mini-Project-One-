<%@page import="com.ag.dto.SearchRequest"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insurance Project</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	$(function() {
		$("#startdate").datepicker();
	});
</script>

<script>
	$(function() {
		$("#enddate").datepicker();
	});
</script>
<body>
	<form:form action="search" modelAttribute="searchdata" method="POST"
		commandName="command">
		<h4 align="center" style="color:red;">Insurance Report Project</h4>
		<div class="container">

			<div class="container text-center">

				<div class="pt-4 row">
					<div class="col">
						<td>Plan Name:</td>
						<td><form:select path="planName">
								<form:option value="-" label="--Please Select--" />
								<form:options items="${planlist}" />
							</form:select></td>
					</div>
					<div class="col">
						<td>Plan Type:</td>
						<td><form:select path="planStatus">
								<form:option value="-" label="--Please Select--" />
								<form:options items="${planstatus}" />
							</form:select></td>
					</div>
					<div class="col">

						<td>Gender:</td>
						<td><form:select path="gender">
								<form:option value="-" label="--Please Select--" />
								<form:options items="${gender}" />
							</form:select></td>
					</div>
					<div class="row mt-4">
						<div class="col">
							Start Date
							<form:input path="planStartDate" type="text" id="startdate" />
						</div>
						<div class="col">
							End Date
							<form:input path="planEndDate" type="text" id="enddate" />
						</div>
					</div>
					</br> </br>
					<div class="row mt-2">
						<div class="col-md-2 w-50">
							<button width="100px" type="Submit" class="btn btn-primary">Search</button>
						</div>
						<div class="col">
							<button width="100px" type="button" class="btn btn-danger"
								onclick="window.location='/'">Clear</button>
						</div>

					</div>
				</div>
			</div>


		</div>

		</br>
		</br>
		<div class="container text-center">
			<%
			List<SearchRequest> req = (ArrayList<SearchRequest>) request.getAttribute("data");
			if (req == null) {%>
				 <div class="toast-body">
				    No records available.
				  </div>
			<%	return;
			} else {
			%>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Gender</th>
						<th scope="col">Plan</th>
						<th scope="col">Status</th>
						<th scope="col">Start Date</th>
						<th scope="col">End Date</th>
						<th scope="col">Amount</th>
						<th scope="col">Denial Rsn</th>
						<th scope="col">Terminated D</th>
						<th scope="col">Terminated Rsn</th>
					</tr>
				</thead>

				<%
				}
				for (int i = 0; i < req.size(); i++) {
				%>
				<tbody>
					<tr>
						<th scope="row"><%=req.get(i).getId()%></th>
						<td><%=req.get(i).getCitizenName()%></td>
						<td><%=req.get(i).getGender()%></td>
						<td><%=req.get(i).getPlanName()%></td>
						<td><%=req.get(i).getPlanStatus()%></td>
						<td><%=req.get(i).getPlanStartDate()%></td>
						<td><%=req.get(i).getPlanEndDate()%></td>
						<td><%=req.get(i).getBenefitAmount()%></td>
						<td><%=req.get(i).getDenialRsn()%></td>
						<td><%=req.get(i).getTerminatedDate()%></td>
						<td><%=req.get(i).getTerminationRsn()%></td>
					</tr>
				</tbody>
				<%
				}
				%>
			</table>
			<link rel="stylesheet"
				href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
			<a class="fa fa-download" href="/export?type=csv"> CSV</a>
			</t><a class="fa fa-download" href="/export?type=pdf"> PDF</a>
		</div>
	</form:form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous">
		
	</script>
</body>
</html>